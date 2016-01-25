package utils;


import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.util.*;
import java.util.concurrent.TimeUnit;
//@Component("redisOperateUtil")
/**
 * Description:redis 操作工具类
 * Created  2016/1/22 17:31  by xinghaifang
 */
public class RedisOperateUtil extends AbstractBaseRedisAdapter<String, String> {
	/**
	 * master库新增,未设置失效时间,当内存不足时,可配置写入到磁盘中.不配置的话,会自动删除老数据,并写入新数据.
	 * @param key redis key
	 * @param value redis key中的value值.
	 * @return
	 */
	public void masterAdd(final String key, final String value) {
		masterRedisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getMasterStringSerializer();
				byte[] key1 = serializer.serialize(key);
				byte[] value1 = serializer.serialize(value);
				connection.set(key1, value1);
				return true;
			}
		});
	}
	
	/**
	 * 新增, 设置有效时间
	 * @param key
	 * @param liveTime 设置redis失效时间,秒
	 * @param value redis key value值.
	 * @return
	 */
	public void masterAdd(final String key, final long liveTime, final String value) {
		masterRedisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getMasterStringSerializer();
				byte[] key1 = serializer.serialize(key);
				byte[] value1 = serializer.serialize(value);
				connection.setEx(key1, liveTime, value1);
				return true;
			}
		});
	}
	
	/**
	 * Description: 批量保存redis
	 * @param tuple
	 * @return
	 */
	public boolean masterMAdd(final Map<String, String> tuple) {
		boolean result = masterRedisTemplate
				.execute(new RedisCallback<Boolean>() {
					public Boolean doInRedis(RedisConnection connection)
							throws DataAccessException {
						connection.mSet(serialize(tuple));
						return true;
					}
				});
		return result;
	}

	/**
	 *
	 *master 删除redis key
	 * @param key
	 */
	public void masterDeleteByKey(String key) {
		List<String> list = new ArrayList<String>();
		list.add(key);
		mastarDeleteByKeys(list);
	}

	/**
	 * master 删除多个keys
	 * @param keys
	 */
	public void mastarDeleteByKeys(List<String> keys) {
		masterRedisTemplate.delete(keys);
	}

	/**
	 * slave 通过key获取
	 * @param  keyId
	 * @return
	 */
	public String slaveGet(final String keyId) {
		String result = slaveRedisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getSlaveStringSerializer();
				byte[] key = serializer.serialize(keyId);
				byte[] value = connection.get(key);
				if (value == null) {
					return null;
				}
				String result = serializer.deserialize(value);
				return result;
			}
		});
		return result;
	}
	
	/**
	 * Description: 如果是一次获取多个key值得话，我们返回值有序list，key1对应的是list中索引为0的数据
	 * @param keys 多个 redis key传入
	 * @return
	 */
	public List<String> slaveMGet(final List<String> keys) {
		List<String> results = slaveRedisTemplate.execute(new RedisCallback<List<String>>() {
			public List<String> doInRedis(RedisConnection connection)
					throws DataAccessException {
				List<String> retults = new ArrayList<String>();
				RedisSerializer<String> serializer = getSlaveStringSerializer();
				byte[][] ret = new byte[keys.size()][];

				for (int i = 0; i < ret.length; i++) {
					ret[i] = serializer.serialize(keys.get(i));
				}
				List<byte[]> value = connection.mGet(ret);
				if (value == null) {
					return null;
				}else{
					for(int i = 0; i < value.size(); i++){
						String result = serializer.deserialize(value.get(i));
						if(StringUtils.isNotBlank(result) && !"null".equals(result)){
							retults.add(result);
						}
					}
				}
				return retults;
			}
		});
		return results;
	}
	
	/**
	 * Description: 如果是一次获取多个key值得话，我们返回值有序list，key1对应的是list中索引为0的数据
	 * @param   keys
	 * @return
	 */
	public List<String> slaveMGet(final String... keys) {
		List<String> resultValues = new ArrayList<String>();
		String results = slaveRedisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection)
					throws DataAccessException {
				StringBuffer retults = new StringBuffer();
				RedisSerializer<String> serializer = getSlaveStringSerializer();
				byte[][] ret = new byte[keys.length][];

				for (int i = 0; i < ret.length; i++) {
					ret[i] = serializer.serialize(keys[i]);
				}
				List<byte[]> value = connection.mGet(ret);
				if (value == null) {
					return null;
				}else{
					for(int i = 0; i < value.size(); i++){
						String result = serializer.deserialize(value.get(i));
						if(retults.length() > 0){
							retults.append("&*&").append(result);
						}else{
							retults.append(result);
						}
					}
				}
				return retults.toString();
			}
		});
		
		if(StringUtils.isNotBlank(results)){
			String[] values = results.split("&*&");
			if(values.length > 0){
				for(String value : values){
					resultValues.add(value);
				}
				
			}
		}
		return resultValues;
	}
	
	/**
	 * Description: 设置 多个 key的有效时间 ,延长key的失效时间
	 * @param keys
	 * @param liveTime 单位是（秒）
	 */
	public void expire(List<String> keys, long liveTime){
		for(String key : keys){
			masterRedisTemplate.expire(key, liveTime, TimeUnit.SECONDS);
		}
	}
	
	/**
	 * Description: 查询一个key是否存在
	 * @param  key
	 * @return
	 */
	public boolean hasKey(String key) {
		return slaveRedisTemplate.hasKey(key);
	}
	
	/**
	 * Description: 查询一个key list是否存在.
	 * @param keys
	 * @return
	 */
	public boolean hasKeys(List<String> keys) {
		for(String key : keys){
			boolean flag = slaveRedisTemplate.hasKey(key);
			if(!flag){
				return false;
			}
		}
		return true;
	}

	/**
	 * 序列化map
	 * @param hashes
	 * @return
	 */
	public Map<byte[], byte[]> serialize(Map<String, String> hashes) {
		Map<byte[], byte[]> ret = new LinkedHashMap<byte[], byte[]>(hashes.size());
		RedisSerializer<String> serializer = getMasterStringSerializer();
		for (Map.Entry<String, String> entry : hashes.entrySet()) {
			ret.put(serializer.serialize(entry.getKey()), serializer.serialize(entry.getValue()));
		}

		return ret;
	}
	
	/**
	 * Description: 存放有续集合
	 * @param key
	 * @param value
	 * @param score
	 * @return
	 */
	public boolean masterOpsForZSetAdd(String key, String value, double score) {
		return masterRedisTemplate.opsForZSet().add(key, value, score);
	}
	
	/**
	 * Description: 获取有续集合
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public Set<String> slaveOpsForZSet(String key, Long start, Long end) {
		return slaveRedisTemplate.opsForZSet().range(key, start, end);
	}
}

package utils;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * Description:redis 操作
 * Created  2016/1/22 17:31  by xinghaifang
 */
@Service
public class AbstractBaseRedisAdapter<K, V> {
	@Resource(name="masterRedisTemplate")
    protected RedisTemplate<K, V> masterRedisTemplate;  
	@Resource(name="slaveRedisTemplate")
    protected RedisTemplate<K, V> slaveRedisTemplate;  
  
    /** 
     * 设置masterRedisTemplate 
     * @param masterRedisTemplate the redisTemplate to set
     */  
    public void setMasterRedisTemplate(RedisTemplate<K, V> masterRedisTemplate) {  
        this.masterRedisTemplate = masterRedisTemplate;  
    }  
    
    /** 
     * 设置slaveRedisTemplate 
     * @param slaveRedisTemplate the redisTemplate to set
     */  
    public void setSlaveRedisTemplate(RedisTemplate<K, V> slaveRedisTemplate) {  
        this.slaveRedisTemplate = slaveRedisTemplate;  
    }  
      
    /** 
     * 获取 RedisSerializer 
     */
    protected RedisSerializer<String> getMasterStringSerializer() {  
        return masterRedisTemplate.getStringSerializer();  
    } 
    
    /** 
     * 获取 RedisSerializer 
     */
    protected RedisSerializer<String> getSlaveStringSerializer() {  
        return slaveRedisTemplate.getStringSerializer();  
    } 
}

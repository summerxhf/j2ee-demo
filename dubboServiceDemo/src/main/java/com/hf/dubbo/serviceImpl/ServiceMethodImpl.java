package com.hf.dubbo.serviceImpl;

import com.hf.dubbo.service.ServiceMethod;

/**
 * Created by xinghaifang on 2015/8/26.
 */
public class ServiceMethodImpl implements ServiceMethod {
    public String delProject(String projectId) {
        return "调用远程service已经完毕,项目id是:"+projectId;
    }
}

package com.hf.dubbo.actionMain;

import com.hf.dubbo.service.ServiceMethod;
    import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xinghaifang on 2015/8/26.
 */
public class ClientMain {
    public static void main(String[] args) throws Exception{
        //加载spirng配置文件.
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationConsumer.xml"});
        context.start();
        //调用远程接口.
        ServiceMethod serviceMethod = (ServiceMethod) context.getBean("serviceMethodImpl");
        //循环调用远程接口的方法.
        int i=0;
        while(i++<100){
            String strRet = serviceMethod.delProject("66");
            System.out.println(strRet);
            Thread.sleep(3000);//3s执行
        }

    }

}

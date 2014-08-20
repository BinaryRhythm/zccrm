package com.ccit.service.core;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.ccit.dao.core.TransactionManager;

/**
 * 根据service接口名生成service的实现对象，并且是代理对象，增加了事务
 * 读取classpath下的service.properties文件，key为service接口名，value为service接口的实现类
 * @author BinaryRhythm
 *
 */
public class ServiceFactory {

	private static final Logger log = Logger.getLogger(ServiceFactory.class);
	
	private static Map<String,Object> services = new HashMap<String,Object>();
	private static ResourceBundle serviceconfig = ResourceBundle.getBundle("service");
	
	/**
	 * 根据service接口名生成接口实现类的对象
	 * @param serviceName
	 * @return 返回代理对象，增加了事务
	 */
	public static Object getService(String serviceName){
		Object obj = services.get(serviceName);
		if(null == obj){
			String serviceImp = serviceconfig.getString(serviceName);
						if(null == serviceImp){
				log.error("请检查service.properties");
			}else{
				try{
					obj = Class.forName(serviceImp).newInstance();
					services.put(serviceName, obj);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		// 返回service接口的代理对象，在原service功能之上增加了事务操作
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
				obj.getClass().getInterfaces(), new TransactionManager(obj));
	}
	
}

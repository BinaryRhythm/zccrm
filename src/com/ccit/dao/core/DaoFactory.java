package com.ccit.dao.core;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * dao的工厂类
 * @author BinaryRhythm
 *
 */
public class DaoFactory {

	private static final Logger log = Logger.getLogger(DaoFactory.class);
	// 缓冲dao名和dao实现类的map
	private static Map<String, Object> daos = new HashMap<String, Object>();
	private static ResourceBundle daoconfig = ResourceBundle.getBundle("dao");

	/**
	 * 通过dao的名字来生成dao的实现类对象
	 * @param daoName
	 * @return
	 */
	public static Object getDao(String daoName) {
		Object daoimp = daos.get(daoName);
		if (null == daoimp) {
			String impClass = daoconfig.getString(daoName);
			if (null == impClass) {
				log.error("请检查dao.properties01");
			} else {
				try {
					daoimp = (Object) Class.forName(impClass).newInstance();
					daos.put(daoName, daoimp);
				} catch (Exception e) {
					log.error("请检查dao.properties02");
					e.printStackTrace();
				}
			}
		}
		return daoimp;
	}

}

package com.jh.common.util.date.sequence;

import cn.hutool.core.date.DatePattern;

import java.util.Date;

/**
 * @Title: GenerateIdsUtil.java
 * @Description: 生成各类业务ID
 * @date
 **/
public class GenerateIdsUtil {

	private static int incrementGlobal = 0;

	/**
	 * 带自定义前缀的ID生成
	 * 
	 * @param prefixKey
	 *            自定义的0-7位前缀
	 * @return
	 */
	public static String generateId(String prefixKey) {
		return prefixKey + generateId();
	}

    /**
     * 尾数
     * @return
     */
	private static synchronized int getIncrement() {
		if (incrementGlobal == 99) {
			incrementGlobal = 0;
		}
		return ++incrementGlobal;
	}

	/**
	 * 17位时间戳+2位自增数字
	 * @return
	 */
	public static synchronized String generateId() {
		String increment = String.format("%02d", getIncrement());
		String timeStr = DatePattern.PURE_DATETIME_MS_FORMAT.format(new Date());
		StringBuilder builder = new StringBuilder(timeStr);
		builder.append(increment);
		return builder.toString();
	}
	
}

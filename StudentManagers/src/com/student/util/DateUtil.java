package com.student.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date stringToDate(String str, String format) throws Exception {

		if (StringUtil.isEmpty(str)) {
			throw new Exception("パラメータ不正です。");
		}
		SimpleDateFormat sdFormat = new SimpleDateFormat(format);
        Date date = sdFormat.parse(str);
		return date;
	}

	public static String dateToString (Date date, String format) {

		SimpleDateFormat sdFormat = new SimpleDateFormat(format);
		String dateStr = sdFormat.format(date);
		return dateStr;
	}
}

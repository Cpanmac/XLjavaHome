package com.xl.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String getNow() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:ddhhmm");
		return sdf.format(new Date());
	}
}

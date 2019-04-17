package com.bawei.cms.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

/**
 *字符串 到 日期 的转换器类  
 */
//String----Date

public class StringToDateFormat  implements  Formatter<Timestamp>{
	@Override
	public Timestamp parse(String dateStr, Locale arg1) {
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				date =  sdf.parse(dateStr);
			} catch (ParseException e1) {
				sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
				try {
					date = sdf.parse(dateStr);
				} catch (ParseException e2) {
				}
			}
		}
		return  new Timestamp(date.getTime());
	}
	
	
	@Override
	public String print(Timestamp arg0, Locale arg1) {
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return sdf.format(arg0);
	}
}

package com.yeecharge.util;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeFormatter {
	
//	public static Timestamp formatTimestamp(String rawTimestamp){
//		
//		
//	}
	public static Timestamp formatTime(String inputtimestamp) throws Exception{
		
		//部署充电桩时 部署时间的格式
		//去掉多余字符
		String install_time1 = inputtimestamp.replace("T"," ")+":00";
		
//		处理完后的格式："2016-11-11 11:11:00";
		
		//格式转换
		return Timestamp.valueOf(install_time1);
	}
	
	public static void main(String[] args) throws Exception {
//		formatTime();
	}
	
}

package com.bytesnapper.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.bytesnapper.zaman.DateUtil;

public class ResetTime {

	@Test
	public void test() {
		Date inputDate= new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date outputDate=DateUtil.resetTime(inputDate);
//		String dateStrIn= format.format(inputDate);
		String outputDateStr= format.format(outputDate);
		//System.out.println(dateStrIn);
		//System.out.println(dateStrOut);
		if(!outputDateStr.equals("00:00:00")){
			fail("Time is not reset");
		}
	}

}

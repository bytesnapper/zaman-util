package com.bytesnapper.test;

import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.bytesnapper.zaman.common.Interval;
import com.bytesnapper.zaman.exceptions.NegativeIntervalException;
import com.bytesnapper.zaman.util.DateUtil;

public class SubtractDate {

	@Test
	public void test() {
	 Calendar calendar=Calendar.getInstance();
	 Date first = calendar.getTime();  
//	 System.out.println("First "+first);
	 calendar.add(Calendar.DATE, 1);	 
	 Date second = calendar.getTime();
//	 System.out.println("second "+second);

	 Interval interval = DateUtil.subtractDate(first, second) ;
	 
	/* System.out.println("Seconds "+interval.getSeconds());
	 System.out.println("Minutes "+interval.getMinutes());
	 System.out.println("Hours "+interval.getHours());
	 System.out.println("Days: "+interval.getDays());
	 System.out.println("Month "+interval.getMonths());
	 System.out.println("Years "+interval.getYears());
	 
	 System.out.println("To Months "+interval.convertToMonths());
	 System.out.println("To Days "+interval.convertToDays());
	 System.out.println("To Hours "+interval.convertToHours());
	 System.out.println("To Mins "+interval.convertToMinutes());
	 System.out.println("To Secs "+interval.convertToSeconds());*/


	 

	 
	 
	 if(first.before(second) && interval.getYears()<1 && interval.getDays()<1 && interval.getHours()<1 && interval.getMinutes()<1 && interval.getSeconds()<1){
			fail("First date is before second date so interval elements cannot be less than one");
	 }	
	 
	 if(interval.getMinutes()>59||interval.getSeconds()>59){
		 fail("Mintes and seconds cannot be more than 29");
	 }
	 
	 if(interval.getHours()>23){
		 fail("Hours cannot be more than 29");
	 }

	 
	 if(interval.getDays()>29){
		 fail("Days cannot be more than 29");
	 }
	
	 if(interval.getMonths()>11){
		 fail("Months cannot be more than 29");
	 }
	


	}
}

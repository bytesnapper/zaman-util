package com.bytesnapper.test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.bytesnapper.zaman.common.Interval;
import com.bytesnapper.zaman.exceptions.NegativeIntervalException;
import com.bytesnapper.zaman.util.DateUtil;

public class NegativeInterval {

	@Test
	public void test() {
		try{
			 Calendar calendar=Calendar.getInstance();
			 calendar.add(Calendar.DATE, 365);	 
			 Date fromDate = calendar.getTime();  
			 System.out.println("First "+fromDate);
			 calendar.setTime(new Date());
			 Date toDate = calendar.getTime();
			 System.out.println("second "+toDate); 
			 Interval interval = DateUtil.subtractDate(fromDate, toDate) ;			 
			/* System.out.println("Seconds "+interval.getSeconds());
			 System.out.println("Minutes "+interval.getMinutes());
			 System.out.println("Hours "+interval.getHours());
			 System.out.println("Days: "+interval.getDays());
			 System.out.println("Month "+interval.getMonths());
			 System.out.println("Years "+interval.getYears());*/
			 if(fromDate.after(toDate)){
			 fail("No exeption is thrown and first ate ");
			 }
		}catch(NegativeIntervalException e){
			//e.printStackTrace();
		}
	}

}

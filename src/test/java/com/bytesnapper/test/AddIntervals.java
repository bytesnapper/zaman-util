package com.bytesnapper.test;

import org.junit.Assert;
import org.junit.Test;

import com.bytesnapper.zaman.common.Interval;
import com.bytesnapper.zaman.util.DateUtil;

public class AddIntervals {

	@Test
	public void test() {
		Interval firstInterval = new Interval();
		firstInterval.setSeconds(11);
		firstInterval.setMinutes(10);
		
		firstInterval.setHours(15);
		firstInterval.setDays(29);
		firstInterval.setYears(1);

		Interval secondInterval = new Interval();
		secondInterval.setSeconds(50);
		secondInterval.setMinutes(10);

		secondInterval.setHours(10);
		secondInterval.setDays(29);
		secondInterval.setYears(1);
		
		Interval resultInterval = DateUtil.addIntervals(firstInterval, secondInterval);
		boolean check = (resultInterval.convertToSeconds()==(firstInterval.convertToSeconds()+secondInterval.convertToSeconds()));
	
		
/*		System.out.println(resultInterval.convertToSeconds());
		System.out.println(firstInterval.convertToSeconds());
		System.out.println(secondInterval.convertToSeconds());
		System.out.println("Sum: "+(firstInterval.convertToSeconds()+secondInterval.convertToSeconds()));
		System.out.println("Result: "+resultInterval.convertToSeconds());
		System.out.println(resultInterval.toString());
*/
    	Assert.assertTrue("Result interval total seconds do not equal sum of two interval in seconds",check);
		
	}
	

}

package com.bytesnapper.test;


import org.junit.Assert;
import org.junit.Test;

import com.bytesnapper.zaman.common.Interval;

public class IntervalGreaterThan {

	@Test
	public void test() {
		Interval firstInterval= new Interval();
		firstInterval.setSeconds(11);
		firstInterval.setMinutes(10);;
		firstInterval.setHours(10);
		firstInterval.setDays(29);
		firstInterval.setYears(12);
		
		Interval secondInterval= new Interval();
		secondInterval.setSeconds(10);
		secondInterval.setMinutes(10);;
		secondInterval.setHours(10);
		secondInterval.setDays(29);
		secondInterval.setYears(9);
		
		//System.out.println("1st is Greater than 2nd: "+firstInterval.isGreaterThan(secondInterval));
		Assert.assertTrue("1st is Greater than ",firstInterval.isGreaterThan(secondInterval));
	}

}

package com.bytesnapper.test;

import org.junit.Assert;
import org.junit.Test;

import com.bytesnapper.zaman.common.Interval;
import com.bytesnapper.zaman.exceptions.NegativeIntervalException;
import com.bytesnapper.zaman.util.DateUtil;

public class SubtractIntervals {

	@Test
	public void test() {
		Interval firstInterval = new Interval();
		firstInterval.setSeconds(11);
		firstInterval.setMinutes(10);
		;
		firstInterval.setHours(10);
		firstInterval.setDays(29);
		firstInterval.setYears(12);

		Interval secondInterval = new Interval();
		secondInterval.setSeconds(10);
		secondInterval.setMinutes(10);

		secondInterval.setHours(10);
		secondInterval.setDays(29);
		secondInterval.setYears(12);

		try {
			Interval resultInterval = DateUtil.subtractIntervals(firstInterval, secondInterval);
			boolean check = (resultInterval.convertToSeconds() >= 0);
			System.out.println(resultInterval.convertToSeconds());
				Assert.assertTrue("Interval cannot be less than 0 sec",check);
			
		} catch (NegativeIntervalException e) {
			//e.printStackTrace();
			
			
		}

	}
}

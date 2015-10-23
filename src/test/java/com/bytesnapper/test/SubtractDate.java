package com.bytesnapper.test;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.bytesnapper.zaman.common.Interval;
import com.bytesnapper.zaman.util.DateUtil;

public class SubtractDate {

	@Test
	public void test() {
		Calendar calendar = Calendar.getInstance();
		Date first = calendar.getTime();
		System.out.println("First " + first);
		calendar.add(Calendar.DATE, 100);
		Date second = calendar.getTime();
		System.out.println("second " + second);

		Interval interval = DateUtil.subtractDate(first, second);

  		System.out.println("Seconds " + interval.getSeconds());
		System.out.println("Minutes " + interval.getMinutes());
		System.out.println("Hours " + interval.getHours());
		System.out.println("Days: " + interval.getDays());
		System.out.println("Month " + interval.getMonths());
		System.out.println("Years " + interval.getYears());

		System.out.println("To Months " + interval.convertToMonths());
		System.out.println("To Days " + interval.convertToDays());
		System.out.println("To Hours " + interval.convertToHours());
		System.out.println("To Mins " + interval.convertToMinutes());
		System.out.println("To Secs " + interval.convertToSeconds());

		boolean checAll = (first.before(second) && interval.getYears() < 1 && interval.getDays() < 1 && interval.getHours() < 1 && interval.getMinutes() < 1 && interval.getSeconds() < 1);

		Assert.assertFalse("First date is before second date so interval elements cannot be less than one", checAll);

		Assert.assertFalse("Mintes and seconds cannot be more than 29", interval.getMinutes() > 59 || interval.getSeconds() > 59);

		Assert.assertFalse("Mintes and seconds cannot be more than 29",	interval.getMinutes() > 59 || interval.getSeconds() > 59);

		Assert.assertFalse("Hours cannot be more than 23", interval.getHours() > 23);

		Assert.assertFalse("Days cannot be more than 29", interval.getDays() > 29);

		Assert.assertFalse("Days cannot be more than 11", interval.getMonths() > 11);

	}
}

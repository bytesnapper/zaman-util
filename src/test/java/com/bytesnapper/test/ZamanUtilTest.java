package com.bytesnapper.test;

import static org.junit.Assert.fail;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.bytesnapper.zaman.util.ZamanUtil;

public class ZamanUtilTest {

	@Test
	public void testAddDays() {
		int addition = 10;
		Date inputDate = new Date();
		Date outputDate = ZamanUtil.addDays(inputDate, addition);

		Assert.assertFalse("Date is null", outputDate == null);
		Assert.assertFalse("Number of Days is not added ", addition > 0 && !outputDate.after(inputDate));

		addition = -1;
		inputDate = new Date();
		outputDate = ZamanUtil.addDays(inputDate, addition);

		Assert.assertFalse("Number of Days is not subtracted", addition < 0 && !outputDate.before(inputDate));

		addition = 0;
		inputDate = new Date();
		outputDate = ZamanUtil.addDaysWithoutResettingTime(inputDate, addition);

		Assert.assertFalse("Number of Days is 0 , it should not change input date",
				addition == 0 && !inputDate.equals(outputDate));

	}

	@Test
	public void testAddMonths() {
		Calendar calendar = Calendar.getInstance();
		int months = 10;
		int inMonth = calendar.get(Calendar.MONTH);
		int inYear = calendar.get(Calendar.YEAR);

		Date outputDate = ZamanUtil.addMonths(calendar.getTime(), months);
		calendar.setTime(outputDate);
		int outMonth = calendar.get(Calendar.MONTH);
		int outYear = calendar.get(Calendar.YEAR);

		Assert.assertFalse("Months param  greater than 0 and output month is not greater than input month", (months > 0
				&& inMonth > outMonth && !(outYear > inYear)));

		System.out.println("Input Date: " + inMonth + " " + outYear);
		System.out.println("Output Date: " + outMonth + " " + outYear);

		months = -2;
		inMonth = calendar.get(Calendar.MONTH);
		inYear = calendar.get(Calendar.YEAR);
		outputDate = ZamanUtil.addMonths(calendar.getTime(), months);
		calendar.setTime(outputDate);
		outMonth = calendar.get(Calendar.MONTH);
		outYear = calendar.get(Calendar.YEAR);

		System.out.println("Input Date: " + inMonth + " " + outYear);
		System.out.println("Output Date: " + outMonth + " " + outYear);

		Assert.assertFalse("Months param is less than 0 and output month is not less than input month", months < 0
				&& inMonth < outMonth && !(outYear < inYear));

		months = 0;
		inMonth = calendar.get(Calendar.MONTH);
		inYear = calendar.get(Calendar.YEAR);

		outputDate = ZamanUtil.addMonths(calendar.getTime(), months);
		calendar.setTime(outputDate);
		outMonth = calendar.get(Calendar.MONTH);
		outYear = calendar.get(Calendar.YEAR);

		System.out.println("Input Date: " + inMonth + " " + outYear);
		System.out.println("Output Date: " + outMonth + " " + outYear);

		Assert.assertFalse("Months param is equal to 0 and output month is not greater than input month", (months == 0
				&& inMonth != outMonth && outYear != inYear));

		System.out.println("Input Date: " + inMonth + " " + outYear);
		System.out.println("Output Date: " + outMonth + " " + outYear);

	}

	@Test
	public void addYearsTest() {
		Calendar calendar = Calendar.getInstance();
		int years = 10;
		int inMonth = calendar.get(Calendar.MONTH);
		int inYear = calendar.get(Calendar.YEAR);

		Date outputDate = ZamanUtil.addYears(calendar.getTime(), years);
		calendar.setTime(outputDate);
		int outMonth = calendar.get(Calendar.MONTH);
		int outYear = calendar.get(Calendar.YEAR);

		Assert.assertFalse("Years param  greater than 0 and output year is not greater than input year",
				(years > 0 && !(outYear > inYear)));

		System.out.println("Input Date: " + inMonth + " " + outYear);
		System.out.println("Output Date: " + outMonth + " " + outYear);

		years = -2;
		inMonth = calendar.get(Calendar.MONTH);
		inYear = calendar.get(Calendar.YEAR);
		outputDate = ZamanUtil.addYears(calendar.getTime(), years);
		calendar.setTime(outputDate);
		outMonth = calendar.get(Calendar.MONTH);
		outYear = calendar.get(Calendar.YEAR);

		System.out.println("Input Date: " + inMonth + " " + outYear);
		System.out.println("Output Date: " + outMonth + " " + outYear);

		Assert.assertFalse("Years param is less than 0 and output year is not less than input year",
				(years < 0 && !(outYear < inYear)));

		years = 0;
		inMonth = calendar.get(Calendar.MONTH);
		inYear = calendar.get(Calendar.YEAR);

		outputDate = ZamanUtil.addYears(calendar.getTime(), years);
		calendar.setTime(outputDate);
		outMonth = calendar.get(Calendar.MONTH);
		outYear = calendar.get(Calendar.YEAR);

		System.out.println("Input Date: " + inMonth + " " + outYear);
		System.out.println("Output Date: " + outMonth + " " + outYear);

		Assert.assertFalse("Years param is equal to 0 and output year is not greater than input year", (years == 0
				&& inMonth != outMonth && outYear != inYear));

		System.out.println("Input Date: " + inMonth + " " + outYear);
		System.out.println("Output Date: " + outMonth + " " + outYear);

	}
	
	@Test
	public void testResetTime() {
		Date inputDate= new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date outputDate=ZamanUtil.resetTime(inputDate);
		String outputDateStr= format.format(outputDate);
		if(!outputDateStr.equals("00:00:00")){
			fail("Time is not reset");
		}
	}

}

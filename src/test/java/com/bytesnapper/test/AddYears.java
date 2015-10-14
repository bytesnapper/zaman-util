package com.bytesnapper.test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.bytesnapper.zaman.DateUtil;

public class AddYears {

	@Test
	public void test() {
		Calendar calendar = Calendar.getInstance();
		int years = 10;
		int inMonth = calendar.get(Calendar.MONTH);
		int inYear = calendar.get(Calendar.YEAR);

		Date outputDate = DateUtil.addYears(calendar.getTime(), years);
		calendar.setTime(outputDate);
		int outMonth = calendar.get(Calendar.MONTH);
		int outYear = calendar.get(Calendar.YEAR);

		if (years > 0 && !(outYear > inYear)) {
			fail("Years param  greater than 0 and output year is not greater than input year");
		}

		System.out.println("Input Date: " + inMonth + " " + outYear);
		System.out.println("Output Date: " + outMonth + " " + outYear);

		years = -2;
		inMonth = calendar.get(Calendar.MONTH);
		inYear = calendar.get(Calendar.YEAR);
		outputDate = DateUtil.addYears(calendar.getTime(), years);
		calendar.setTime(outputDate);
		outMonth = calendar.get(Calendar.MONTH);
		outYear = calendar.get(Calendar.YEAR);
/*
		System.out.println("Input Date: " + inMonth + " " + outYear);
		System.out.println("Output Date: " + outMonth + " " + outYear);
*/
		if (years < 0 && !(outYear < inYear)) {
			fail("Years param is less than 0 and output year is not less than input year");
		}

		years = 0;
		inMonth = calendar.get(Calendar.MONTH);
		inYear = calendar.get(Calendar.YEAR);

		outputDate = DateUtil.addYears(calendar.getTime(), years);
		calendar.setTime(outputDate);
		outMonth = calendar.get(Calendar.MONTH);
		outYear = calendar.get(Calendar.YEAR);

/*		System.out.println("Input Date: " + inMonth + " " + outYear);
		System.out.println("Output Date: " + outMonth + " " + outYear);
*/
		if (years == 0 && inMonth != outMonth && outYear != inYear) {
			fail("Years param is equal to 0 and output year is not greater than input year");
		}

/*		System.out.println("Input Date: " + inMonth + " " + outYear);
		System.out.println("Output Date: " + outMonth + " " + outYear);
*/
	}

}

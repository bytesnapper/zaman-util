package com.bytesnapper.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.bytesnapper.zaman.util.DateUtil;

public class AddDays {

	@Test
	public void test() {
		int addition = 10;
		Date inputDate = new Date();
		Date outputDate = DateUtil.addDays(inputDate, addition);

		Assert.assertFalse("Date is null", outputDate == null);

		Assert.assertFalse("Number of Days is not added ", addition > 0 && !outputDate.after(inputDate));

		addition = -1;
		inputDate = new Date();
		outputDate = DateUtil.addDays(inputDate, addition);

		Assert.assertFalse("Number of Days is not subtracted", addition < 0 && !outputDate.before(inputDate));

		addition = 0;
		inputDate = new Date();
		outputDate = DateUtil.addDays(inputDate, addition, false);

		Assert.assertFalse("Number of Days is 0 , it should not change input date",	addition == 0 && !inputDate.equals(outputDate));

		System.out.println("Input Date: " + inputDate);

		System.out.println("Output Date: " + outputDate);
	}

}

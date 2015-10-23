package com.bytesnapper.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.bytesnapper.zaman.util.DateUtil;

public class AddDays {

	@Test
	public void test() {
		int addition=10;
		Date inputDate = new Date();
		Date outputDate =DateUtil.addDays(inputDate,addition);
		
		if(outputDate==null){
			fail("Date is null");
		}


		
		if(addition>0 && !outputDate.after(inputDate)){
			fail("Number of Days is not added ");

		}
		
		 addition=-1;
		 inputDate = new Date();
		 outputDate =DateUtil.addDays(inputDate,addition);
		 
		if(addition<0 && !outputDate.before(inputDate)){
			fail("Number of Days is not subtracted");

		}
		
		
		 addition=0;
		 inputDate = new Date();
		 outputDate =DateUtil.addDays(inputDate,addition,false);
		 
		if(addition==0 && !inputDate.equals(outputDate)){
			fail("Number of Days is 0 , it should not change input date");

		}
		System.out.println("Input Date: "+ inputDate);

		System.out.println("Output Date: "+outputDate);
	}

}

package com.bytesnapper.zaman.util;

import java.util.Calendar;
import java.util.Date;
/**
 * 
 * @author Ahmed Hosny
 *
 */
public class ZamanUtil {

	private static Calendar calendar = Calendar.getInstance();

	/**
	 * 
	 * @param date
	 *            input date to add days to
	 * @param numberOfDays
	 *            if number of days is less than 0,the number of days will be
	 *            removed from the input date
	 * @return date after adding the number of days
	 */
	public static Date addDaysWithoutResettingTime(Date date, int numberOfDays) {
		calendar.setTime(date);
		calendar.add(Calendar.DATE, numberOfDays);
		return calendar.getTime();
	}
	
	
//		

	/**
	 * 
	 * @param date
	 *            input date to add days to
	 * @param numberOfDays
	 *            if number of days is less than 0,the number of days will be
	 *            subtracted from the input date
	 * @return date after adding the number of days
	 */
	public static Date addDays(Date date, int numberOfDays) {
		Date resetDate = resetTime(date);
		calendar.setTime(resetDate);
		calendar.add(Calendar.DATE, numberOfDays);
		return calendar.getTime();
	}
	/**
	 * 
	 * @param date  input date to add months to
	 * @param months if number of months is less than 0,the number of days will be
	 *            subtracted from the input date
	 * @return date after adding months
	 */
	public static Date addMonths(Date date, int months) {
		Date inputDate = resetTime(date);
		calendar.setTime(inputDate);
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();
	}
	/**
	 * 
	 * @param date  input date to add months to
	 * @param years if number of years is less than 0,the number of days will be
	 *            subtracted from the input date
	 * @return date after adding years
	 */
	public static Date addYears(Date date, int years) {
		Date inputDate = resetTime(date);
		calendar.setTime(inputDate);
		calendar.add(Calendar.YEAR, years);
		return calendar.getTime();
		
	}

	/**
	 * 
	 * @return today Date after resetting time
	 */
	public static Date getToday() {
		return resetTime(new Date());
	}

	/**
	 * 
	 * @param date
	 *            input date
	 * @return rests hours,minutes and seconds to the beginning of the day to be
	 *         like Sat Oct 24 00:00:00 EET 2015
	 */
	public static Date resetTime(Date date) {
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getActualMinimum(Calendar.MILLISECOND));
		Date outputDate = new Date(calendar.getTimeInMillis());
		return outputDate;
	}
	
	
}

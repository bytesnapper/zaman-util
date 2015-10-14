package com.bytesnapper.zaman;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	private static Calendar calendar = Calendar.getInstance();

	/**
	 * 
	 * @param date
	 *            input date to add days to
	 * @param numberOfDays
	 *            if number of days is less than 0,the number of days will be
	 *            removed from the input date
	 * @param reset
	 *            if true date is reset to beginning of the day
	 * @return date after adding the number of days
	 */
	public static Date addDays(Date date, int numberOfDays, boolean reset) {
		Date tempDate;
		if (reset) {
			tempDate = resetTime(date);
		} else {
			tempDate = date;
		}
		calendar.setTime(tempDate);
		calendar.add(Calendar.DATE, numberOfDays);
		return calendar.getTime();
	}

	/**
	 * 
	 * @param date
	 *            input date to add days to
	 * @param numberOfDays
	 *            if number of days is less than 0,the number of days will be
	 *            removed from the input date
	 * @return date after adding the number of days
	 */
	public static Date addDays(Date date, int numberOfDays) {
		return addDays(date, numberOfDays, true);
	}

	/**
	 * 
	 * @param date
	 * @param months
	 * @return
	 */
	public static Date addMonths(Date date, int months) {
		Date inputDate = resetTime(date);
		calendar.setTime(inputDate);
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();
	}

	/**
	 * 
	 * @param date
	 * @param years
	 * @return
	 */
	public static Date addYears(Date date, int years) {
		Date inputDate = resetTime(date);
		calendar.setTime(inputDate);
		calendar.add(Calendar.YEAR, years);
		return calendar.getTime();
		
	}

	/**
	 * 
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	public static Interval subtractDate(Date fromDate, Date toDate) {
		return null;
	}

	/**
	 * 
	 * @param fromDate
	 * @param toDate
	 * @param unitConstant
	 * @return
	 */
	public static Interval subtractAndConvert(Date fromDate, Date toDate, int Constant) {

		return null;
	}

	/**
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public static Interval addiIntervals(Interval first, Interval second) {
		return second;
	}

	/**
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public static Interval subtractIntervals(Interval first, Interval second) {
		return second;
	}

	/**
	 * 
	 * @param interval
	 * @return
	 */
	public static int convertInterval(Interval interval, int unit) {
		return 0;
	}

	/**
	 * 
	 * @return today Date after reset time
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

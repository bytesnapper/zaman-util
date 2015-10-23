package com.bytesnapper.zaman.util;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.bytesnapper.zaman.common.Interval;
import com.bytesnapper.zaman.exceptions.NegativeIntervalException;

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
		if(fromDate.after(toDate)){
			throw new NegativeIntervalException("Interval cannot be negative.");
		}
		calendar.setTime(fromDate);
		int fromYears=calendar.get(Calendar.YEAR);
		int fromMonths=calendar.get(Calendar.MONTH);
		int fromDays=calendar.get(Calendar.DAY_OF_MONTH);
		int fromHours=calendar.get(Calendar.HOUR_OF_DAY);
		int fromMinutes=calendar.get(Calendar.MINUTE);
		int fromSeconds=calendar.get(Calendar.SECOND);
		
		calendar.setTime(toDate);
		int toYears=calendar.get(Calendar.YEAR);
		int toMonths=calendar.get(Calendar.MONTH);
		int toDays=calendar.get(Calendar.DAY_OF_MONTH);
		int toHours=calendar.get(Calendar.HOUR_OF_DAY);
		int toMinutes=calendar.get(Calendar.MINUTE);
		int toSeconds=calendar.get(Calendar.SECOND);
		
		return subtractor(fromYears, fromMonths, fromDays, fromHours, fromMinutes, fromSeconds, toYears, toMonths, toDays, toHours, toMinutes, toSeconds);
	}

	/**
	 * 
	 * @param to
	 * @param toDate
	 * @param unitConstant
	 * @return
	 */
	public static Interval subtractDateAndConvert(Date fromDate, Date toDate, int Constant) {
		
		return null;
	}

	/**
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public static Interval addIntervals(Interval first, Interval second) {
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
	
	/**
	 * 
	 * @param fromYears
	 * @param fromMonths
	 * @param fromDays
	 * @param fromHours
	 * @param fromMinutes
	 * @param fromSeconds
	 * @param toYears
	 * @param toMonths
	 * @param toDays
	 * @param toHours
	 * @param toMinutes
	 * @param toSeconds
	 * @return
	 */
	private static Interval subtractor(int fromYears,int fromMonths,int fromDays,int fromHours,int fromMinutes,int fromSeconds,int toYears,int toMonths,int toDays,int toHours,int toMinutes,int toSeconds){
	
		if(toSeconds<fromSeconds){
			toMinutes--;
			toSeconds+=60;
		}
		
		int outputSeconds=toSeconds-fromSeconds;
		
		if(toMinutes<fromMinutes){
			toHours--;
			toMinutes+=60;
		}
		
		int outputMinutes=toMinutes-fromMinutes;
		
		if(toHours<fromHours){
			toDays--;
			toHours+=24;
		}
		
		int outputHours=toHours-fromHours;
		

		if(toDays<fromDays){
			toMonths--;
			toDays+=30;
		}
		
		int outputDays=toDays-fromDays;
		
		if(toMonths<fromMonths){
			toYears--;
			toMonths+=12;
		}
		
		int outputMonths=toMonths-fromMonths;
		
		
		if( !(toSeconds<fromSeconds) && !(toMinutes<fromMinutes) && !(toHours<fromHours) && !(toDays<fromDays) && !(toMonths<fromMonths)){
			int outputYears=toYears-fromYears;
			Interval interval = new Interval();
			interval.setSeconds(outputSeconds);
			interval.setMinutes(outputMinutes);
			interval.setHours(outputHours);
			interval.setDays(outputDays);
			interval.setMonths(outputMonths);
			interval.setYears(outputYears);
			return interval;
		}else{
		
		return subtractor(fromYears, fromMonths, fromDays, fromHours, fromMinutes, fromSeconds, toYears, toMonths, toDays, toHours, toMinutes, toSeconds);
		}
		
	}
	
	
}

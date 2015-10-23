package com.bytesnapper.zaman.common;

import java.util.concurrent.TimeUnit;

public class Interval {
	
	

	int years;
	
	int months;
	
	int days;
	
	int hours;
	
	int minutes;
	
	int seconds;

	/**
	 * @return the years
	 */
	public int getYears() {
		return years;
	}

	/**
	 * @param years the years to set
	 */
	public void setYears(int years) {
		this.years = years;
	}

	/**
	 * @return the months
	 */
	public int getMonths() {
		return months;
	}

	/**
	 * @param months the months to set
	 */
	public void setMonths(int months) {
		this.months = months;
	}

	/**
	 * @return the days
	 */
	public int getDays() {
		return days;
	}

	/**
	 * @param days the days to set
	 */
	public void setDays(int days) {
		this.days = days;
	}

	/**
	 * @return the hours
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * @param hours the hours to set
	 */
	public void setHours(int hours) {
		this.hours = hours;
	}

	/**
	 * @return the minutes
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * @param minutes the minutes to set
	 */
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	/**
	 * @return the seconds
	 */
	public int getSeconds() {
		return seconds;
	}

	/**
	 * @param seconds the seconds to set
	 */
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	/**
	 *  * @return totalMonths
	 */
	public int convertToMonths(){
		int totalMonths= years*12 + months;		
		return totalMonths;		
	}
	
	/**
	 * 
	 * @return totalDays
	 */
	public long convertToDays(){
			long totalDays= years*365 + months * 30	+days;		
		return totalDays;		
	}
	
	/**
	 * 
	 * @return totalHours
	 */
	public long convertToHours(){
		long totalHours= convertToDays() * 24 +hours;		
	return totalHours;		
	}
	
	/**
	 * 
	 * @return totalMinutes
	 */
	public long convertToMinutes() {
		long totalMinutes= convertToHours() * 60 +minutes;
		return totalMinutes;
	}
	
	/**
	 * 
	 * @return totalSeconds
	 */
	public long convertToSeconds(){
		long totalSeconds= convertToMinutes() * 60 +seconds;		
	return totalSeconds;		
	}

	
	
	
}

package com.bytesnapper.zaman.common;

public class Interval implements Cloneable {

	private int years;

	private int months;

	private int days;

	private int hours;

	private int minutes;

	private int seconds;

	/**
	 * @return the years
	 */
	public int getYears() {
		return years;
	}

	/**
	 * @param years
	 *            the years to set
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
	 * @param months
	 *            the months to set
	 */
	public void setMonths(int months) {
		if (months > 11) {
			throw new IllegalArgumentException("Month cannot be more than 11");
		}
		this.months = months;
	}

	/**
	 * @return the days
	 */
	public int getDays() {
		return days;
	}

	/**
	 * @param days
	 *            the days to set
	 */
	public void setDays(int days) {
		if (days > 29) {
			throw new IllegalArgumentException("Days cannot be more than 29");
		}
		this.days = days;
	}

	/**
	 * @return the hours
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * @param hours
	 *            the hours to set
	 */
	public void setHours(int hours) {
		if (hours > 23) {
			throw new IllegalArgumentException("Hours cannot be more than 23");
		}
		this.hours = hours;
	}

	/**
	 * @return the minutes
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * @param minutes
	 *            the minutes to set
	 */
	public void setMinutes(int minutes) {
		if (minutes > 59) {
			throw new IllegalArgumentException("Minutes cannot be more than 59");
		}
		this.minutes = minutes;
	}

	/**
	 * @return the seconds
	 */
	public int getSeconds() {
		return seconds;
	}

	/**
	 * @param seconds
	 *            the seconds to set
	 */
	public void setSeconds(int seconds) {
		if (seconds > 59) {
			throw new IllegalArgumentException("Seconds cannot be more than 59");
		}
		this.seconds = seconds;
	}

	/**
	 * * @return totalMonths
	 */
	public int convertToMonths() {
		int totalMonths = years * 12 + months;
		return totalMonths;
	}

	/**
	 * 
	 * @return totalDays
	 */
	public long convertToDays() {
		long totalDays = years * 365 + months * 30 + days;
		return totalDays;
	}

	/**
	 * 
	 * @return totalHours
	 */
	public long convertToHours() {
		long totalHours = convertToDays() * 24 + hours;
		return totalHours;
	}

	/**
	 * 
	 * @return totalMinutes
	 */
	public long convertToMinutes() {
		long totalMinutes = convertToHours() * 60 + minutes;
		return totalMinutes;
	}

	/**
	 * 
	 * @return totalSeconds
	 */
	public long convertToSeconds() {
		long totalSeconds = convertToMinutes() * 60 + seconds;
		return totalSeconds;
	}

	/**
	 * 
	 * @param interval
	 * @return true or false
	 */
	public boolean greaterThan(Interval interval) {
		if (this.years > interval.getYears()) {
			return true;
		} else if (this.years < interval.getYears()) {
			return false;
		} else {
			if (this.months > interval.getMonths()) {
				return true;
			} else if (this.months < interval.getMonths()) {
				return false;
			} else {
				if (this.days > interval.getDays()) {
					return true;
				} else if (this.days < interval.getDays()) {
					return false;
				} else {
					if (this.hours > interval.getHours()) {
						return true;
					} else if (this.hours < interval.getHours()) {
						return false;
					} else {
						if (this.minutes > interval.getMinutes()) {
							return true;
						} else if (this.minutes < interval.getMinutes()) {
							return false;
						} else {
							if (this.seconds > interval.getSeconds()) {
								return true;
							} else {
								return false;
							}
						}

					}
				}

			}

		}
	}

	public boolean lessThan(Interval interval) {
		if (!this.equals(interval) && !this.greaterThan(interval)) {
			return true;
		}
		return false;
	}

	/**
	 * Rests time to zero
	 */
	public void resetTime() {
		this.seconds = 0;
		this.minutes = 0;
		this.hours = 0;
	}

	@Override
	public boolean equals(Object other) {
		boolean equal;
		if (other == null || this.getClass() != other.getClass()) {
			equal = false;
		} else {
			Interval interval = (Interval) other;
			equal = (this.getYears() == interval.getYears() && this.getMonths() == interval.getMonths()
					&& this.getDays() == interval.getDays() && this.getHours() == interval.getHours()
					&& this.getMinutes() == interval.getMinutes() && this.getSeconds() == interval.getSeconds());
		}
		return equal;

	}

	@Override
	public int hashCode() {
		return years + months + days + hours + minutes + seconds;

	}

	@Override
	public Object clone() {
		Interval clone = new Interval();
		clone.setSeconds(this.seconds);
		clone.setMinutes(this.minutes);
		clone.setHours(this.hours);
		clone.setDays(this.days);
		clone.setYears(this.years);
		return clone;
	}

}

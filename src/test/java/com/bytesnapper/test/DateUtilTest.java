package com.bytesnapper.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({AddDays.class,ResetTime.class,AddMonths.class,AddYears.class,SubtractDate.class,
	NegativeIntervalWithDate.class,NegativeIntervalWithInterval.class,SubtractIntervals.class,AddIntervals.class
	})
public class DateUtilTest {

}

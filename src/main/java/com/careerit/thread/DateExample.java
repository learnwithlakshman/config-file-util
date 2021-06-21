package com.careerit.thread;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;

public class DateExample {

		public static void main(String[] args) {
			
				LocalDate date = LocalDate.now();
				System.out.println(date);
				
				LocalDateTime now = LocalDateTime.now();
				System.out.println(now);
				
				LocalTime tnow = LocalTime.now();
				System.out.println(tnow);
				
				LocalDate dob = LocalDate.of(1984, Month.AUGUST,6);
				System.out.println(dob.getDayOfWeek());
				
					
				System.out.println(ChronoUnit.YEARS.between(dob, date));
				
				for(String t:TimeZone.getAvailableIDs()) {
					System.out.println(t);
				}
				
				
		}
}

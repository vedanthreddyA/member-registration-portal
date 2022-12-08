package com.registration.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import com.registration.exception.MemberException;

public class MemberUtility {

	public static long getClaimNumber() {
		long claimNumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		System.out.println("Claim Number ::" + claimNumber);
		return claimNumber;

	}

	public static int getMemberId() {
		int memberId = (int) Math.floor(Math.random() * 9_00) + 1_00;
		return memberId;
	}

	public static int ageCalculation(Date dob) {
		Instant instant = dob.toInstant();
		ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
		LocalDate dateOfBirth = zonedDateTime.toLocalDate();
		LocalDate currentDate = LocalDate.now();
		if ((dob != null) && (currentDate != null)) {
			return Period.between(dateOfBirth, currentDate).getYears();
		} else {
			return 0;
		}
	}

	public static void compareDate(Date dateOfBirth) {
		SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd");
		Date date2 = null;
		try {
			date2 = sdfo.parse("1900-12-15");
			System.out.println("Dafault Date :: " + date2);
			System.out.println("Date of Birth :: " + dateOfBirth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (dateOfBirth.equals(date2)) {
			throw new MemberException("Please Enter Date of Birth");
		} else if (dateOfBirth.after(date2)) {
			System.out.println("Before");
		} else if (dateOfBirth.before(date2)) {
			System.out.println("After");
		}

	}
}

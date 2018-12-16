package com.library.utils.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateConverter {
	public static LocalDate stringToLocalDate(String str) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(str, formatter);
	}
}

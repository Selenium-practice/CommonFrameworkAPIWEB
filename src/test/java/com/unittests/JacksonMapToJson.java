package com.unittests;

import java.util.Calendar;
import java.util.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JacksonMapToJson {

	public static void main(String[] args) throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		/*mapper.enable(SerializationFeature.INDENT_OUTPUT);

		Map<String, Integer> days = new HashMap<>();
		days.put("MON", Calendar.MONDAY);
		days.put("TUE", Calendar.TUESDAY);
		days.put("WED", Calendar.WEDNESDAY);
		days.put("THU", Calendar.THURSDAY);
		days.put("FRI", Calendar.FRIDAY);
		days.put("SAT", Calendar.SATURDAY);
		days.put("SUN", Calendar.SUNDAY);

		String json = mapper.writeValueAsString(days);
		System.out.println(json);*/
		
		
		List<String> progLangs = new ArrayList<>();
		progLangs.add("C");
		progLangs.add("C++");
		progLangs.add("Java");
		progLangs.add("Java EE");
		progLangs.add("Python");
		progLangs.add("Scala");
		progLangs.add("JavaScript");
		// Serialize Object to JSON.
		String json = mapper.writeValueAsString(progLangs);
		System.out.println(json);
		
	}
}

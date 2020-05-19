package com.api.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public class JasonRead {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ObjectMapper mapper = new ObjectMapper();

		JsonNode jsonNode = mapper
		.readTree(new File("./output/result.txt"));
		//getting String
		System.out.println(jsonNode.get("age"));

		//getting list of map
		ObjectReader reader = mapper.readerFor(new TypeReference<List<Map<String, Object>>>() {
		});
		List<Map<String, Object>> list = reader.readValue(jsonNode.get("address"));
		System.out.println(list);


		//getting map
		ObjectReader reader1 = mapper.readerFor(new TypeReference<Map<String, Object>>() {
		});
		Map<String, Object> list1 = reader1.readValue(jsonNode.get("phoneNumbers"));
		System.out.println(list1);
		

		}

}

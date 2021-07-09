package com.javaservlet.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {

	private String dataJson;
	
	public HttpUtil(String dataJson) {
		// TODO Auto-generated constructor stub
		this.dataJson = dataJson;
	}
	
	public <T> T toModel(Class<T> clazz) {
		try {
			return new ObjectMapper().readValue(dataJson, clazz);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static HttpUtil of(BufferedReader reader) {
		StringBuilder builder = new StringBuilder();
		String line = "";
		try {
			while((line = reader.readLine()) != null) {
				builder.append(line);
			}
			return new HttpUtil(builder.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}

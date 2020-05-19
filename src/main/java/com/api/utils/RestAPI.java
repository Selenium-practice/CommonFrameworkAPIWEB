package com.api.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class RestAPI {
	
	private static String baseUrl;
	private static String username;
	private static String password;
	private RequestSpecification request;
	private Response response;
	/**
	 * 
	 * @param url
	 * @param username
	 * @param password
	 * @param paramMAp
	 * @return
	 */
	
	public RequestSpecification getRequestWithParams(String env,Map<String, String> paramMAp)
	{
			
		// Authentication
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			baseUrl = prop.getProperty("URL");
			username = prop.getProperty("UserName");
			password = prop.getProperty("Password");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		RestAssured.baseURI=baseUrl;
		BasicAuthScheme auth = new BasicAuthScheme();
		auth.setUserName(username);
		auth.setPassword(password);
		RestAssured.authentication = auth;
			
		// Get Response
		 RequestSpecification request = RestAssured.given().params(paramMAp);

		return request;
	}
	
	
	
	/**
	 * 
	 * @param url
	 * @param username
	 * @param password
	 * @param headers
	 * @return
	 */
	
	
	public RequestSpecification getRequestWithHeaders(String url,String username,String password,Map<String, String> headers)
	{
		
		// Authentication
				Properties prop = new Properties();
				try {
					prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
					baseUrl = prop.getProperty("URL");
					username = prop.getProperty("UserName");
					password = prop.getProperty("Password");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				RestAssured.baseURI=baseUrl;
				BasicAuthScheme auth = new BasicAuthScheme();
				auth.setUserName(username);
				auth.setPassword(password);
				RestAssured.authentication = auth;
					
						
		// Get Response
	    RequestSpecification request = RestAssured.given().headers(headers);
	    return request;

		
	}
	
	
	/**
	 * 
	 * @param endpoint
	 * @return
	 */
	
	public Response getResponse(String endpoint)
	{
		  response = request.when().get(endpoint).then().extract().response();
	 		
		 return response;
		
	}
	
	
	/**
	 * 
	 * @return
	 */
	
	public int getStatusCode()
	{
				
		return response.statusCode();
		
	}
	
	/**
	 * 
	 * @return
	 */
	
	public String getMessage()
	{
		return response.getStatusLine();
	}
	


}

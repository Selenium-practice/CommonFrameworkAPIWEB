package com.aws.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.testng.Assert;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class AWSS3 {
	
	/**
	 * 
	 * @param clientRegion
	 * @return
	 */
	
	public AmazonS3 invokeS3(String clientRegion)
	{
		
		 int connectionTimeout = 5*60*1000;
         int readTimeout = connectionTimeout;
         ClientConfiguration config = new ClientConfiguration(); 
         config.setConnectionTimeout(connectionTimeout);
         config.setSocketTimeout(readTimeout); 
        
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withClientConfiguration(config)
                .withRegion(clientRegion)
                .withCredentials(new ProfileCredentialsProvider())
                .build();
        
        return s3Client;
	}
	
	/**
	 * 
	 * @param clientRegion
	 * @param bucketName
	 * @param fileObjKeyName
	 * @param fileName
	 * @param foldername
	 * @throws Exception
	 */
	
	public void downloadS3Object(String clientRegion,String bucketName,String fileObjKeyName,String fileName,String foldername) throws Exception {
		  
				try {
					 
					AmazonS3 s3Client = invokeS3(clientRegion);

					S3Object s3Object = s3Client.getObject(new GetObjectRequest(bucketName, fileObjKeyName));

					if (s3Object == null) {
						throw new Exception("Object not found");
					}
					
					File dir = new File(System.getProperty("user.home") + "\\Documents\\" +foldername);
					dir.mkdirs();
					File file = new File(System.getProperty("user.home")+"\\Documents\\"+foldername+"\\"+fileName);
					Files.copy(s3Object.getObjectContent(), file.toPath(),StandardCopyOption.REPLACE_EXISTING);
					
									
					

				} catch (AmazonServiceException e) {
					// The call was transmitted successfully, but Amazon S3 couldn't process
					// it, so it returned an error response.
					e.printStackTrace();
				} catch (SdkClientException e) {
					// Amazon S3 couldn't be contacted for a response, or the client
					// couldn't parse the response from Amazon S3.
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
	
	/**
	 * 
	 * @param clientRegion
	 * @param bucketName
	 * @param fileObjKeyName
	 * @param inputfilename
	 * @throws Exception
	 */
	
	
	public  void uploadObject(String clientRegion,String bucketName,String fileObjKeyName, String inputfilename) throws Exception {
		
           try {
        	
        	AmazonS3 s3Client = invokeS3(clientRegion);
        
            PutObjectRequest request = new PutObjectRequest(bucketName, fileObjKeyName, new File(inputfilename));
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType("plain/text");
            metadata.addUserMetadata("x-amz-meta-title", "someTitle");
            request.setMetadata(metadata);
            s3Client.putObject(request);
        }
        catch(AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process 
            // it, so it returned an error response.
            e.printStackTrace();
        }
        catch(SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }
    }
	
	/**
	 * 
	 * @param clientRegion
	 * @param bucketName
	 * @param prefixmatch
	 * @throws Exception
	 */
	
	public void listS3Objects(String clientRegion,String bucketName,String prefixmatch ) throws Exception {

		try {
			AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(clientRegion)
					.withCredentials(new ProfileCredentialsProvider()).build();

			ObjectListing objectListing = s3Client.listObjects(bucketName, prefixmatch);
			

				String s3key;
				try {
					s3key = objectListing.getObjectSummaries().stream()
							.filter(s ->(s.getKey().contains("91608613087")) && (s.getKey().contains(".zip")))
							.sorted((s1, s2) -> s2.getLastModified().compareTo(s1.getLastModified())).findFirst().get()
							.getKey();
					System.out.println(s3key);
					
				} catch (NoSuchElementException e) {
					// TODO Auto-generated catch block
				}

			

		} catch (AmazonServiceException e) {
			// The call was transmitted successfully, but Amazon S3 couldn't process
			// it, so it returned an error response.
			e.printStackTrace();
		} catch (SdkClientException e1) {
			// Amazon S3 couldn't be contacted for a response, or the client
			// couldn't parse the response from Amazon S3.
			e1.printStackTrace();
		}
		
	
		

	}
	
	
	/**
	 * 
	 * @param url
	 * @param username
	 * @param password
	 * @return
	 */
	public Connection createConnection(String url,String username,String password)
	{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			
		}

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(url,username,password);

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			
		}

		if (connection != null) {
			//System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}

		return connection;
		
	}
	
	/**
	 * 
	 * @param url
	 * @param username
	 * @param password
	 * @param query
	 */
	
	public void fetchRecords(String url,String username,String password,String query)
	{
		Connection connection = createConnection(url,username,password);
		
		try{  
			Statement stmt=connection.createStatement();  
			ResultSet rs=stmt.executeQuery(query);
			
			if (!rs.next() ) {
			    System.out.println("No data found in database  for given input");
			} else {

			    do {
			    	
			    	System.out.println(rs.getString(1));  
					
			    } while (rs.next());
			}


			connection.close();  
			}catch(Exception e)
		{ 
				System.out.println(e);
		}
	}
	
	
	/**
	 * 
	 * @param url
	 * @param username
	 * @param password
	 * @param query
	 */
	
	public void deleteRecords(String url,String username,String password,String query)
	{
		Connection connection = createConnection(url,username,password);
		try{  
			
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			int rowsDeleted = statement.executeUpdate();
			
			if (rowsDeleted > 0) {
			System.out.println("User deleted the record successfully!");
			}else {
				System.out.println("No records found to delete");
			}
			 
			connection.close();  
			}catch(Exception e){ 
				System.out.println(e);
				
			}  
			}

}

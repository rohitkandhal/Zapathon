package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPHelper {

	/*
	 * Helper function for all HTTP GET connection requests
	 */
	public static String httpGet(String urlString) throws IOException{
		
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// 200: HTTP OK
		if (connection.getResponseCode() != 200) {
			System.out.println("Error: " + connection.getResponseCode() + " " + connection.getResponseMessage());
			
			throw new IOException(connection.getResponseMessage());
		}

		// Buffer the result into a string
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		
		StringBuilder responseString = new StringBuilder();

		String currLine;
		while ((currLine = reader.readLine()) != null) 
			responseString.append(currLine);
		
		reader.close();

		connection.disconnect();
		
		return responseString.toString();
	}
}

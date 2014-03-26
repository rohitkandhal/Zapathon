package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class ImageHandler {

	private static final String IMAGE_FOLDER_NAME = "images";
	private static final String PATH_DELIMITER = "\\";
	private static final String IMAGE_FILE_TYPE = ".jpg";
	
	/*
	 * Fetches Image from specified URL and save it in Images folder with product id as name
	 * Name: Product Id; Don't use Product Name as it may contain character not allowed on file system 
	 */
	public static void saveImageOnDisk(String imageURL, String productId) throws IOException {
		
		URL url = new URL(imageURL);
		InputStream inputStream = url.openStream();
		// Create output stream for saving image to disk. 
		// File Name -> Product Name
		OutputStream outputStream = new FileOutputStream(getImagePath(productId));

		byte[] buffer = new byte[2048];
		int readLength;

		while ((readLength = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, readLength);
		}

		inputStream.close();
		outputStream.close();
		
	}

	/*
	 * Create Image folder it does not exists and returns image Folder path. 
	 */
	private static String getImageFolderPath(){
		String workingDir = System.getProperty("user.dir");
		
		String imageFolderPath = workingDir + PATH_DELIMITER + IMAGE_FOLDER_NAME;
		
		File imageFolder = new File(imageFolderPath);
		
		if(!imageFolder.exists()){
			imageFolder.mkdir();
		}
		
		return imageFolderPath; 
	}
	
	/*
	 * Returns Image complete path based on current image folder and product name 
	 */
	private static String getImagePath(String productName){
		return getImageFolderPath() + PATH_DELIMITER + productName + IMAGE_FILE_TYPE;
	}
}

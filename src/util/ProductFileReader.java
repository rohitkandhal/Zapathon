package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * A helper class to read text file 
 * with given Product SKUs and return list of product SKUs 
 */
public class ProductFileReader {

	/*
	 * Reads Product SKU file and return ArrayList of Product SKUs String 
	 */
	public static ArrayList<String> processProductFile(String fileName) {

		ArrayList<String> allProducts = new ArrayList<>();

		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(fileName));

			String productSKU = null;
			while ((productSKU = reader.readLine()) != null) {
				
				// Remove extra white spaces on both ends
				productSKU = productSKU.trim();
				
				if (!productSKU.isEmpty()) {
					allProducts.add(productSKU);
				}
			}
			
			reader.close();

		} catch (IOException e) {

			System.out.println("Invalid product file");
		}

		return allProducts;
	}

}

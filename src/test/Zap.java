package test;

import java.io.IOException;
import java.util.ArrayList;

// Using GSon library to convert JSON result to Java Object
import com.google.gson.Gson;

import modal.Product;
import util.HTTPHelper;
import util.ImageHandler;
import util.ProductFileReader;
import util.ProductSearchResponse;

public class Zap {

	private static final String PRODUCT_SEARCH_URL = "http://api.zappos.com/Product?id=";
	private static final String API_KEY = "&key=YOUR_KEY";

	public static void main(String[] args) {

		Zap zapTest = new Zap();
		String fileName = null;

		// Get fileName having product SKUs from command line parameters
		if (args.length == 1) {
			fileName = args[0].trim();
		} else {
			System.out.println("Error: Please provide valid SKU fileName");
		}

		if (fileName != null && !fileName.isEmpty()) {
			zapTest.saveAllProductsInfoFromServer(fileName);
		}
	}

	/*
	 * Reads SKU file and save images of valid product on disk
	 */
	public void saveAllProductsInfoFromServer(String fileName) {

		// Get all products SKU from input File
		ArrayList<String> allProducts = ProductFileReader
				.processProductFile(fileName);

		// TODO: Improve this function to avoid multiple api calls and use single api call
		for (String productSKU : allProducts) {
			saveProductDetailsFromServer(productSKU);
		}
	}

	/*
	 * Get product information from Zappos server using API
	 * 
	 * TODO: Zappos api support getting information for 10 products in a single
	 * call. However here we are fetching product one by one
	 */
	private static void saveProductDetailsFromServer(String productSKU) {

		String RequestURL = PRODUCT_SEARCH_URL + productSKU + API_KEY;

		Gson gson = new Gson();

		try {
			String queryResponse = HTTPHelper.httpGet(RequestURL);

			ProductSearchResponse searchResult = gson.fromJson(queryResponse,
					ProductSearchResponse.class);

			for (int i = 0; i < searchResult.getProduct().length; i++) {
				Product product = searchResult.getProduct()[i];

				ImageHandler.saveImageOnDisk(product.getDefaultImageUrl(),
						product.getProductId());
			}
		} catch (IOException e) {

			e.getMessage();
		}
	}

}

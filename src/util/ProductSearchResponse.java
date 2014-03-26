package util;

import modal.Product;

/*
 * A response format for Zappos API call for a product search
 * IMP NOTE: Please make sure that the variable name matches exactly with what 
 * is returned from the API otherwise Google gson library wont be able to create java object for the same
 */
public class ProductSearchResponse {

	public String getStatusCode() {
		return statusCode;
	}

	public Product[] getProduct() {
		return product;
	}

	private String statusCode;
	private Product[] product;	// Ideally it should be plural as their could be multiple products returned

	public ProductSearchResponse(String response, Product[] products) {
		// Make response immutable
		this.statusCode = response;
		this.product = products;
	}
	
	

}

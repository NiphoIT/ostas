package com.satso.nhl.SatsoAssess;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;


public class ProductRepository {

	LinkedList<Product> productList = new LinkedList<Product>();

	public ProductRepository() {

		Product p1 = new Product();
		p1.setId("00001");
		p1.setName("Call of Duty 1");
		productList.add(p1);

		Product p2 = new Product();
		p2.setId("00002");
		p2.setName("Call of Duty 2");
		productList.add(p2);

		Product p3 = new Product();
		p3.setId("00003");
		p3.setName("Final Fantasy XVI");
		productList.add(p3);

		Product p4 = new Product();
		p4.setId("00005");
		p4.setName("Final Fantasy X");
		productList.add(p4);

		Product p5 = new Product();
		p5.setId("00006");
		p5.setName("XCOM");
		productList.add(p5);

		Product p6 = new Product();
		p6.setId("00007");
		p6.setName("Borderland 2");
		productList.add(p6);

		Product p7 = new Product();
		p7.setId("00008");
		p7.setName("Red Dead Redemption 2");
		productList.add(p7);

		Product p8 = new Product();
		p8.setId("00009");
		p8.setName("Uncharted : The Lost Legacy");
		productList.add(p8);

		Product p9 = new Product();
		p9.setId("00010");
		p9.setName("");
		productList.add(p9);

	}

	public LinkedList<Product> getProducts(String name) {
		//Filter products then sort then return
		return sortProductsByName(filterProductsByName(name));
	}
	
	public LinkedList<Product> filterProductsByName(String proName) {
		proName = proName.toLowerCase();
		
		//Copy of product Lists
		LinkedList<Product> CopyproductList = productList;
		
		for (Iterator<Product> iproduct = CopyproductList.iterator(); iproduct.hasNext();) {
			if (!iproduct.next().getName().trim().toLowerCase().contains(proName)) {
				iproduct.remove();
			}
		}
		
		return CopyproductList;
	}
	
	public LinkedList<Product> sortProductsByName(LinkedList<Product> filteredProductList) {
	
		//sorting the LinkedList
		Collections.sort(filteredProductList,new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				return o1.getName().compareTo(o2.getName());
			}
			
		});
		
		
		return filteredProductList;
	}

}

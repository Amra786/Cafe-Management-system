package com.inn.cafe.restImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.inn.cafe.constants.CafeConstants;
import com.inn.cafe.rest.ProductRest;
import com.inn.cafe.service.ProductService;
import com.inn.cafe.utils.CafeUtils;
import com.inn.cafe.wrapper.ProductWrapper;

@RestController
public class ProductRestImpl implements ProductRest{
	
	@Autowired
	ProductService productService;

	@Override
	public ResponseEntity<String> addNewProduct(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		try {
			return productService.addNewProduct(requestMap);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<List<ProductWrapper>> getAllProduct() {
		// TODO Auto-generated method stub
		try {
			return productService.getAllProduct();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> updateProduct(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		try {
			return productService.updateProduct(requestMap);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		try {
			return productService.deleteProduct(id);

		}catch(Exception ex){
			ex.printStackTrace();
		}
		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, null);
	}

	@Override
	public ResponseEntity<String> updateStatus(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		try {
			return productService.updateStatus(requestMap);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<List<ProductWrapper>> getByCategory(Integer id) {
		// TODO Auto-generated method stub
		try {
			return productService.getByCategory(id);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<ProductWrapper> getProductById(Integer id) {
		// TODO Auto-generated method stub
		try {
			return productService.getProductById(id);

		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>(new ProductWrapper(id, null), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

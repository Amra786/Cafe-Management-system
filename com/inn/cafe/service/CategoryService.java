package com.inn.cafe.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inn.cafe.POJO.Category;

@Service
public interface CategoryService {

	ResponseEntity<String> addNewCategory(Map<String,String> requestMap);

	ResponseEntity<List<Category>> getAllCategory(String filterValue);

	ResponseEntity<String> updateCategory(Map<String, String> requestMap);
}

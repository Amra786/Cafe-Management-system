package com.inn.cafe.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface DashBoardService {

	ResponseEntity<Map<String, Object>> getCount();

}

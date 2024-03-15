package study.platform.demo.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface userService {
    ResponseEntity<String> signUP(Map<String,String> requestMap);
}

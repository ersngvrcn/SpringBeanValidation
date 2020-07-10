package com.works.fivedays.restcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.works.fivedays.props.User;

@RestController
public class UserRestController {

	List<User> ls = new ArrayList<>();

	@PostMapping("/userAdd")
	public Map<String, Object> userAdd(@Valid @RequestBody User us) {
		Map<String, Object> hm = new LinkedHashMap<String, Object>();
		hm.put("statu", true);
		ls.add(us);
		return hm;
	}

	@GetMapping("/allUser")
	public Map<String, Object> allUser() {
		Map<String, Object> hm = new LinkedHashMap<String, Object>();
		hm.put("allUser", ls);

		return hm;
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleFnc(MethodArgumentNotValidException ex) {
		Map<String, String> hm = new HashMap<String, String>();
		List<ObjectError> els = ex.getBindingResult().getAllErrors();

		for (ObjectError err : els) {
			String field = ((FieldError) err).getField();
			String message = err.getDefaultMessage();
			hm.put(field,message);
		}
		return hm;
	}

}

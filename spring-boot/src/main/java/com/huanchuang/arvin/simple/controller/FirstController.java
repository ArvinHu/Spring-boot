package com.huanchuang.arvin.simple.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 第一个controller
 * 
 * @author ARVIN
 *
 */
@RestController
public class FirstController {
	@RequestMapping("/hello")
	public String home() {
		return "hello world!";
	}
}

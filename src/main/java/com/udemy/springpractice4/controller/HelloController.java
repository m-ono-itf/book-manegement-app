package com.udemy.springpractice4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping(value="/index") // indexにリクエストが来た時に呼び出されるメソッドを作成
	public String index() {
		return "index";
	}
}

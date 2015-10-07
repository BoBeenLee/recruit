package kr.recruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {
	@RequestMapping(value = "/test")
	public String test(){
		return "hello";
	}
	@RequestMapping(value = "/get")
	public @ResponseBody String testRedirect(){
		return "hello world!";
	}


}

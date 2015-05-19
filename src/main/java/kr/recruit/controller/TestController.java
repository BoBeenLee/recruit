package kr.recruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {
/*	@RequestMapping(value = "/test", method=RequestMethod.POST)
	public String test(){
		System.out.println("sdfsdfs");
		return "redirect:/test/testRedirect";
	}*/
	@RequestMapping(value = "/get")
	public @ResponseBody String testRedirect(){
		return "hello world!";
	}
}

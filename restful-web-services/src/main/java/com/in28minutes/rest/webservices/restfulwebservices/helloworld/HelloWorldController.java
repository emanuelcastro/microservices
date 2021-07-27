package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	//@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	@GetMapping(path = "/hello-world")
	public String HelloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path = "/hello-world-internationalized")
	public String HelloWorldInternationalized(
			//@RequestHeader(name="Accept-Language", required = false) Locale locale
			) {
		return messageSource.getMessage("good.morning.message", null, "Default Message", 
				//locale
				LocaleContextHolder.getLocale()
				);
		//return "Hello World";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean HelloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean HelloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}

}

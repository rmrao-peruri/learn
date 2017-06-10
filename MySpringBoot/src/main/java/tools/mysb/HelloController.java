package tools.mysb;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping("/")
	public String index() {
		return "Hello World!";
	}
	@RequestMapping("/msg")
	public String effort() {
		return "Got it working by hook and crook!";
	}
}

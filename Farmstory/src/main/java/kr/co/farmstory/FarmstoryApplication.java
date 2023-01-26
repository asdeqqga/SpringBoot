package kr.co.farmstory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
@SpringBootApplication
public class FarmstoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmstoryApplication.class, args);
	}

	public String index(Principal principal) {

		if(principal != null) {
			// 로그인 함
			return "redirect:/list";
		}else {
			// 로그인 안함
			return "redirect:/user/login";
		}
	}
}

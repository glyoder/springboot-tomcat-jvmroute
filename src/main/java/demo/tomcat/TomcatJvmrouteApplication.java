package demo.tomcat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TomcatJvmrouteApplication {

	public static void main(String[] args) {
		System.setProperty("jvmRoute", "testjvmroute");
		SpringApplication.run(TomcatJvmrouteApplication.class, args);
	}

	@RequestMapping("/info")
	public String getInfo(@Value("${jvmRoute}") String route, HttpSession session,
			@CookieValue("JSESSIONID") String cookie) {
		String jsessionId = cookie == null ? "" : new String(cookie.getBytes());
		return "Jvmroute should be: " + route + " <br/> Jsessionid is:" + jsessionId;
	}
}

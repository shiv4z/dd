package in.gov.egs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.gov.egs.log.TraceLogger;


@RestController
public class WelcomeRestController {
	
	@Autowired
	private Environment env;
	
	@Autowired	
	private TraceLogger traceLogger;
	
	@GetMapping("/welcome")
	public String welcome(@RequestParam("name") String req) {
		String property = env.getProperty("local.server.port");
		traceLogger.logPayload(req);
		System.out.println("========================REST-SERVICES CALL===========================");
		return "Welcome to the Rest-Service : "+property;
	}
	
	
	@GetMapping("/test")
	public String test() {
		System.out.println("========================REST-SERVICES CALL===========================");
		return "This is for testing only";
	}

}

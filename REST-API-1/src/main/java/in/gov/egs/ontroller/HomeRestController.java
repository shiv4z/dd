package in.gov.egs.ontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.gov.egs.log.TraceLogger;
import in.gov.egs.serviceImpl.FeignClientService;

@RestController
public class HomeRestController {
	
    private FeignClientService feignService;
    
	private TraceLogger traceLogger;

	public HomeRestController(FeignClientService feignService, TraceLogger traceLogger) {
		this.feignService = feignService;
		this.traceLogger = traceLogger;
	}
    
	
	@GetMapping("/feignMsg")
	public String getMessage(@RequestParam("name") String body) {
		traceLogger.logPayload(body);
		return feignService.getMsg(body);
	}
    
	
	

}

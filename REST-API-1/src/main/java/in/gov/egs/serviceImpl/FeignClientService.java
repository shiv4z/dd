package in.gov.egs.serviceImpl;


import org.springframework.stereotype.Service;

import in.gov.egs.feign.FeignClientInterface;


@Service
public class FeignClientService {
	
	private FeignClientInterface feignClient;
	
	public FeignClientService(FeignClientInterface feignClient) {
		this.feignClient = feignClient;
	}
	
	public String getMsg(String msg) {
		
		return "from Feign Client : "+ feignClient.fetchWelcomeMsg(msg);
	}
	

	
}

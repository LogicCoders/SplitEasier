package com.SplitEasier.spliteasier;
import com.SplitEasier.spliteasier.splitwise.model.Account;
import com.SplitEasier.spliteasier.splitwise.util.HttpConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpliteasierApplication {

	private final Account account;

	public SpliteasierApplication(Account account) {
		this.account = account;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpliteasierApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Bean
	public HttpHeaders httpHeaders(){
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.AUTHORIZATION, String.format("%s%c%s", HttpConstants.BEARER,'\u0020' , account.getApiKey().getKEY()));
		return httpHeaders;
	}
}

package br.cin.ufpe.sdpos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class MpbackGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MpbackGatewayServerApplication.class, args);
	}

}

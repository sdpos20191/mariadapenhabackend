package br.cin.ufpe.sdpos;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import br.cin.ufpe.sdpos.service.OcorrenciaServiceProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableFeignClients
public class MpbackGatewayServerApplication {

	@Autowired
	private OcorrenciaServiceProxy proxyService;
	
	public static void main(String[] args) {
		SpringApplication.run(MpbackGatewayServerApplication.class, args);
	}
	
	@PostConstruct
	public void consultaOcorrencias() {
		proxyService.listar();
	}

}

package br.cin.ufpe.sdpos.mpback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MpbackOcorrenciaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MpbackOcorrenciaServerApplication.class, args);
	}

}

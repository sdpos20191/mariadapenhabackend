package br.cin.ufpe.sdpos.mpback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableMongoRepositories("br.cin.ufpe.sdpos.mpback.repositories")
public class MpbackOcorrenciaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MpbackOcorrenciaServerApplication.class, args);
	}

}

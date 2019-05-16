package br.cin.ufpe.sdpos.mpback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MpbackConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MpbackConfigServerApplication.class, args);
	}

}

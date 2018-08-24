package edu.kit.tm.cm.tlm.tlmuibff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TlmUiBff {

	public static void main(String[] args) {
		SpringApplication.run(TlmUiBff.class, args);
	}
}

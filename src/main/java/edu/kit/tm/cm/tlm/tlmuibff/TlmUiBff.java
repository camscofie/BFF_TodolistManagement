package edu.kit.tm.cm.tlm.tlmuibff;

import edu.kit.tm.cm.msutils.rest.CustomResponseEntityExceptionHandler;
import edu.kit.tm.cm.msutils.rest.FeignErrorDecoder;
import edu.kit.tm.cm.msutils.rest.RestExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableFeignClients
/*
  Imports exception handling from C&M microservice library.
  Alternatively these classes can be defined as beans or can be extended for further customization.
 */
@Import({FeignErrorDecoder.class, RestExceptionHandler.class, CustomResponseEntityExceptionHandler.class})
public class TlmUiBff {

	public static void main(String[] args) {
		SpringApplication.run(TlmUiBff.class, args);
	}

}

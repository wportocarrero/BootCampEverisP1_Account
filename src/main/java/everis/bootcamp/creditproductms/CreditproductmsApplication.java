package everis.bootcamp.creditproductms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class CreditproductmsApplication {

  public static void main(String[] args) {
    SpringApplication.run(CreditproductmsApplication.class, args);
  }

}
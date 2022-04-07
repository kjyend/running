package toy.runningtoyprj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class RunningtoyprjApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunningtoyprjApplication.class, args);
	}

}

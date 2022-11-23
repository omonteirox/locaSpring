package ifgoiano.FGSeguradora;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class FgSeguradoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(FgSeguradoraApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("senha123"));

	}
}

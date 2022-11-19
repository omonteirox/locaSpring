package ifgoiano.FGSeguradora;

import ifgoiano.FGSeguradora.models.Automovel;
import ifgoiano.FGSeguradora.models.Carro;
import ifgoiano.FGSeguradora.models.Cliente;
import ifgoiano.FGSeguradora.models.Moto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FgSeguradoraApplication {

	public static void main(String[] args) {
		//EXEMPLO DO FUNCIONAMENTO DE HERANÇA
		Carro carro = new Carro();
		Moto moto = new Moto();
		List<Automovel> teste = new ArrayList<>();
		teste.add(carro);
		teste.add(moto);
		Cliente cliente = new Cliente();
		cliente.setAutomoveis(teste);
		System.out.println(cliente.getAutomoveis());
		//FIM EXEMPLO DO FUNCIONAMENTO DE HERANÇA


		SpringApplication.run(FgSeguradoraApplication.class, args);


	}


}

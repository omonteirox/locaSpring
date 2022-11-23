package ifgoiano.FGSeguradora.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    private String cpf;

    private LocalDate dataNascimento;

    private String genero;

    private String endereco;

    private String nome;

}

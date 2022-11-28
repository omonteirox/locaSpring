package ifgoiano.FGSeguradora.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import ifgoiano.FGSeguradora.enums.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Pessoa {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    private String nome;
    @CPF
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private Genero genero;

    private String endereco;


}

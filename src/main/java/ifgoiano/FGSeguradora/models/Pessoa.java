package ifgoiano.FGSeguradora.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Pessoa {

    @Id
    private Long id;

    @Column
    private String cpf;

    private String dataNascimento;

    private String genero;

    private String endereco;

    private String nome;

}

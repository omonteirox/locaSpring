package ifgoiano.FGSeguradora.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@OneToMany
    private String automoveis;

    //@OneToMany List<Seguro>
    private String seguros;

    public Cliente(Long id, String nome, @CPF String cpf, LocalDate dataNascimento, String genero,
                   String endereco, String automoveis,
                   String seguros) {
        super( nome, cpf, dataNascimento, genero, endereco);
        this.id=id;
        this.automoveis=automoveis;
        this.seguros= seguros;
    }
}

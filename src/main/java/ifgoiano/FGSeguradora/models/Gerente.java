package ifgoiano.FGSeguradora.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Gerente extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String senha;

    //@OneToMany
    private String seguros;


    public Gerente(String nome, @CPF String cpf, LocalDate dataNascimento, String login,
                   String senha, String genero, String endereco, String seguros) {
        super(nome, cpf, dataNascimento, genero, endereco);
        this.login = login;
        this.senha = senha;
        this.seguros= seguros;
    }


}

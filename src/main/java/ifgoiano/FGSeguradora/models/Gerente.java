package ifgoiano.FGSeguradora.models;

import ifgoiano.FGSeguradora.enums.Genero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    @OneToMany(mappedBy = "id")
    private List<Seguro> seguros;

    public Gerente(Long id, String nome, @CPF String cpf, LocalDate dataNascimento, Genero genero, String endereco, String login, String senha) {
        super(nome, cpf, dataNascimento, genero, endereco);
        this.id = id;
        this.login = login;
        this.senha = senha;
    }
}

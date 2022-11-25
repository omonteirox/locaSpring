package ifgoiano.FGSeguradora.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

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
    //private ArrayList<Seguro> seguros;


    public Gerente(Long id, String nome, @CPF String cpf, LocalDate dataNascimento, String genero,
                   String endereco, String login, String senha) {
        super(id, nome, cpf, dataNascimento, genero, endereco);
        this.login = login;
        this.senha = senha;
    }


}

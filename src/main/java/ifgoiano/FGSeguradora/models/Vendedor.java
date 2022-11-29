package ifgoiano.FGSeguradora.models;


import ifgoiano.FGSeguradora.enums.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendedor extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private Double salario;


    @OneToMany(mappedBy = "id")
    private List<Contrato> contratos;

    public Vendedor(Long id, String nome, @CPF String cpf, LocalDate dataNascimento, String login,
                    String senha, Genero genero, String endereco, Double salario, List<Contrato> contratos) {
        super( nome, cpf, dataNascimento, genero, endereco);
        this.id=id;
        this.login = login;
        this.senha = senha;
        this.salario = salario;
        this.contratos= contratos;
    }

}

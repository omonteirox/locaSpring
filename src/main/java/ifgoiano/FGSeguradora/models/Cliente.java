package ifgoiano.FGSeguradora.models;

import ifgoiano.FGSeguradora.DTO.MotoDTO;
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
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    //@OneToMany
    private String motos;
    //@OneToMany
    private String carros;
    //@OneToMany
    private String caminhonetes;
    //@OneToMany
    private String seguros;

    public Cliente(String nome, @CPF String cpf, LocalDate dataNascimento, Genero genero, String endereco, Long id) {
        super(nome, cpf, dataNascimento, genero, endereco);
        this.id = id;
    }
}

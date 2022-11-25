package ifgoiano.FGSeguradora.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import ifgoiano.FGSeguradora.models.Gerente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GerenteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Campo LOGIN é requerido.")
    @Length(min = 3, max = 100, message = "O campo login deve possuir entre 3 á 50 caracteres.")
    private String login;

    @NotEmpty(message = "Campo SENHA é requerido.")
    @Length(min = 3, max = 100, message = "O campo SENHA deve possuir entre 3 á 50 caracteres.")
    private String senha;

    @CPF
    @NotEmpty(message = "Campo CPF é requerido.")
    private String cpf;


    @NotEmpty(message = "Campo dataNascimento é requerido.")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotEmpty(message = "Campo GENERO é requerido.")
    @Length(min = 3, max = 100, message = "O campo GENERO deve possuir entre 3 á 10 caracteres.")
    private String genero;

    @NotEmpty(message = "Campo ENDERECO é requerido.")
    @Length(min = 3, max = 100, message = "O campo ENDERECO deve possuir entre 3 á 10 caracteres.")
    private String endereco;

    @NotEmpty(message = "Campo NOME é requerido.")
    @Length(min = 3, max = 100, message = "O campo nome deve possuir entre 3 á 100 caracteres.")
    private String nome;

    public GerenteDTO(Gerente gerente){
        this.id = gerente.getId();
        this.login = gerente.getLogin();
        this.senha = gerente.getSenha();
        this.cpf = gerente.getCpf();
        this.dataNascimento = gerente.getDataNascimento();
        this.genero = gerente.getGenero();
        this.endereco = gerente.getEndereco();
        this.nome = gerente.getNome();
    }


}

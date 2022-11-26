package ifgoiano.FGSeguradora.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import ifgoiano.FGSeguradora.models.Vendedor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendedorDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    @NotEmpty(message = "Campo NOME é requerido.")
    @Length(min = 3, max = 100, message = "O campo nome deve possuir entre 3 á 100 caracteres.")
    private String nome;
    @CPF
    @NotEmpty(message = "Campo CPF é requerido.")
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    @NotEmpty(message = "Campo LOGIN é requerido.")
    @Length(min = 3, max = 100, message = "O campo login deve possuir entre 3 á 50 caracteres.")
    private String login;
    @NotEmpty(message = "Campo SENHA é requerido.")
    @Length(min = 3, max = 100, message = "O campo SENHA deve possuir entre 3 á 50 caracteres.")
    private String senha;
    @NotEmpty(message = "Campo GENERO é requerido.")
    @Length(min = 3, max = 100, message = "O campo GENERO deve possuir entre 3 á 10 caracteres.")
    private String genero;
    @NotEmpty(message = "Campo ENDERECO é requerido.")
    @Length(min = 3, max = 100, message = "O campo ENDERECO deve possuir entre 3 á 10 caracteres.")
    private String endereco;

    private String contratos;

    public VendedorDTO(Vendedor vendedor) {
        this.id = vendedor.getId();
        this.nome = vendedor.getNome();
        this.cpf = vendedor.getCpf();
        this.dataNascimento = vendedor.getDataNascimento();
        this.login = vendedor.getLogin();
        this.senha = vendedor.getSenha();
        this.genero = vendedor.getGenero();
        this.endereco = vendedor.getEndereco();
        this.contratos = vendedor.getContratos();
    }
}

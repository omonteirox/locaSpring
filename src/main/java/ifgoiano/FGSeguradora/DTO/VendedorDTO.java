package ifgoiano.FGSeguradora.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import ifgoiano.FGSeguradora.enums.Genero;
import ifgoiano.FGSeguradora.models.Vendedor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

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
    @NotNull(message = "A data é obrigatória!")
    private LocalDate dataNascimento;
    @NotEmpty(message = "Campo LOGIN é requerido.")
    @Length(min = 3, max = 100, message = "O campo login deve possuir entre 3 á 100 caracteres.")
    @Email
    private String login;
    @NotEmpty(message = "Campo SENHA é requerido.")
    @Length(min = 3, max = 100, message = "O campo SENHA deve possuir entre 3 á 100 caracteres.")
    private String senha;
    @Enumerated(EnumType.STRING)

    private Genero genero;
    @NotEmpty(message = "Campo ENDERECO é requerido.")
    @Length(min = 3, max = 100, message = "O campo ENDERECO deve possuir entre 3 á 100 caracteres.")
    private String endereco;

    @NotNull(message = "O salário é obrigatório!")
    @Range(min=30,max=100000,message = "A quantidade mínima 30 reais a máxima 100.000 reais")
    private Double salario;

   // private List<Contrato> contratos;

    public VendedorDTO(Vendedor vendedor) {
        this.id = vendedor.getId();
        this.nome = vendedor.getNome();
        this.cpf = vendedor.getCpf();
        this.dataNascimento = vendedor.getDataNascimento();
        this.login = vendedor.getLogin();
        this.senha = vendedor.getSenha();
        this.genero = vendedor.getGenero();
        this.endereco = vendedor.getEndereco();
        this.salario = vendedor.getSalario();
        //this.contratos = vendedor.getContratos();
    }
}

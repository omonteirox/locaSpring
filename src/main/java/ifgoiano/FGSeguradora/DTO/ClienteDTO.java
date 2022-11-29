package ifgoiano.FGSeguradora.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import ifgoiano.FGSeguradora.enums.Genero;
import ifgoiano.FGSeguradora.models.Cliente;
import ifgoiano.FGSeguradora.models.Gerente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1l;

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
    @Enumerated(EnumType.STRING)
    private Genero genero;
    @NotEmpty(message = "Campo ENDERECO é requerido.")
    @Length(min = 3, max = 100, message = "O campo ENDERECO deve possuir entre 3 á 100 caracteres.")
    private String endereco;

    private String automoveis;

    private String seguros;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.dataNascimento = cliente.getDataNascimento();
        this.genero = cliente.getGenero();
        this.endereco = cliente.getEndereco();
        this.seguros = cliente.getSeguros();
    }

}

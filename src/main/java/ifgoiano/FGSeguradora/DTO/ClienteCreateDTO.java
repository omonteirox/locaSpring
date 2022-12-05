package ifgoiano.FGSeguradora.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import ifgoiano.FGSeguradora.enums.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteCreateDTO {

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

    private List<Long> automoveis_id;
}

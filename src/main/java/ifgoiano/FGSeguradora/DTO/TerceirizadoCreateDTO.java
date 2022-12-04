package ifgoiano.FGSeguradora.DTO;

import ifgoiano.FGSeguradora.models.Servico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TerceirizadoCreateDTO {

    @NotEmpty(message = "Campo RAZAOSOCIAL é requerido.")
    @Length(min = 3, max = 100, message = "O campo RAZAOSOCIAL deve possuir entre 3 á 100 caracteres.")
    private String razaoSocial;

    @NotEmpty(message = "Campo TELEFONE é requerido.")
    @Length(min = 9, max = 9, message = "O campo TELEFONE deve possuir 9 caracteres.")
    private String telefone;

    @org.hibernate.validator.constraints.br.CNPJ
    @NotEmpty(message = "Campo CNPJ é requerido.")
    private String cnpj;


    private List<ServicoCreateDTO> servicos;
}

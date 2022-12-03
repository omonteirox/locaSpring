package ifgoiano.FGSeguradora.DTO;

import ifgoiano.FGSeguradora.models.Servico;
import ifgoiano.FGSeguradora.models.Terceirizado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TerceirizadoDTO {


    private Long id;

    @NotEmpty(message = "Campo RAZAOSOCIAL é requerido.")
    @Length(min = 3, max = 100, message = "O campo RAZAOSOCIAL deve possuir entre 3 á 100 caracteres.")
    private String razaoSocial;

    @NotEmpty(message = "Campo TELEFONE é requerido.")
    @Length(min = 9, max = 9, message = "O campo TELEFONE deve possuir 9 caracteres.")
    private String telefone;

    @org.hibernate.validator.constraints.br.CNPJ
    @NotEmpty(message = "Campo CNPJ é requerido.")
    private String cnpj;

    //@ManyToMany
    private List<ServicoDTO> servicos;

    public TerceirizadoDTO(Terceirizado terceirizado) {
        this.id = terceirizado.getId();
        this.razaoSocial = terceirizado.getRazaoSocial();
        this.telefone = terceirizado.getTelefone();
        this.cnpj = terceirizado.getCnpj();
       // this.servico=terceirizado.getServico();
    }

    public List<ServicoDTO> getServicos() {
        return servicos;
    }

    public void setServicos(List<ServicoDTO> servicos) {
        this.servicos = servicos;
    }


}


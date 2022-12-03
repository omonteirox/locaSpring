package ifgoiano.FGSeguradora.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import ifgoiano.FGSeguradora.models.Seguro;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class SeguroDTO implements Serializable {
    private static final long serialVersionUID = 1l;

    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @NotNull(message = "A data é obrigatória!")
    private LocalDateTime dataInicio;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @NotNull(message = "A data é obrigatória!")
    private LocalDateTime dataFim;

    @NotEmpty(message = "Campo apolice é requerido.")
    @Length(min = 3, max = 100, message = "O campo apolice deve possuir entre 3 á 100 caracteres.")
    private String apolice;

    //@OneToOne
    @NotNull(message = "O ID do contrato é obrigatório!")
    @Range(min = 1, max = 100000)
    private Long contratoID;

    //@OneToOne
    @NotNull(message = "O ID do cliente é obrigatório!")
    @Range(min = 1, max = 100000)
    private Long clienteID;

    //@OneToOne
    @NotNull(message = "O ID do sinistro é obrigatório!")
    @Range(min = 1, max = 100000)
    private Long sinitroID;
    //    @OneToOne
    @NotNull(message = "O ID do automóvel é obrigatório!")
    @Range(min = 1, max = 100000)
    private Long automovelID;

    @NotNull(message = "O ID do Gerente é obrigatório!")
    @Range(min = 1, max = 100000)
    private Long gerenteID;

    public SeguroDTO(Seguro seguro) {
        this.id = seguro.getId();
        this.dataInicio = seguro.getDataInicio();
        this.dataFim = seguro.getDataFim();
        this.apolice = seguro.getApolice();
        this.contratoID = seguro.getContratoID();
        this.clienteID = seguro.getClienteID();
        this.sinitroID = seguro.getSinitroID();
        this.automovelID = seguro.getAutomovelID();
        this.gerenteID = seguro.getGerenteID();
    }


}

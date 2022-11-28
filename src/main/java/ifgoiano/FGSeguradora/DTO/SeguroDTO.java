package ifgoiano.FGSeguradora.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import ifgoiano.FGSeguradora.models.Seguro;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    private String contrato;

    //@OneToOne
    private String cliente;

    //@OneToOne
    private String sinitro;
    //    @OneToOne
    private String automovel;

    public SeguroDTO(Seguro seguro) {
        this.id = seguro.getId();
        this.dataInicio = seguro.getDataInicio();
        this.dataFim = seguro.getDataFim();
        this.apolice = seguro.getApolice();
        this.contrato = seguro.getContrato();
        this.cliente = seguro.getCliente();
        this.sinitro = seguro.getSinitro();
        this.automovel = seguro.getAutomovel();
    }


}

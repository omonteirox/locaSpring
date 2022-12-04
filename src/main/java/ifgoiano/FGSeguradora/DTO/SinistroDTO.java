package ifgoiano.FGSeguradora.DTO;

import ifgoiano.FGSeguradora.models.Cliente;
import ifgoiano.FGSeguradora.models.Contrato;
import ifgoiano.FGSeguradora.models.Seguro;
import ifgoiano.FGSeguradora.models.Sinistro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SinistroDTO {

    private Long id;
    @NotNull(message = "perdaParcial obrigatório!")
    private Boolean perdaParcial;
    @NotNull(message = "perdaTotal obrigatório!")
    private Boolean perdaTotal;

    @NotEmpty(message = "Descrição obrigatório")
    private String descricao;

    @NotNull(message = "Cliente_id obrigatório!")
    private long cliente_id;
    @NotNull(message = "Contrato_id obrigatório!")
    private long contrato_id;
    @NotNull(message = "seguro_id obrigatório!")
    private long seguro_id;

    public SinistroDTO(Sinistro sinistro){
        this.id = sinistro.getId();
        this.perdaParcial = sinistro.getPerdaParcial();
        this.perdaTotal = sinistro.getPerdaTotal();
        this.descricao = sinistro.getDescricao();
        this.cliente_id = sinistro.getClienteID();
        this.contrato_id = sinistro.getContratoID();
        this.seguro_id = sinistro.getSeguroID();
    }

}

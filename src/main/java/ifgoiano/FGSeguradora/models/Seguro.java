package ifgoiano.FGSeguradora.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Seguro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataInicio;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataFim;
    private String apolice;
    private Long contratoID;
    private Long clienteID;
    private Long sinitroID;
    private Long automovelID;
    private Long gerenteID;

    public Seguro(Long id, LocalDateTime dataInicio, LocalDateTime dataFim, String apolice,
                  Long contrato, Long cliente, Long sinitro, Long automovel, Long gerenteID) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.apolice = apolice;
        this.contratoID = contrato;
        this.clienteID = cliente;
        this.sinitroID = sinitro;
        this.automovelID = automovel;
        this.gerenteID = gerenteID;
    }
}

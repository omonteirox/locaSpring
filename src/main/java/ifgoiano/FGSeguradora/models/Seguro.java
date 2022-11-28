package ifgoiano.FGSeguradora.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    //@OneToOne
    private String contrato;

    //@OneToOne
    private String cliente;

    //@OneToOne
    private String sinitro;
//    @OneToOne
    private String automovel;

    public Seguro(Long id, LocalDateTime dataInicio, LocalDateTime dataFim, String apolice,
                  String contrato, String cliente, String sinitro, String automovel) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.apolice = apolice;
        this.contrato = contrato;
        this.cliente = cliente;
        this.sinitro = sinitro;
        this.automovel = automovel;
    }
}

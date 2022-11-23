package ifgoiano.FGSeguradora.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seguro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    @Column(nullable = false)
    private String apolice;

    @OneToOne
    private Contrato contrato;
    @OneToOne
    private Cliente cliente;
    @OneToOne
    private Sinistro sinitro;
    @OneToOne
    private Automovel automovel;

}

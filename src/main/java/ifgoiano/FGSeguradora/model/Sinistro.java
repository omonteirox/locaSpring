package ifgoiano.FGSeguradora.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sinistro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean perdaParcial;

    private Boolean perdaTotal;
    
    @Column(nullable = false)
    private String descricao;

    @OneToOne
    private Cliente cliente;
    @OneToOne
    private Contrato contrato;
    @OneToOne
    private Seguro seguro;

}

package ifgoiano.FGSeguradora.models;

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
    private long clienteID;
    private long contratoID;
    private long seguroID;


}

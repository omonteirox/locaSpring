package ifgoiano.FGSeguradora.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Automovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cor;

    private Double valorFipe;

    private Integer ano;

    private String placa;

    private String marca;

    private String chassi;

    private String modelo;


}

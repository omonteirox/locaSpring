package ifgoiano.FGSeguradora.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
//@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Automovel {
    @Id
    private Long id;
    @Column
    private String cor;

    private Double valorFipe;

    private Integer ano;

    private String placa;

    private String marca;

    private String Chassi;

    private String modelo;


}

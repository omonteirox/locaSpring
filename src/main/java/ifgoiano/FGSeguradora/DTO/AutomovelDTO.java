package ifgoiano.FGSeguradora.DTO;

import ifgoiano.FGSeguradora.enums.AutomovelTipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutomovelDTO {


    private Long id;

    @Enumerated(EnumType.STRING)
    private AutomovelTipo automovelTipo;

    private String cor;

    private Double valorFipe;

    private Integer ano;

    private String placa;

    private String marca;

    private String chassi;

    private String modelo;

}

package ifgoiano.FGSeguradora.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Moto extends Automovel{

    private String categoria;

    private Double cilindrada;

}

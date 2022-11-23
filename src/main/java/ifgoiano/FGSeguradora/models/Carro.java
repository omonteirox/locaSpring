package ifgoiano.FGSeguradora.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
//@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Carro extends Automovel{

    @Column(nullable = false)
    private Double cavalosPotencia;

    @Column(nullable = false)
    private Integer quantidadePortas;


}

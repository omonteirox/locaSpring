package ifgoiano.FGSeguradora.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Carro extends Automovel{

    @Column(nullable = false)
    private Double cavalosPotencia;

    @Column(nullable = false)
    private Integer quantidadePortas;

    public Carro(Long id, String cor, Double valorFipe, Integer ano, String placa, String marca, String Chassi, String modelo, Double cavalosPotencia, Integer quantidadePortas) {
        super(id, cor, valorFipe, ano, placa, marca, Chassi, modelo);
        this.cavalosPotencia = cavalosPotencia;
        this.quantidadePortas = quantidadePortas;
    }


}

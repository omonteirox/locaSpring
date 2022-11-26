package ifgoiano.FGSeguradora.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Moto extends Automovel{
    @Column(nullable = false)
    private String categoria;
    @Column(nullable = false)
    private Double cilindrada;

    public Moto(Long id, String cor, Double valorFipe, Integer ano, String placa, String marca, String chassi, String modelo, String categoria, Double cilindrada) {
        super(id, cor, valorFipe, ano, placa, marca, chassi, modelo);
        this.categoria = categoria;
        this.cilindrada = cilindrada;
    }
}

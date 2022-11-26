package ifgoiano.FGSeguradora.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Caminhonete extends Automovel {

    private Double cavalosPotencia;
    private boolean carroceriaDupla;
    private boolean quatroPorQuatro;

    public Caminhonete(Long id, String cor, Double valorFipe, Integer ano, String placa, String marca, String chassi, String modelo, Double cavalosPotencia, boolean carroceriaDupla, boolean quatroPorQuatro) {
        super(id, cor, valorFipe, ano, placa, marca, chassi, modelo);
        this.cavalosPotencia = cavalosPotencia;
        this.carroceriaDupla = carroceriaDupla;
        this.quatroPorQuatro = quatroPorQuatro;
    }
}

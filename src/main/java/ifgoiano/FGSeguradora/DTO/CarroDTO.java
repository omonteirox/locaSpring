package ifgoiano.FGSeguradora.DTO;


import ifgoiano.FGSeguradora.models.Carro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarroDTO implements Serializable {
    private static final long serialVersionUID = 1l;
    private Long id;
    @Length(min = 5, max = 20, message = "O campo deve possuir de 5 até 20 caracteres")
    private String cor;
    @NotNull(message = "Campo valorFipe requerido")
    private Double valorFipe;
    @NotNull(message = "Campo Ano requerido")
    private Integer ano;
    @NotEmpty(message = "Campo placa requerido")
    private String placa;
    @NotEmpty(message = "Campo marca Requerido")
    private String marca;
    @NotEmpty(message = "Campo Chassi Requerido")
    private String chassi;
    @NotEmpty(message = "Campo modelo requerido")
    private String modelo;
    private Double cavalosPotencia;
    @NotNull(message = "Campo quantidade de portas requerido")
    private Integer quantidadePortas;

    public CarroDTO(Carro carro) {
        this.id = carro.getId();
        this.cor = carro.getCor();
        this.valorFipe = carro.getValorFipe();
        this.ano = carro.getAno();
        this.placa = carro.getPlaca();
        this.marca = carro.getMarca();
        this.chassi = carro.getChassi();
        this.modelo = carro.getModelo();
        this.cavalosPotencia = carro.getCavalosPotencia();
        this.quantidadePortas = carro.getQuantidadePortas();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Double getValorFipe() {
        return valorFipe;
    }

    public void setValorFipe(Double valorFipe) {
        this.valorFipe = valorFipe;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getCavalosPotencia() {
        return cavalosPotencia;
    }

    public void setCavalosPotencia(Double cavalosPotencia) {
        this.cavalosPotencia = cavalosPotencia;
    }

    public Integer getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(Integer quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }
}

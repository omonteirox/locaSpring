package ifgoiano.FGSeguradora.DTO;

import ifgoiano.FGSeguradora.enums.AutomovelTipo;
import ifgoiano.FGSeguradora.models.Automovel;
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
public class CaminhoneteDTO implements Serializable {
    private static final long serialVersionUID = 1l;
    private Long id;
    private AutomovelTipo tipoAutomovel;
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
    @NotNull(message = "Campo cavalos potencia requerido")
    private Double cavalosPotencia;
    @NotNull(message = "Campo carroceria requerido")
    private boolean carroceriaDupla;
    @NotNull(message = "Campo Quatro por quatro requerido")
    private boolean quatroPorQuatro;
    @NotNull(message = "Não pode ser nulo")
    private int quantidadePortas;

    public CaminhoneteDTO(Automovel caminhonete) {
        this.id = caminhonete.getId();
        this.cor = caminhonete.getCor();
        this.valorFipe = caminhonete.getValorFipe();
        this.ano = caminhonete.getAno();
        this.placa = caminhonete.getPlaca();
        this.marca = caminhonete.getMarca();
        this.chassi = caminhonete.getChassi();
        this.modelo = caminhonete.getModelo();
        this.cavalosPotencia = caminhonete.getCavalosPotencia();
        this.carroceriaDupla = caminhonete.isCarroceriaDupla();
        this.quatroPorQuatro = caminhonete.isQuatroPorQuatro();
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


    public boolean isCarroceriaDupla() {
        return carroceriaDupla;
    }

    public void setCarroceriaDupla(boolean carroceriaDupla) {
        this.carroceriaDupla = carroceriaDupla;
    }

    public boolean isQuatroPorQuatro() {
        return quatroPorQuatro;
    }

    public void setQuatroPorQuatro(boolean quatroPorQuatro) {
        this.quatroPorQuatro = quatroPorQuatro;
    }


    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    public AutomovelTipo getTipoAutomovel() {
        return tipoAutomovel;
    }

    public void setTipoAutomovel(AutomovelTipo tipoAutomovel) {
        this.tipoAutomovel = tipoAutomovel;
    }
}
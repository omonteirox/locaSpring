package ifgoiano.FGSeguradora.models;

public class Carro extends Automovel{
    private Double cavalosPotencia;
    private Integer quantidadePortas;
    private String categoria;

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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}

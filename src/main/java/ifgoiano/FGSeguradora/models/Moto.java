package ifgoiano.FGSeguradora.models;

public class Moto extends Automovel{
    private String categoria;
    private Double cilindrada;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(Double cilindrada) {
        this.cilindrada = cilindrada;
    }
}

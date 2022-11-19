package ifgoiano.FGSeguradora.models;

public class Caminhao extends Automovel {
    private String cavalosPotencia;
    private String Categoria;

    public String getCavalosPotencia() {
        return cavalosPotencia;
    }

    public void setCavalosPotencia(String cavalosPotencia) {
        this.cavalosPotencia = cavalosPotencia;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }
}

package ifgoiano.FGSeguradora.enums;

public enum Genero {
    MASCULINO("MASCULINO"),
    FEMININO("FEMININO"),
    OUTROS("OUTROS");

    private String genero;

    Genero(String genero) {
        this.genero = genero;
    }
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
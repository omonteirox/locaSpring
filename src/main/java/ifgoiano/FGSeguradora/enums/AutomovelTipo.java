package ifgoiano.FGSeguradora.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AutomovelTipo {
    CARRO("Carro"),
    CAMINHAO("Caminhao"),
    MOTO("Moto");
    private final String descricao;
}

package ifgoiano.FGSeguradora.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AutomovelTipo {
    //1
    CARRO("Carro"),
    // 2
    CAMINHONETE("Caminhonete"),
    // 3
    MOTO("Moto");
    private final String descricao;
}

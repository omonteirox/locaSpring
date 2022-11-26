package ifgoiano.FGSeguradora.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Terceirizado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String razaoSocial;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false, unique=true)
    private String cnpj;

    //@ManyToMany
    private String servico;

    public Terceirizado(Long id, String razaoSocial, String telefone, String cnpj, String servico) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.servico = servico;
    }
}

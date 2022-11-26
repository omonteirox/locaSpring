package ifgoiano.FGSeguradora.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @OneToMany
    private String automoveis;

    @OneToMany
    private List<Seguro> seguros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutomoveis() {
        return automoveis;
    }

    public void setAutomoveis(String automoveis) {
        this.automoveis = automoveis;
    }

    public List<Seguro> getSeguros() {
        return seguros;
    }

    public void setSeguros(List<Seguro> seguros) {
        this.seguros = seguros;
    }
}

package ifgoiano.FGSeguradora.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Automovel> automoveis;

    @OneToMany
    private List<Seguro> seguros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Automovel> getAutomoveis() {
        return automoveis;
    }

    public void setAutomoveis(List<Automovel> automoveis) {
        this.automoveis = automoveis;
    }

    public List<Seguro> getSeguros() {
        return seguros;
    }

    public void setSeguros(List<Seguro> seguros) {
        this.seguros = seguros;
    }
}

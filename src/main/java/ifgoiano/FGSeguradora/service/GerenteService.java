package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.models.Gerente;
import ifgoiano.FGSeguradora.repository.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerenteService {

    @Autowired
    private GerenteRepository repository;

    public List<Gerente> findAll(){
        List<Gerente> allGerente = repository.findAll();
        return allGerente;
    }

    public Gerente create(Gerente gerente){
        return  repository.save(gerente);
    }
}

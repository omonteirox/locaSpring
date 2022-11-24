package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.models.Gerente;
import ifgoiano.FGSeguradora.repository.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GerenteService {

    @Autowired
    private GerenteRepository repository;

    public List<Gerente> findAll() {
        List<Gerente> allGerente = repository.findAll();
        return allGerente;
    }

    public Gerente create(Gerente gerente) {
        return repository.save(gerente);
    }

    public Gerente findById(Long id) {
        Optional<Gerente> findGerente = repository.findById(id);
        return findGerente.orElseThrow(() -> new ObjectNotFoundException("Gerente não encontrado!! ID: " + id + ", Tipo: "
                + Gerente.class.getName()));
    }

    public Gerente update(Long id, Gerente gerente) {
        Gerente gerenteUpdate = findById(id);
        gerenteUpdate.setLogin(gerente.getLogin());
        gerenteUpdate.setSenha(gerente.getSenha());
        gerenteUpdate.setNome(gerente.getNome());
        gerenteUpdate.setGenero(gerente.getGenero());
        gerenteUpdate.setDataNascimento(gerente.getDataNascimento());
        gerenteUpdate.setEndereco(gerente.getEndereco());
        return repository.save(gerenteUpdate);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

}

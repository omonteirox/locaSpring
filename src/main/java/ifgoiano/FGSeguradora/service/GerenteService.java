package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.DTO.GerenteDTO;
import ifgoiano.FGSeguradora.exception.DataIntegratyViolationException;
import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.models.Gerente;
import ifgoiano.FGSeguradora.repository.GerenteRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class GerenteService {

    private final GerenteRepository repository;

    public GerenteService(GerenteRepository repository) {
        this.repository = repository;
    }

    public List<Gerente> findAll() {
        return repository.findAll();
    }

    public Gerente create(@Valid GerenteDTO objDTO) {
        if(findByCPF(objDTO) != null){
            throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
        }
        return repository.save(new Gerente(null,
                objDTO.getNome(),
                objDTO.getCpf(),
                objDTO.getDataNascimento(),
                objDTO.getLogin(),
                objDTO.getSenha(),
                objDTO.getGenero(),
                objDTO.getEndereco(),
                objDTO.getSeguros()
             ));
    }
    public Gerente findById(Long id) {
        Optional<Gerente> findGerente = repository.findById(id);
        return findGerente.orElseThrow(() -> new ObjectNotFoundException("Gerente não encontrado!! ID: " + id + ", Tipo: "
                + Gerente.class.getName()));
    }

    public Gerente update(Long id, GerenteDTO objDTO) {
        Gerente gerenteUpdate = findById(id);
        if(findByCPF(objDTO) !=null && findByCPF(objDTO).getId() != id){
            throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
        }
        gerenteUpdate.setNome(objDTO.getNome());
        gerenteUpdate.setCpf(objDTO.getCpf());
        gerenteUpdate.setDataNascimento(objDTO.getDataNascimento());
        gerenteUpdate.setLogin(objDTO.getLogin());
        gerenteUpdate.setSenha(objDTO.getSenha());
        gerenteUpdate.setGenero(objDTO.getGenero());
        gerenteUpdate.setEndereco(objDTO.getEndereco());
        gerenteUpdate.setSeguros(objDTO.getSeguros());
        return repository.save(gerenteUpdate);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    private Gerente findByCPF(GerenteDTO objDTO){
        Gerente obj = repository.findByCPF(objDTO.getCpf());
        if(obj!=null){
            return obj;
        }
        return null;
    }

}

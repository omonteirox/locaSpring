package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.DTO.TerceirizadoDTO;
import ifgoiano.FGSeguradora.exception.DataIntegratyViolationException;
import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.models.Terceirizado;
import ifgoiano.FGSeguradora.repository.TerceirizadoRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class TerceirizadoService {
    private final TerceirizadoRepository repository;

    public TerceirizadoService(TerceirizadoRepository repository) {
        this.repository = repository;
    }

    public List<Terceirizado> findAll() {
        return repository.findAll();
    }

    public Terceirizado create(@Valid TerceirizadoDTO objDTO) {
        if(findByCNPJ(objDTO) != null){
            throw new DataIntegratyViolationException("CNPJ já cadastrado na base de dados!");
        }
        return repository.save(new Terceirizado(null,
                objDTO.getRazaoSocial(),
                objDTO.getTelefone(),
                objDTO.getCnpj(),
                objDTO.getServico()
        ));
    }
    public Terceirizado findById(Long id) {
        Optional<Terceirizado> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Terceirizado não encontrado!! ID: " + id + ", Tipo: "
                + Terceirizado.class.getName()));
    }

    public Terceirizado update(Long id, TerceirizadoDTO objDTO) {
        Terceirizado newObj = findById(id);
        if(findByCNPJ(objDTO) !=null && findByCNPJ(objDTO).getId() != id){
            throw new DataIntegratyViolationException("CNPJ já cadastrado na base de dados!");
        }
        newObj.setRazaoSocial(objDTO.getRazaoSocial());
        newObj.setTelefone(objDTO.getTelefone());
        newObj.setCnpj(objDTO.getCnpj());
        newObj.setServico(objDTO.getServico());
        return repository.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    private Terceirizado findByCNPJ(TerceirizadoDTO objDTO){
        Terceirizado obj = repository.findByCNPJ(objDTO.getCnpj());
        if(obj!=null){
            return obj;
        }
        return null;
    }
}

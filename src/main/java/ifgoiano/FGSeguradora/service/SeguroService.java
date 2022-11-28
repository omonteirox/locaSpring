package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.DTO.SeguroDTO;
import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.models.Seguro;
import ifgoiano.FGSeguradora.repository.SeguroRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class SeguroService {

    private final SeguroRepository repository;

    public SeguroService(SeguroRepository repository) {
        this.repository = repository;
    }

    public List<Seguro> findAll() {
        return repository.findAll();
    }

    public Seguro create(@Valid SeguroDTO objDTO) {

        return repository.save(new Seguro(null,
                objDTO.getDataInicio(),
                objDTO.getDataFim(),
                objDTO.getApolice(),
                objDTO.getContrato(),
                objDTO.getCliente(),
                objDTO.getSinitro(),
                objDTO.getAutomovel()
        ));
    }

    public Seguro findById(Long id) {
        Optional<Seguro> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Seguro não encontrado!! ID: " + id + ", Tipo: "
                + Seguro.class.getName()));
    }

    public Seguro update(Long id, SeguroDTO objDTO) {
        Seguro newObj = findById(id);
        newObj.setDataInicio(objDTO.getDataInicio());
        newObj.setDataFim(objDTO.getDataFim());
        newObj.setApolice(objDTO.getApolice());
        newObj.setContrato(objDTO.getContrato());
        newObj.setCliente(objDTO.getCliente());
        newObj.setSinitro(objDTO.getSinitro());
        newObj.setAutomovel(objDTO.getAutomovel());
        return repository.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}

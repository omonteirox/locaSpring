package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.DTO.SeguroDTO;
import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.models.Seguro;
import ifgoiano.FGSeguradora.repository.SeguroRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class SeguroService {

    private final SeguroRepository repository;

    private final ContratoService contratoService;
    private final ClienteService clienteService;
    private final GerenteService gerenteService;
//    private final AutomovelService automovelService;
//    private final SinistroService  sinistroService;

    public SeguroService(SeguroRepository repository,ContratoService contratoService,ClienteService clienteService, GerenteService gerenteService) {
        this.repository = repository;
        this.contratoService = contratoService;
        this.clienteService=clienteService;
        this.gerenteService=gerenteService;
    }

    public Seguro create(@Valid SeguroDTO objDTO) {
        clienteService.findById(objDTO.getClienteID());
        contratoService.findById(objDTO.getContratoID());
        gerenteService.findById(objDTO.getGerenteID());
        return repository.save(new Seguro(null,
                objDTO.getDataInicio(),
                objDTO.getDataFim(),
                objDTO.getApolice(),
                objDTO.getContratoID(),
                objDTO.getClienteID(),
                objDTO.getSinitroID(),
                objDTO.getAutomovelID(),
                objDTO.getGerenteID()
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
        newObj.setContratoID(objDTO.getContratoID());
        newObj.setClienteID(objDTO.getClienteID());
        newObj.setSinitroID(objDTO.getSinitroID());
        newObj.setAutomovelID(objDTO.getAutomovelID());
        newObj.setGerenteID(objDTO.getGerenteID());
        return repository.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}

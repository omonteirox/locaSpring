package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.DTO.SinistroDTO;
import ifgoiano.FGSeguradora.controller.SinistroController;
import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.models.Sinistro;
import ifgoiano.FGSeguradora.repository.SinistroRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class SinistroService {
    private final SinistroRepository repository;
    private final ClienteService clienteService;
    private final SeguroService seguroService;

    public SinistroService(SinistroRepository repository, ClienteService clienteService, SeguroService seguroService) {
        this.repository = repository;
        this.clienteService = clienteService;
        this.seguroService = seguroService;
    }
    public List<Sinistro> findAll() {
        return repository.findAll();
    }
    public Sinistro create(@Valid SinistroDTO objDTO) {
        clienteService.findById(objDTO.getCliente_id());
        seguroService.findById(objDTO.getSeguro_id());
        return repository.save(new Sinistro(
                null,
                objDTO.getPerdaParcial(),
                objDTO.getPerdaTotal(),
                objDTO.getDescricao(),
                objDTO.getCliente_id(),
                objDTO.getContrato_id(),
                objDTO.getSeguro_id()
        ));

    }
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
    public Sinistro findById(Long id) {
        Optional<Sinistro> findContrato = repository.findById(id);
        return findContrato.orElseThrow(() -> new ObjectNotFoundException("Sinistro não encontrado!! ID: " + id + ", Tipo: "
                + Sinistro.class.getName()));
    }
    public Sinistro update(Long id, SinistroDTO objDTO) {
        Sinistro sinistroUpdate = findById(id);
        sinistroUpdate.setPerdaParcial(objDTO.getPerdaParcial());
        sinistroUpdate.setPerdaTotal(objDTO.getPerdaTotal());
        sinistroUpdate.setDescricao(objDTO.getDescricao());
        sinistroUpdate.setClienteID(objDTO.getCliente_id());
        sinistroUpdate.setContratoID(objDTO.getContrato_id());
        sinistroUpdate.setSeguroID(objDTO.getSeguro_id());
        return repository.save(sinistroUpdate);
    }
}

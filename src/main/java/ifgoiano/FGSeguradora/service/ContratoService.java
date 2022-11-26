package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.DTO.ContratoDTO;
import ifgoiano.FGSeguradora.exception.DataIntegratyViolationException;
import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.models.Contrato;
import ifgoiano.FGSeguradora.repository.ContratoRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ContratoService {
    private final ContratoRepository repository;

    public ContratoService(ContratoRepository repository) {
        this.repository = repository;
    }

    public List<Contrato> findAll() {
        return repository.findAll();
    }

    public Contrato create(@Valid ContratoDTO objDTO) {

        return repository.save(new Contrato(
                null,
                objDTO.getValor(),
                objDTO.getVendedor(),
                objDTO.getCliente(),
                objDTO.getDescricao(),
                objDTO.getDataValidade()
        ));
    }

    public Contrato findById(Long id) {
        Optional<Contrato> findContrato = repository.findById(id);
        return findContrato.orElseThrow(() -> new ObjectNotFoundException("Contrato não encontrado!! ID: " + id + ", Tipo: "
                + Contrato.class.getName()));
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    public Contrato update(Long id, ContratoDTO objDTO) {
        Contrato contratoUpdate = findById(id);
        contratoUpdate.setValor(objDTO.getValor());
        contratoUpdate.setVendedor(objDTO.getVendedor());
        contratoUpdate.setCliente(objDTO.getCliente());
        contratoUpdate.setDescricao(objDTO.getDescricao());
        contratoUpdate.setDataValidade(objDTO.getDataValidade());
        return repository.save(contratoUpdate);
    }


}
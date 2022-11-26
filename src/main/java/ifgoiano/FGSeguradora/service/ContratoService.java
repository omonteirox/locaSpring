package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.DTO.ContratoDTO;
import ifgoiano.FGSeguradora.exception.DataIntegratyViolationException;
import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.models.Cliente;
import ifgoiano.FGSeguradora.models.Contrato;
import ifgoiano.FGSeguradora.models.Vendedor;
import ifgoiano.FGSeguradora.repository.ClienteRepository;
import ifgoiano.FGSeguradora.repository.ContratoRepository;
import ifgoiano.FGSeguradora.repository.VendedorRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ContratoService {
    private final ContratoRepository repository;
    private final ClienteService clienteService;
    private final VendedorService vendedorService;

    public ContratoService(ContratoRepository repository, ClienteService clienteService, VendedorService vendedorService) {
        this.repository = repository;
        this.clienteService = clienteService;
        this.vendedorService = vendedorService;
    }

    public List<Contrato> findAll() {
        return repository.findAll();
    }

    public Contrato create(@Valid ContratoDTO objDTO) {
        clienteService.findById(objDTO.getClienteID());
        vendedorService.findById(objDTO.getVendedorID());
        return repository.save(new Contrato(
                null,
                objDTO.getValor(),
                objDTO.getVendedorID(),
                objDTO.getClienteID(),
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
        contratoUpdate.setVendedorID(objDTO.getVendedorID());
        contratoUpdate.setClienteID(objDTO.getVendedorID());
        contratoUpdate.setDescricao(objDTO.getDescricao());
        contratoUpdate.setDataValidade(objDTO.getDataValidade());
        return repository.save(contratoUpdate);
    }


}
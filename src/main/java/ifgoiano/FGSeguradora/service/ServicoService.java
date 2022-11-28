package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.DTO.ServicoDTO;
import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.models.Servico;
import ifgoiano.FGSeguradora.repository.ServicoRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {
    private final ServicoRepository repository;

    public ServicoService(ServicoRepository repository) {
        this.repository = repository;
    }

    public List<Servico> findAll() {
        return repository.findAll();
    }

    public Servico create(@Valid ServicoDTO objDTO) {
        return repository.save(new Servico(null,
                objDTO.getValor(),
                objDTO.getDescricao(),
                objDTO.getDataServicoPrestado(),
                objDTO.getSeguro()
        ));
    }
    public Servico findById(Long id) {
        Optional<Servico> findGerente = repository.findById(id);
        return findGerente.orElseThrow(() -> new ObjectNotFoundException("Serviço não encontrado!! ID: " + id + ", Tipo: "
                + Servico.class.getName()));
    }

    public Servico update(Long id, ServicoDTO objDTO) {
        Servico newObj = findById(id);
        newObj.setValor(objDTO.getValor());
        newObj.setDescricao(objDTO.getDescricao());
        newObj.setDataServicoPrestado(objDTO.getDataServicoPrestado());
        newObj.setSeguro(objDTO.getSeguro());
        return repository.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}

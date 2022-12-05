package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.DTO.MensagemRespostaDTO;
import ifgoiano.FGSeguradora.DTO.ServicoDTO;
import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.mapper.ServicoMapper;
import ifgoiano.FGSeguradora.models.Servico;
import ifgoiano.FGSeguradora.repository.ServicoRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicoService {
    private final ServicoRepository repository;
    private final ServicoMapper mapper;

    public ServicoService(ServicoRepository repository, ServicoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public List<ServicoDTO> findAll() {
        List<Servico> servicoList = repository.findAll();
        List<ServicoDTO> servicoDTOList = mapper.toServicoDTOList(servicoList);
        return servicoDTOList;
    }

    public ServicoDTO findById(Long id) {
        Servico servico = verificaSeExiste(id);
        ServicoDTO converterToServicoDTO = mapper.toServicoDTO(servico);
        ServicoDTO servicoDTO = new ServicoDTO();
        servicoDTO.setId(converterToServicoDTO.getId());
        servicoDTO.setDescricao(converterToServicoDTO.getDescricao());
        servicoDTO.setDataServicoPrestado(converterToServicoDTO.getDataServicoPrestado());
        servicoDTO.setValor(converterToServicoDTO.getValor());
        servicoDTO.setTerceirizados(converterToServicoDTO.getTerceirizados());
        return servicoDTO;
    }
    public Servico verificaSeExiste(Long id) throws ObjectNotFoundException {
        Servico servico = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id));
        return servico;
    }
}

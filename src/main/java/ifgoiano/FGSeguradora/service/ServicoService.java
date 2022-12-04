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
        if(servicoList.size()>0) {
            List<ServicoDTO> servicoDTOList2 = new ArrayList<>();
            for (ServicoDTO servico : servicoDTOList) {
                ServicoDTO servicoDTO = new ServicoDTO();
                servicoDTO.setId(servico.getId());
                servicoDTO.setDescricao(servico.getDescricao());
                servicoDTO.setDataServicoPrestado(servico.getDataServicoPrestado());
                servicoDTO.setValor(servico.getValor());
                servicoDTO.setTerceirizados(servico.getTerceirizados());
                servicoDTOList2.add(servicoDTO);
            }
            return servicoDTOList2;
        } else return new ArrayList<ServicoDTO>();
    }

    public MensagemRespostaDTO create(@Valid ServicoDTO obj) {
        Servico servicoCreate = mapper.toServicoCreate(obj);
        servicoCreate.setValor(obj.getValor());
        servicoCreate.setDescricao(obj.getDescricao());
        servicoCreate.setDataServicoPrestado(obj.getDataServicoPrestado());
        servicoCreate.getTerceirizados();
        repository.save(servicoCreate);
        return MensagemRespostaDTO.builder()
                .mensagem("Seriço criado." )
                .build();
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

    public Servico update(Long id, Servico objDTO) {
        Servico newObj = repository.findById(id).get();
        newObj.setValor(objDTO.getValor());
        newObj.setDescricao(objDTO.getDescricao());
        newObj.setDataServicoPrestado(objDTO.getDataServicoPrestado());
//        newObj.setSeguro(objDTO.getSeguro());
        return repository.save(newObj);
    }

    public void delete(Long id) {
        verificaSeExiste(id);
        repository.deleteById(id);
    }

    public Servico verificaSeExiste(Long id) throws ObjectNotFoundException {
        Servico servico = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id));
        return servico;
    }
}

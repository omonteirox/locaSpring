package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.DTO.ServicoDTO;
import ifgoiano.FGSeguradora.DTO.TerceirizadoDTO;
import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.models.Servico;
import ifgoiano.FGSeguradora.models.Terceirizado;
import ifgoiano.FGSeguradora.repository.ServicoRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {
    private final ServicoRepository repository;

    public ServicoService(ServicoRepository repository) {
        this.repository = repository;
    }

    public List<ServicoDTO> findAll() {
        List<Servico> servicoList = repository.findAll();
        if(servicoList.size()>0) {
            List<ServicoDTO> servicoDTOList = new ArrayList<>();
            for (Servico servico : servicoList) {
                ServicoDTO servicoDTO = new ServicoDTO();
                servicoDTO.setId(servico.getId());
                servicoDTO.setDescricao(servico.getDescricao());
                servicoDTO.setDataServicoPrestado(servico.getDataServicoPrestado());
                servicoDTO.setValor(servico.getValor());
                servicoDTO.setTerceirizados(getTerceirizadosList(servico));
                servicoDTOList.add(servicoDTO);
            }
            return servicoDTOList;
        } else return new ArrayList<ServicoDTO>();
    }

    public Servico create(@Valid Servico obj) {
        return repository.save(new Servico(null,
                obj.getValor(),
                obj.getDescricao(),
                obj.getDataServicoPrestado(),
                obj.getSeguro(),
                obj.getTerceirizados()
        ));
    }
    public ServicoDTO findById(Long id) {
        Servico servico = repository.findById(id).get();
        ServicoDTO servicoDTO = new ServicoDTO();
        servicoDTO.setId(servico.getId());
        servicoDTO.setDescricao(servico.getDescricao());
        servicoDTO.setDataServicoPrestado(servico.getDataServicoPrestado());
        servicoDTO.setValor(servico.getValor());
        servicoDTO.setTerceirizados(getTerceirizadosList(servico));
        return servicoDTO;
    }

    public Servico update(Long id, Servico objDTO) {
        Servico newObj = repository.findById(id).get();
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
    private List<TerceirizadoDTO> getTerceirizadosList(Servico servico) {
        List<TerceirizadoDTO> servicoDTOList = new ArrayList<>();
        for(int i=0; i< servico.getTerceirizados().size(); i++) {
            TerceirizadoDTO terceirizadoDTO = new TerceirizadoDTO();
            terceirizadoDTO.setId(servico.getTerceirizados().get(i).getId());
            terceirizadoDTO.setTelefone(servico.getTerceirizados().get(i).getTelefone());
            terceirizadoDTO.setCnpj(servico.getTerceirizados().get(i).getCnpj());
            terceirizadoDTO.setRazaoSocial(servico.getTerceirizados().get(i).getRazaoSocial());
            servicoDTOList.add(terceirizadoDTO);
        }
        return servicoDTOList;
    }
}

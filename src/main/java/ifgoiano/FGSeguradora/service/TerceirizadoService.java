package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.DTO.MensagemRespostaDTO;
import ifgoiano.FGSeguradora.DTO.ServicoDTO;
import ifgoiano.FGSeguradora.DTO.TerceirizadoCreateDTO;
import ifgoiano.FGSeguradora.DTO.TerceirizadoDTO;
import ifgoiano.FGSeguradora.exception.DataIntegratyViolationException;
import ifgoiano.FGSeguradora.mapper.TerceirizadoMapper;
import ifgoiano.FGSeguradora.models.Servico;
import ifgoiano.FGSeguradora.models.Terceirizado;
import ifgoiano.FGSeguradora.repository.TerceirizadoRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Service
public class TerceirizadoService {
    private final TerceirizadoRepository repository;
    private final TerceirizadoMapper mapper;

    public TerceirizadoService(TerceirizadoRepository repository, TerceirizadoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public List<TerceirizadoDTO> findAll() {
        List<Terceirizado> terceirizadoList = repository.findAll();
        if(terceirizadoList.size()>0) {
            List<TerceirizadoDTO> terceirizadoDTOList = new ArrayList<>();
            for (Terceirizado terceirizado : terceirizadoList) {
                TerceirizadoDTO terceirizadoDTO = new TerceirizadoDTO();
                terceirizadoDTO.setId(terceirizado.getId());
                terceirizadoDTO.setCnpj(terceirizado.getCnpj());
                terceirizadoDTO.setRazaoSocial(terceirizado.getRazaoSocial());
                terceirizadoDTO.setTelefone(terceirizado.getTelefone());
                terceirizadoDTO.setServicos(terceirizado.getServicos());
                terceirizadoDTOList.add(terceirizadoDTO);
            }
            return terceirizadoDTOList;
        } else return new ArrayList<TerceirizadoDTO>();
    }
    
    public MensagemRespostaDTO create(@Valid TerceirizadoCreateDTO objDTO) {
        if(findByCNPJ(objDTO) != null){
            throw new DataIntegratyViolationException("CNPJ já cadastrado na base de dados!");
        }
        Terceirizado terceirizadoCreate = mapper.toTerceirizadoCreate(objDTO);
        terceirizadoCreate.setRazaoSocial(objDTO.getRazaoSocial());
        terceirizadoCreate.setCnpj(objDTO.getCnpj());
        terceirizadoCreate.setTelefone(objDTO.getTelefone());
        terceirizadoCreate.getServicos();
        repository.save(terceirizadoCreate);
        return MensagemRespostaDTO.builder()
                .mensagem("Terceirizado com id " + terceirizadoCreate.getId() + " criado." )
                .build();
    }
    public TerceirizadoDTO findById(Long id) {
        Terceirizado terceirizado = repository.findById(id).get();
        TerceirizadoDTO terceirizadoDTO = new TerceirizadoDTO();
        terceirizadoDTO.setId(terceirizado.getId());
        terceirizadoDTO.setCnpj(terceirizado.getCnpj());
        terceirizadoDTO.setRazaoSocial(terceirizado.getRazaoSocial());
        terceirizadoDTO.setTelefone(terceirizado.getTelefone());
//        terceirizadoDTO.setServicos(getServicosList(terceirizado));
        return terceirizadoDTO;
    }

    public Terceirizado update(Long id, Terceirizado objDTO) {
        Terceirizado newObj = repository.findById(id).get();
//        if(findByCNPJ(objDTO) !=null && findByCNPJ(objDTO).getId() != id){
//            throw new DataIntegratyViolationException("CNPJ já cadastrado na base de dados!");
//        }
        newObj.setRazaoSocial(objDTO.getRazaoSocial());
        newObj.setTelefone(objDTO.getTelefone());
        newObj.setCnpj(objDTO.getCnpj());
        newObj.setServicos(objDTO.getServicos());
        return repository.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    private Terceirizado findByCNPJ(TerceirizadoCreateDTO objDTO){
        Terceirizado obj = repository.findByCNPJ(objDTO.getCnpj());
        if(obj!=null){
            return obj;
        }
        return null;
    }
}

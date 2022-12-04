package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.DTO.MensagemRespostaDTO;
import ifgoiano.FGSeguradora.DTO.TerceirizadoCreateDTO;
import ifgoiano.FGSeguradora.DTO.TerceirizadoDTO;
import ifgoiano.FGSeguradora.exception.DataIntegratyViolationException;
import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.mapper.ServicoMapper;
import ifgoiano.FGSeguradora.mapper.TerceirizadoMapper;
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

    private final ServicoMapper servicoMapper;

    public TerceirizadoService(TerceirizadoRepository repository, TerceirizadoMapper mapper, ServicoMapper servicoMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.servicoMapper = servicoMapper;
    }


    public List<TerceirizadoDTO> findAll() {
        List<Terceirizado> terceirizadoList = repository.findAll();
        List<TerceirizadoDTO> servicoCreate = mapper.toTerceirizadoCreateDTOList(terceirizadoList);
        if(terceirizadoList.size()>0) {
            List<TerceirizadoDTO> terceirizadoDTOList = new ArrayList<>();
            for (TerceirizadoDTO terceirizado : servicoCreate) {
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
    public TerceirizadoDTO findById(Long id)  throws ObjectNotFoundException{
        Terceirizado terceirizado = verificaSeExiste(id);
        TerceirizadoDTO terceirizadoDTOList= mapper.toTerceirizadoDTO(terceirizado);
        TerceirizadoDTO terceirizadoDTO = new TerceirizadoDTO();
        terceirizadoDTO.setId(terceirizadoDTOList.getId());
        terceirizadoDTO.setCnpj(terceirizadoDTOList.getCnpj());
        terceirizadoDTO.setRazaoSocial(terceirizadoDTOList.getRazaoSocial());
        terceirizadoDTO.setTelefone(terceirizadoDTOList.getTelefone());
        terceirizadoDTO.setServicos(terceirizadoDTOList.getServicos());
        return terceirizadoDTO;
    }

    public MensagemRespostaDTO update(Long id, TerceirizadoDTO objDTO) {
        Terceirizado newObj = verificaSeExiste(id);
        TerceirizadoDTO terceirizadoDTOList= mapper.toTerceirizadoDTO(newObj);
        if(findByCNPJCreate(objDTO) !=null && findByCNPJCreate(objDTO).getId() != id){
            throw new DataIntegratyViolationException("CNPJ já cadastrado na base de dados!");
        }
        terceirizadoDTOList.setRazaoSocial(objDTO.getRazaoSocial());
        terceirizadoDTOList.setTelefone(objDTO.getTelefone());
        terceirizadoDTOList.setCnpj(objDTO.getCnpj());
        terceirizadoDTOList.setServicos(objDTO.getServicos());

        Terceirizado terceirizadoCreate = mapper.toTerceirizado(terceirizadoDTOList);
        repository.save(terceirizadoCreate);
        return MensagemRespostaDTO.builder()
                .mensagem("Terceirizado com id " + terceirizadoCreate.getId() + " alterado." )
                .build();
    }

    public void delete(Long id) {
        verificaSeExiste(id);
        repository.deleteById(id);
    }

    private Terceirizado findByCNPJ(TerceirizadoCreateDTO objDTO){
        Terceirizado obj = repository.findByCNPJ(objDTO.getCnpj());
        if(obj!=null){
            return obj;
        }
        return null;
    }
    private Terceirizado findByCNPJCreate(TerceirizadoDTO objDTO){
        Terceirizado obj = repository.findByCNPJ(objDTO.getCnpj());
        if(obj!=null){
            return obj;
        }
        return null;
    }
    public Terceirizado verificaSeExiste(Long id) throws ObjectNotFoundException {
        Terceirizado terceirizado = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id));
        return terceirizado;
    }


}

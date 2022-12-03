package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.DTO.ServicoDTO;
import ifgoiano.FGSeguradora.DTO.TerceirizadoDTO;
import ifgoiano.FGSeguradora.exception.DataIntegratyViolationException;
import ifgoiano.FGSeguradora.models.Terceirizado;
import ifgoiano.FGSeguradora.repository.TerceirizadoRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Service
public class TerceirizadoService {
    private final TerceirizadoRepository repository;

    public TerceirizadoService(TerceirizadoRepository repository) {
        this.repository = repository;
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
                terceirizadoDTO.setServicos(getServicosList(terceirizado));
                terceirizadoDTOList.add(terceirizadoDTO);
            }
            return terceirizadoDTOList;
        } else return new ArrayList<TerceirizadoDTO>();
    }

    private List<ServicoDTO> getServicosList(Terceirizado terceirizado) {
        List<ServicoDTO> servicoDTOList = new ArrayList<>();
        for(int i=0; i< terceirizado.getServicos().size(); i++) {
            ServicoDTO servicoDTO = new ServicoDTO();
            servicoDTO.setId(terceirizado.getServicos().get(i).getId());
            servicoDTO.setDescricao(terceirizado.getServicos().get(i).getDescricao());
            servicoDTO.setValor(terceirizado.getServicos().get(i).getValor());
            servicoDTO.setDataServicoPrestado(terceirizado.getServicos().get(i).getDataServicoPrestado());
            servicoDTO.setSeguro(terceirizado.getServicos().get(i).getSeguro());
            servicoDTOList.add(servicoDTO);
        }
        return servicoDTOList;
    }

    public Terceirizado create(@Valid Terceirizado objDTO) {
        if(findByCNPJ(objDTO) != null){
            throw new DataIntegratyViolationException("CNPJ já cadastrado na base de dados!");
        }
        return repository.save(new Terceirizado(null,
                objDTO.getRazaoSocial(),
                objDTO.getTelefone(),
                objDTO.getCnpj(),
                objDTO.getServicos()
        ));
    }
    public TerceirizadoDTO findById(Long id) {
        Terceirizado terceirizado = repository.findById(id).get();
        TerceirizadoDTO terceirizadoDTO = new TerceirizadoDTO();
        terceirizadoDTO.setId(terceirizado.getId());
        terceirizadoDTO.setCnpj(terceirizado.getCnpj());
        terceirizadoDTO.setRazaoSocial(terceirizado.getRazaoSocial());
        terceirizadoDTO.setTelefone(terceirizado.getTelefone());
        terceirizadoDTO.setServicos(getServicosList(terceirizado));
        return terceirizadoDTO;
    }

    public Terceirizado update(Long id, Terceirizado objDTO) {
        Terceirizado newObj = repository.findById(id).get();
        if(findByCNPJ(objDTO) !=null && findByCNPJ(objDTO).getId() != id){
            throw new DataIntegratyViolationException("CNPJ já cadastrado na base de dados!");
        }
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

    private Terceirizado findByCNPJ(Terceirizado objDTO){
        Terceirizado obj = repository.findByCNPJ(objDTO.getCnpj());
        if(obj!=null){
            return obj;
        }
        return null;
    }
}

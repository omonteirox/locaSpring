package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.DTO.CaminhoneteDTO;
import ifgoiano.FGSeguradora.exception.DataIntegratyViolationException;
import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.models.Automovel;
import ifgoiano.FGSeguradora.repository.AutomovelRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class CaminhoneteService {
    private final AutomovelRepository repository;

    public CaminhoneteService(AutomovelRepository repository) {
        this.repository = repository;
    }

    public List<Automovel> findAll() {
        return repository.findAllCaminhonetes();
    }

    public Automovel create(@Valid CaminhoneteDTO objDTO) {
        if (findByChassi(objDTO) != null)
            throw new DataIntegratyViolationException("Chassi já cadastrado na base de dados!");
        if (findByPlaca(objDTO) != null)
            throw new DataIntegratyViolationException("Placa já cadastrado na base de dados!");
        return repository.save(new Automovel(null,
                objDTO.getTipoAutomovel(),
                objDTO.getCor(),
                objDTO.getValorFipe(),
                objDTO.getAno(),
                objDTO.getPlaca(),
                objDTO.getMarca(),
                objDTO.getChassi(),
                objDTO.getModelo(),
                objDTO.getCavalosPotencia(),
                objDTO.isCarroceriaDupla(),
                objDTO.isQuatroPorQuatro(),
                objDTO.getQuantidadePortas()
        ));
    }

    public Automovel findById(Long id) {
        Optional<Automovel> findCaminhonete = repository.findById(id);
        return findCaminhonete.orElseThrow(() -> new ObjectNotFoundException("Caminhonete não encontrado!! ID: " + id + ", Tipo: "
                + Automovel.class.getName()));
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    public Automovel update(Long id, CaminhoneteDTO objDTO) {

        Automovel caminhoneteUpdate = findById(id);
        if (objDTO.getChassi().equals(caminhoneteUpdate.getChassi()))
            throw new DataIntegratyViolationException("Chassi já cadastrado na base de dados!");
        if (objDTO.getPlaca().equals(caminhoneteUpdate.getPlaca()))
            throw new DataIntegratyViolationException("Placa já cadastrado na base de dados!");
        caminhoneteUpdate.setTipoAutomovel(objDTO.getTipoAutomovel());
        caminhoneteUpdate.setCor(objDTO.getCor());
        caminhoneteUpdate.setValorFipe(objDTO.getValorFipe());
        caminhoneteUpdate.setAno(objDTO.getAno());
        caminhoneteUpdate.setPlaca(objDTO.getPlaca());
        caminhoneteUpdate.setMarca(objDTO.getMarca());
        caminhoneteUpdate.setChassi(objDTO.getChassi());
        caminhoneteUpdate.setModelo(objDTO.getModelo());
        caminhoneteUpdate.setCavalosPotencia(objDTO.getCavalosPotencia());
        caminhoneteUpdate.setCarroceriaDupla(objDTO.isCarroceriaDupla());
        caminhoneteUpdate.setQuatroPorQuatro(objDTO.isQuatroPorQuatro());
        caminhoneteUpdate.setQuantidadePortas(objDTO.getQuantidadePortas());

        return repository.save(caminhoneteUpdate);
    }

    private Automovel findByChassi(CaminhoneteDTO objDTO) {
        Automovel obj = repository.findByChassi(objDTO.getChassi());
        if (obj != null) {
            return obj;
        }
        return null;
    }

    private Automovel findByPlaca(CaminhoneteDTO objDTO) {
        Automovel obj = repository.findByPlaca(objDTO.getPlaca());
        if (obj != null) {
            return obj;
        }
        return null;
    }
    public Automovel verificaSeExiste(Long id) throws ObjectNotFoundException {
        Automovel automovel = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id));
        return automovel;
    }

}
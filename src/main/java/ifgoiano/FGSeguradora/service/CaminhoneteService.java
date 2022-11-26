package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.DTO.CaminhoneteDTO;
import ifgoiano.FGSeguradora.exception.DataIntegratyViolationException;
import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.models.Caminhonete;
import ifgoiano.FGSeguradora.repository.CaminhoneteRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class CaminhoneteService {
    private final CaminhoneteRepository repository;

    public CaminhoneteService(CaminhoneteRepository repository) {
        this.repository = repository;
    }

    public List<Caminhonete> findAll() {
        return repository.findAll();
    }

    public Caminhonete create(@Valid CaminhoneteDTO objDTO) {
        if (findByChassi(objDTO) != null)
            throw new DataIntegratyViolationException("Chassi já cadastrado na base de dados!");
        if (findByPlaca(objDTO) != null)
            throw new DataIntegratyViolationException("Placa já cadastrado na base de dados!");

        return repository.save(new Caminhonete(null,
                objDTO.getCor(),
                objDTO.getValorFipe(),
                objDTO.getAno(),
                objDTO.getPlaca(),
                objDTO.getMarca(),
                objDTO.getChassi(),
                objDTO.getModelo(),
                objDTO.getCavalosPotencia(),
                objDTO.isCarroceriaDupla(),
                objDTO.isQuatroPorQuatro()
        ));
    }

    public Caminhonete findById(Long id) {
        Optional<Caminhonete> findCaminhonete = repository.findById(id);
        return findCaminhonete.orElseThrow(() -> new ObjectNotFoundException("Caminhonete não encontrado!! ID: " + id + ", Tipo: "
                + Caminhonete.class.getName()));
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    public Caminhonete update(Long id, CaminhoneteDTO objDTO) {

        Caminhonete caminhoneteUpdate = findById(id);
        if (objDTO.getChassi().equals(caminhoneteUpdate.getChassi()))
            throw new DataIntegratyViolationException("Chassi já cadastrado na base de dados!");
        if (objDTO.getPlaca().equals(caminhoneteUpdate.getPlaca()))
            throw new DataIntegratyViolationException("Placa já cadastrado na base de dados!");
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

        return repository.save(caminhoneteUpdate);
    }

    private Caminhonete findByChassi(CaminhoneteDTO objDTO) {
        Caminhonete obj = repository.findByChassi(objDTO.getChassi());
        if (obj != null) {
            return obj;
        }
        return null;
    }

    private Caminhonete findByPlaca(CaminhoneteDTO objDTO) {
        Caminhonete obj = repository.findByPlaca(objDTO.getPlaca());
        if (obj != null) {
            return obj;
        }
        return null;
    }
}
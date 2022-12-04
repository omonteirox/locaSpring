package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.DTO.CarroDTO;
import ifgoiano.FGSeguradora.exception.DataIntegratyViolationException;
import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.models.Automovel;
import ifgoiano.FGSeguradora.repository.AutomovelRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    private final AutomovelRepository repository;

    public CarroService(AutomovelRepository repository) {
        this.repository = repository;
    }

    public List<Automovel> findAll() {
        return repository.findAllCarros();
    }

    public Automovel create(@Valid CarroDTO objDTO) {
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

    public Automovel update(Long id, CarroDTO objDTO) {

        Automovel carroUpdate = findById(id);
        if (objDTO.getChassi().equals(carroUpdate.getChassi()))
            throw new DataIntegratyViolationException("Chassi já cadastrado na base de dados!");
        if (objDTO.getPlaca().equals(carroUpdate.getPlaca()))
            throw new DataIntegratyViolationException("Placa já cadastrado na base de dados!");
        carroUpdate.setTipoAutomovel(objDTO.getTipoAutomovel());
        carroUpdate.setCor(objDTO.getCor());
        carroUpdate.setValorFipe(objDTO.getValorFipe());
        carroUpdate.setAno(objDTO.getAno());
        carroUpdate.setPlaca(objDTO.getPlaca());
        carroUpdate.setMarca(objDTO.getMarca());
        carroUpdate.setChassi(objDTO.getChassi());
        carroUpdate.setModelo(objDTO.getModelo());
        carroUpdate.setCavalosPotencia(objDTO.getCavalosPotencia());
        carroUpdate.setQuantidadePortas(objDTO.getQuantidadePortas());

        return repository.save(carroUpdate);
    }

    private Automovel findByChassi(CarroDTO objDTO) {
        Automovel obj = repository.findByChassi(objDTO.getChassi());
        if (obj != null) {
            return obj;
        }
        return null;
    }

    private Automovel findByPlaca(CarroDTO objDTO) {
        Automovel obj = repository.findByPlaca(objDTO.getPlaca());
        if (obj != null) {
            return obj;
        }
        return null;
    }

}

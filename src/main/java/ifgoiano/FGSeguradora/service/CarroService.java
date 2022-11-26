package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.DTO.CarroDTO;
import ifgoiano.FGSeguradora.exception.DataIntegratyViolationException;
import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.models.Carro;
import ifgoiano.FGSeguradora.repository.CarroRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {
    private final CarroRepository repository;

    public CarroService(CarroRepository repository) {
        this.repository = repository;
    }

    public List<Carro> findAll() {
        return repository.findAll();
    }

    public Carro create(@Valid CarroDTO objDTO) {
        if (findByChassi(objDTO) != null)
            throw new DataIntegratyViolationException("Chassi já cadastrado na base de dados!");
        if (findByPlaca(objDTO) != null)
            throw new DataIntegratyViolationException("Placa já cadastrado na base de dados!");

        return repository.save(new Carro(null,
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

    public Carro findById(Long id) {
        Optional<Carro> findCarro = repository.findById(id);
        return findCarro.orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado!! ID: " + id + ", Tipo: "
                + Carro.class.getName()));
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    public Carro update(Long id, CarroDTO objDTO) {
        Carro carroUpdate = findById(id);
        if (objDTO.getChassi().equals(carroUpdate.getChassi()))
            throw new DataIntegratyViolationException("Chassi já cadastrado na base de dados!");
        if (objDTO.getPlaca().equals(carroUpdate.getPlaca()))
            throw new DataIntegratyViolationException("Placa já cadastrado na base de dados!");
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

    private Carro findByChassi(CarroDTO objDTO) {
        Carro obj = repository.findByChassi(objDTO.getChassi());
        if (obj != null) {
            return obj;
        }
        return null;
    }

    private Carro findByPlaca(CarroDTO objDTO) {
        Carro obj = repository.findByPlaca(objDTO.getPlaca());
        if (obj != null) {
            return obj;
        }
        return null;
    }
}

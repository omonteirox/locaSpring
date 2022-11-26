package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.DTO.CarroDTO;
import ifgoiano.FGSeguradora.DTO.GerenteDTO;
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
        // Long id, String cor, Double valorFipe, Integer ano, String placa, String marca, String Chassi, String modelo, Double cavalosPotencia, Integer quantidadePortas
        Carro carroUpdate = findById(id);
        carroUpdate.setCor(objDTO.getCor());
        carroUpdate.setValorFipe(objDTO.getValorFipe());
        carroUpdate.setAno(objDTO.getAno());
        carroUpdate.setChassi(objDTO.getChassi());
        carroUpdate.setModelo(objDTO.getModelo());
        carroUpdate.setCavalosPotencia(objDTO.getCavalosPotencia());
        carroUpdate.setQuantidadePortas(objDTO.getQuantidadePortas());
        return repository.save(carroUpdate);
    }
}

package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.DTO.MotoDTO;
import ifgoiano.FGSeguradora.exception.DataIntegratyViolationException;
import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.models.Moto;
import ifgoiano.FGSeguradora.repository.MotoRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class MotoService {
    private final MotoRepository repository;

    public MotoService(MotoRepository repository) {
        this.repository = repository;
    }

    public List<Moto> findAll() {
        return repository.findAll();
    }

    public Moto create(@Valid MotoDTO objDTO) {
        if (findByChassi(objDTO) != null)
            throw new DataIntegratyViolationException("Chassi já cadastrado na base de dados!");
        if (findByPlaca(objDTO) != null)
            throw new DataIntegratyViolationException("Placa já cadastrado na base de dados!");
        return repository.save(new Moto(null,
                objDTO.getCor(),
                objDTO.getValorFipe(),
                objDTO.getAno(),
                objDTO.getPlaca(),
                objDTO.getMarca(),
                objDTO.getChassi(),
                objDTO.getModelo(),
                objDTO.getCategoria(),
                objDTO.getCilindrada()
        ));
    }

    public Moto findById(Long id) {
        Optional<Moto> findMoto = repository.findById(id);
        return findMoto.orElseThrow(() -> new ObjectNotFoundException("Moto não encontrado!! ID: " + id + ", Tipo: "
                + Moto.class.getName()));
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    public Moto update(Long id, MotoDTO objDTO) {
        Moto motoUpdate = findById(id);
        if (objDTO.getChassi().equals(motoUpdate.getChassi()))
            throw new DataIntegratyViolationException("Chassi já cadastrado na base de dados!");
        if (objDTO.getPlaca().equals(motoUpdate.getPlaca()))
            throw new DataIntegratyViolationException("Placa já cadastrado na base de dados!");
        motoUpdate.setCor(objDTO.getCor());
        motoUpdate.setValorFipe(objDTO.getValorFipe());
        motoUpdate.setAno(objDTO.getAno());
        motoUpdate.setPlaca(objDTO.getPlaca());
        motoUpdate.setMarca(objDTO.getMarca());
        motoUpdate.setChassi(objDTO.getChassi());
        motoUpdate.setModelo(objDTO.getModelo());
        motoUpdate.setCategoria(objDTO.getCategoria());
        motoUpdate.setCilindrada(objDTO.getCilindrada());

        return repository.save(motoUpdate);
    }

    private Moto findByChassi(MotoDTO objDTO) {
        Moto obj = repository.findByChassi(objDTO.getChassi());
        if (obj != null) {
            return obj;
        }
        return null;
    }

    private Moto findByPlaca(MotoDTO objDTO) {
        Moto obj = repository.findByPlaca(objDTO.getPlaca());
        if (obj != null) {
            return obj;
        }
        return null;
    }
}

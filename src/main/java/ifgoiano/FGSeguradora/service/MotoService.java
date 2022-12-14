package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.DTO.MotoDTO;
import ifgoiano.FGSeguradora.exception.DataIntegratyViolationException;
import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.models.Automovel;
import ifgoiano.FGSeguradora.repository.AutomovelRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class MotoService {

    private final AutomovelRepository repository;

    public MotoService(AutomovelRepository repository) {
        this.repository = repository;
    }

    public List<Automovel> findAll() {
        return repository.findAllMotos();
    }

    public Automovel create(@Valid MotoDTO objDTO) {
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
                objDTO.getCategoria(),
                objDTO.getCilindrada()
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

    public Automovel update(Long id, MotoDTO objDTO) {

        Automovel motoUpdate = findById(id);
        if (objDTO.getChassi().equals(motoUpdate.getChassi()))
            throw new DataIntegratyViolationException("Chassi já cadastrado na base de dados!");
        if (objDTO.getPlaca().equals(motoUpdate.getPlaca()))
            throw new DataIntegratyViolationException("Placa já cadastrado na base de dados!");
        motoUpdate.setTipoAutomovel(objDTO.getTipoAutomovel());
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

    private Automovel findByChassi(MotoDTO objDTO) {
        Automovel obj = repository.findByChassi(objDTO.getChassi());
        if (obj != null) {
            return obj;
        }
        return null;
    }

    private Automovel findByPlaca(MotoDTO objDTO) {
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

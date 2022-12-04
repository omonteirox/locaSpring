package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.DTO.MensagemRespostaDTO;
import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.models.Automovel;
import ifgoiano.FGSeguradora.repository.AutomovelRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AutomovelService {
    @Autowired
    private final AutomovelRepository repository;

    public List<Automovel> findAll(){
        List<Automovel> automovelList = repository.findAll();
        return automovelList;
    }

    public Automovel findById(Long id) throws ObjectNotFoundException {
        Automovel automovel = verificaSeExiste(id);
        return  automovel;
    }

    public MensagemRespostaDTO create(Automovel automovel){
        Automovel automovelcreate = repository.save(automovel);

        return MensagemRespostaDTO
                .builder()
                .mensagem("Automovel criado com ID " + automovelcreate.getId())
                .build();
    }

    public MensagemRespostaDTO update(Long id, Automovel automovelAtualizado) throws ObjectNotFoundException {
        Automovel automovel = verificaSeExiste(id);
        automovel.setTipoAutomovel(automovelAtualizado.getTipoAutomovel());
        automovel.setCor(automovelAtualizado.getCor());
        automovel.setValorFipe(automovelAtualizado.getValorFipe());
        automovel.setAno(automovelAtualizado.getAno());
        automovel.setPlaca(automovelAtualizado.getPlaca());
        automovel.setMarca(automovelAtualizado.getMarca());
        automovel.setChassi(automovelAtualizado.getChassi());
        automovel.setModelo(automovelAtualizado.getModelo());
        repository.save(automovel);
        return MensagemRespostaDTO
                .builder()
                .mensagem("Veículo com código " + id + " atualizado")
                .build();
    }


    public void delete(Long id) throws ObjectNotFoundException {
        repository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException(id));
        repository.deleteById(id);
    }

    public Automovel verificaSeExiste(Long id) throws ObjectNotFoundException {
        Automovel automovel = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id));
        return automovel;
    }
}

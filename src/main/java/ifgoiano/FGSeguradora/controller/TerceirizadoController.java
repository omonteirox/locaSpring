package ifgoiano.FGSeguradora.controller;

import ifgoiano.FGSeguradora.DTO.MensagemRespostaDTO;
import ifgoiano.FGSeguradora.DTO.TerceirizadoCreateDTO;
import ifgoiano.FGSeguradora.DTO.TerceirizadoDTO;
import ifgoiano.FGSeguradora.mapper.TerceirizadoMapper;
import ifgoiano.FGSeguradora.models.Terceirizado;
import ifgoiano.FGSeguradora.repository.TerceirizadoRepository;
import ifgoiano.FGSeguradora.service.TerceirizadoService;
import io.swagger.annotations.Api;
import org.hibernate.ObjectDeletedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "Terceirizado",description = "Tudo sobre Terceirizado")
@RestController
@RequestMapping("/terceirizado")
public class TerceirizadoController {
    private final TerceirizadoService service;
    private final TerceirizadoRepository repository;
    private final TerceirizadoMapper mapper;

    public TerceirizadoController(TerceirizadoService service, TerceirizadoRepository repository, TerceirizadoMapper mapper) {
        this.service = service;
        this.repository = repository;
        this.mapper = mapper;
    }


    @PostMapping("/create")

    public ResponseEntity<MensagemRespostaDTO> create(@RequestBody TerceirizadoCreateDTO terceirizado) throws ObjectDeletedException {
        var obj = service.create(terceirizado);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @GetMapping("/detalhes/{id}")

    public TerceirizadoDTO findById(@PathVariable Long id) {
        if(repository.findById(id).isPresent()) {
            return service.findById(id);
        }
    else return  null;

    }

    @GetMapping("/all")

    public List<TerceirizadoDTO> findAll() {
        return service.findAll();
    }

    @PutMapping("/atualizar/{id}")

    public Terceirizado update(@PathVariable Long id, @RequestBody Terceirizado terceirizado) {

        return service.update(id,terceirizado);

    }

    @DeleteMapping("/deletar/{id}")

    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();

    }
}

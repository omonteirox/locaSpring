package ifgoiano.FGSeguradora.controller;

import ifgoiano.FGSeguradora.DTO.TerceirizadoDTO;
import ifgoiano.FGSeguradora.models.Terceirizado;
import ifgoiano.FGSeguradora.repository.TerceirizadoRepository;
import ifgoiano.FGSeguradora.service.TerceirizadoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "Terceirizado",description = "Tudo sobre Terceirizado")
@RestController
@RequestMapping("/terceirizado")
public class TerceirizadoController {
    @Autowired
    public TerceirizadoService service;

    @Autowired
    public TerceirizadoRepository repository;
    @PostMapping("/create")

    public ResponseEntity<Terceirizado> create(@RequestBody Terceirizado terceirizado) {
        Terceirizado obj = service.create(terceirizado);
        return ResponseEntity.ok().body(obj);

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

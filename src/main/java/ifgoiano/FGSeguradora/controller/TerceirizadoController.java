package ifgoiano.FGSeguradora.controller;

import ifgoiano.FGSeguradora.DTO.TerceirizadoDTO;
import ifgoiano.FGSeguradora.models.Terceirizado;
import ifgoiano.FGSeguradora.service.TerceirizadoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
@Api(tags = "Terceirizado",description = "Tudo sobre Terceirizado")
@RestController
@RequestMapping("/terceirizado")
public class TerceirizadoController {
    @Autowired
    public TerceirizadoService service;
    @ApiOperation(value = "Consultar Terceirizado")
    @GetMapping(value = "/{id}")
    public ResponseEntity<TerceirizadoDTO> findById(@PathVariable Long id) {
        TerceirizadoDTO objDTO = new TerceirizadoDTO(service.findById(id));
        return ResponseEntity.ok().body(objDTO);
    }
    @ApiOperation(value = "Criar Terceirizado")
    @PostMapping
    public ResponseEntity<TerceirizadoDTO> create(@Valid @RequestBody TerceirizadoDTO objDTO) {
        Terceirizado newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @ApiOperation(value = "Listar todos os Terceirizados")
    @GetMapping
    public ResponseEntity<List<TerceirizadoDTO>> findAll() {
        List<TerceirizadoDTO> listDTO = service.findAll()
                .stream().map(obj -> new TerceirizadoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
    @ApiOperation(value = "Atualizar Terceirizado")
    @PutMapping(value = "/{id}")
    public ResponseEntity<TerceirizadoDTO> update(@PathVariable Long id, @Valid @RequestBody TerceirizadoDTO objDTO) {
        TerceirizadoDTO newObj = new TerceirizadoDTO(service.update(id, objDTO));
        return ResponseEntity.ok().body(newObj);

    }
    @ApiOperation(value = "Deletar Terceirizado")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

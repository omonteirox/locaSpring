package ifgoiano.FGSeguradora.controller;

import ifgoiano.FGSeguradora.DTO.CarroDTO;
import ifgoiano.FGSeguradora.mapper.AutomovelMapper;
import ifgoiano.FGSeguradora.models.Automovel;
import ifgoiano.FGSeguradora.service.CarroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@Api(tags = "Carro",description = "Tudo sobre Carro")
@RequestMapping("/carro")
public class CarroController {
    public final CarroService service;
    private final AutomovelMapper mapper;

    public CarroController(CarroService service, AutomovelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @ApiOperation(value = "Consultar Carro")
    @GetMapping(value = "/{id}")
    public ResponseEntity<CarroDTO> findById(@PathVariable Long id) {
        CarroDTO objDTO = new CarroDTO(service.findById(id));
        return ResponseEntity.ok().body(objDTO);
    }

    @ApiOperation(value = "Criar Carro")
    @PostMapping
    public ResponseEntity<CarroDTO> create(@Valid @RequestBody CarroDTO objDTO) {
        Automovel newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @ApiOperation(value = "Listar todos os Carros")
    @GetMapping
    public ResponseEntity<List<CarroDTO>> findAll() {
        List<CarroDTO> listDTO = service.findAll()
                .stream().map(obj -> new CarroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @ApiOperation(value = "Atualizar Carro")
    @PutMapping(value = "/{id}")
    public ResponseEntity<CarroDTO> update(@PathVariable Long id, @Valid @RequestBody CarroDTO objDTO) {
        CarroDTO newObj = new CarroDTO(service.update(id, objDTO));
        return ResponseEntity.ok().body(newObj);

    }

    @ApiOperation(value = "Deletar Carro")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

package ifgoiano.FGSeguradora.controller;

import ifgoiano.FGSeguradora.DTO.AutomovelDTO;
import ifgoiano.FGSeguradora.DTO.MensagemRespostaDTO;
import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.mapper.AutomovelMapper;
import ifgoiano.FGSeguradora.models.Automovel;
import ifgoiano.FGSeguradora.service.AutomovelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(tags = "Automóvel",description = "Tudo sobre Automóvel")
@RequestMapping("/automovel")
public class AutomovelController {

    private final AutomovelService service;
    private final AutomovelMapper mapper;

    public AutomovelController(AutomovelService service, AutomovelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }


    @PostMapping
    @ApiOperation("Cadastar veículo")
    public ResponseEntity<MensagemRespostaDTO> create(@RequestBody @Valid AutomovelDTO createDTO){
        var automovelCreate = mapper.toAutomovel(createDTO);
        var automovel = service.create(automovelCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(automovel);
    }

    @GetMapping
    @ApiOperation("Buscar todos veículos")
    public ResponseEntity<List<AutomovelDTO>> findAll(){
        var veiculoList = service.findAll();
        var veiculoListDTO = mapper.toAutomovelDTOList(veiculoList);
        return ResponseEntity.ok().body(veiculoListDTO);
    }

    @GetMapping("{id}")
    @ApiOperation("Buscar um veículo")
    public ResponseEntity<AutomovelDTO> findById(@PathVariable Long id) throws ObjectNotFoundException {
        var automovel = service.findById(id);
        var automovelDTO = mapper.toAutomovelDTO(automovel);
        return ResponseEntity.ok(automovelDTO);
    }

    @PutMapping("{id}")
    @ApiOperation("Atualizar veículo")
    public ResponseEntity<MensagemRespostaDTO> update(@PathVariable Long id,
                                                     @RequestBody AutomovelDTO automovelDTO) throws ObjectNotFoundException {
        var veiculoUpdate = mapper.toAutomovel(automovelDTO);
        var message = service.update(id,veiculoUpdate);
        return ResponseEntity.ok().body(message);
    }

    @DeleteMapping("{id}")
    @ApiOperation("Deletar veículo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws ObjectNotFoundException {
        service.delete(id);
    }

}

package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.DTO.ClienteCreateDTO;
import ifgoiano.FGSeguradora.DTO.MensagemRespostaDTO;
import ifgoiano.FGSeguradora.exception.DataIntegratyViolationException;
import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.mapper.ClienteMapper;
import ifgoiano.FGSeguradora.models.Automovel;
import ifgoiano.FGSeguradora.models.Cliente;
import ifgoiano.FGSeguradora.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository repository;
    private final CarroService carroService;
    private final MotoService motoService;
    private final CaminhoneteService caminhoneteService;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository repository,
                          CarroService carroService, MotoService motoService, CaminhoneteService caminhoneteService, ClienteMapper clienteMapper) {
        this.repository = repository;
        this.carroService = carroService;
        this.motoService = motoService;
        this.caminhoneteService = caminhoneteService;
        this.clienteMapper = clienteMapper;
    }


//    LISTAR SEGUROS, SALVAR ID DE AUTOMOVEL E LISTAR AUTOMOVEL



    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public MensagemRespostaDTO create(@Valid ClienteCreateDTO objDTO) {
        if (findByCPF(objDTO) != null) {
            throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
        }
        List<Automovel> automovelList = new ArrayList<>();
        for(Long id: objDTO.getAutomoveis_id()) {
            automovelList.add(carroService.verificaSeExiste(id));
            automovelList.add(motoService.verificaSeExiste(id));
            automovelList.add(caminhoneteService.verificaSeExiste(id));
        }
        Cliente clientecreate = clienteMapper.toClienteCreate(objDTO);
        clientecreate.setNome(objDTO.getNome());
        clientecreate.setCpf(objDTO.getCpf());
        clientecreate.setDataNascimento(objDTO.getDataNascimento());
        clientecreate.setGenero(objDTO.getGenero());
        clientecreate.setEndereco(objDTO.getEndereco());
        clientecreate.setAutomoveis(automovelList);
        repository.save(clientecreate);
        return MensagemRespostaDTO.builder()
                .mensagem("Cliente com id " + clientecreate.getId() + " criado." )
                .build();
    }

    public Cliente findById(Long id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado!! ID: " + id + ", Tipo: "
                + Cliente.class.getName()));
    }

    public MensagemRespostaDTO update(Long id, ClienteCreateDTO objDTO) {
        Cliente cliente = verificaSeExiste(id);
        if (findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
            throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
        }
        List<Automovel> automovelList = new ArrayList<>();
        for(Long id_automovel: objDTO.getAutomoveis_id()) {
            automovelList.add(carroService.verificaSeExiste(id));
            automovelList.add(motoService.verificaSeExiste(id));
            automovelList.add(caminhoneteService.verificaSeExiste(id));
        }
        Cliente clientecreate = clienteMapper.toClienteCreate(objDTO);
        clientecreate.setNome(objDTO.getNome());
        clientecreate.setCpf(objDTO.getCpf());
        clientecreate.setDataNascimento(objDTO.getDataNascimento());
        clientecreate.setGenero(objDTO.getGenero());
        clientecreate.setEndereco(objDTO.getEndereco());
        clientecreate.setAutomoveis(automovelList);

        repository.save(clientecreate);

        return MensagemRespostaDTO.builder()
                .mensagem("Cliente com id " + cliente.getId() + " criado." )
                .build();
    }


    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    private Cliente findByCPF(ClienteCreateDTO objDTO) {
        Cliente obj = repository.findByCPF(objDTO.getCpf());
        if (obj != null) {
            return obj;
        }
        return null;
    }
    public Cliente verificaSeExiste(Long id) throws ObjectNotFoundException {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id));
        return cliente;
    }
}

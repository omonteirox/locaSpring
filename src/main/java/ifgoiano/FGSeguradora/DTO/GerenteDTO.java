package ifgoiano.FGSeguradora.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import ifgoiano.FGSeguradora.models.Gerente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GerenteDTO implements Serializable {
    private static final long serialVersionUID = 1l;
    private Long id;
    @NotEmpty(message = "Campo NOME é requerido.")
    @Length(min = 3, max = 100, message = "O campo nome deve possuir entre 3 á 100 caracteres.")
    private String nome;
    @CPF
    @NotEmpty(message = "Campo CPF é requerido.")
    private String cpf;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "A data é obrigatória!")
    private LocalDate dataNascimento;
    @NotEmpty(message = "Campo LOGIN é requerido.")
    @Length(min = 3, max = 100, message = "O campo login deve possuir entre 3 á 50 caracteres.")
    private String login;
    @NotEmpty(message = "Campo SENHA é requerido.")
    @Length(min = 3, max = 100, message = "O campo SENHA deve possuir entre 3 á 50 caracteres.")
    private String senha;
    @NotEmpty(message = "Campo GENERO é requerido.")
    @Length(min = 3, max = 100, message = "O campo GENERO deve possuir entre 3 á 10 caracteres.")
    private String genero;
    @NotEmpty(message = "Campo ENDERECO é requerido.")
    @Length(min = 3, max = 100, message = "O campo ENDERECO deve possuir entre 3 á 10 caracteres.")
    private String endereco;

    private String seguros;


    public GerenteDTO(Gerente gerente) {
        this.id = gerente.getId();
        this.nome = gerente.getNome();
        this.cpf = gerente.getCpf();
        this.dataNascimento = gerente.getDataNascimento();
        this.login = gerente.getLogin();
        this.senha = gerente.getSenha();
        this.genero = gerente.getGenero();
        this.endereco = gerente.getEndereco();
        this.seguros = gerente.getSeguros();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSeguros() {
        return seguros;
    }

    public void setSeguros(String seguros) {
        this.seguros = seguros;
    }
}

package ifgoiano.FGSeguradora.repository;

import ifgoiano.FGSeguradora.models.Terceirizado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TerceirizadoRepository  extends JpaRepository<Terceirizado,Long> {

    @Query("SELECT obj FROM Terceirizado obj WHERE obj.cnpj=:cnpj")
    Terceirizado findByCNPJ(@Param("cnpj") String cnpj);
}

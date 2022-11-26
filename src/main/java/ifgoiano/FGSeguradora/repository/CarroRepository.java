package ifgoiano.FGSeguradora.repository;

import ifgoiano.FGSeguradora.models.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    @Query("SELECT obj FROM Carro obj WHERE obj.chassi=:chassi")
    Carro findByChassi(@Param("chassi") String chassi);
    @Query("SELECT obj FROM Carro obj WHERE obj.placa=:placa")
    Carro findByPlaca(@Param("placa") String placa);
}

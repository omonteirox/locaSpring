package ifgoiano.FGSeguradora.repository;

import ifgoiano.FGSeguradora.models.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MotoRepository extends JpaRepository<Moto, Long> {

    @Query("SELECT obj FROM Moto obj WHERE obj.chassi=:chassi")
    Moto findByChassi(@Param("chassi") String chassi);
    @Query("SELECT obj FROM Moto obj WHERE obj.placa=:placa")
    Moto findByPlaca(@Param("placa") String placa);
}
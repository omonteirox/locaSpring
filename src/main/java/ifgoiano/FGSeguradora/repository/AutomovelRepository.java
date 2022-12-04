package ifgoiano.FGSeguradora.repository;

import ifgoiano.FGSeguradora.models.Automovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutomovelRepository extends JpaRepository<Automovel, Long> {
    @Query("SELECT obj FROM Automovel obj WHERE obj.chassi=:chassi")
    Automovel findByChassi(@Param("chassi") String chassi);

    @Query("SELECT obj FROM Automovel obj WHERE obj.tipoAutomovel= 2")
    List<Automovel> findAllMotos();

    @Query("SELECT obj FROM Automovel obj WHERE obj.tipoAutomovel= 0")
    List<Automovel> findAllCarros();

    @Query("SELECT obj FROM Automovel obj WHERE obj.tipoAutomovel= 1 ")
    List<Automovel> findAllCaminhonetes();
    @Query("SELECT obj FROM Automovel obj WHERE obj.placa=:placa")
    Automovel findByPlaca(@Param("placa") String placa);
}
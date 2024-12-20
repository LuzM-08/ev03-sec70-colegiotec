package cl.ipss.api.eva03.apieva03.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cl.ipss.api.eva03.apieva03.models.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    @Query("SELECT e FROM Empresa e JOIN FETCH e.jefe")
    List<Empresa> findAllWithJefe();

}

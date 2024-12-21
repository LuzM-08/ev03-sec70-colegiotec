package cl.ipss.api.eva03.apieva03.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.ipss.api.eva03.apieva03.models.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{

}

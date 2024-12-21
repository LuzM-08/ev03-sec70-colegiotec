package cl.ipss.api.eva03.apieva03.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.ipss.api.eva03.apieva03.models.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {

}

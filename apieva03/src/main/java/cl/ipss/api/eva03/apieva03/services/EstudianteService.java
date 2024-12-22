package cl.ipss.api.eva03.apieva03.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ipss.api.eva03.apieva03.models.Estudiante;
import cl.ipss.api.eva03.apieva03.repositories.EstudianteRepository;

@Service
public class EstudianteService {
    @Autowired
    public EstudianteRepository estudianteRepository;

    // crear
    public Estudiante crear(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    // listar 
    public List<Estudiante> ListarTodos(){
        return estudianteRepository.findAll();
    }

     // buscar
     public Estudiante buscar (long estId){
        return estudianteRepository.findById(estId).orElse(null);
    }

    // eliminar
    public void eliminar(long estId){
        estudianteRepository.deleteById(estId);
    }

}

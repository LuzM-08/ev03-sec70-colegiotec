package cl.ipss.api.eva03.apieva03.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ipss.api.eva03.apieva03.models.Jefe;
import cl.ipss.api.eva03.apieva03.repositories.JefeRepository;

@Service
public class JefeService {
@Autowired
    public JefeRepository jefeRepository;

    // crear
    public Jefe crear(Jefe practica) {
        return jefeRepository.save(practica);
    }

    // listar 
    public List<Jefe> ListarTodos(){
        return jefeRepository.findAll();
    }

    // buscar
    public Jefe buscar (long jefeId){
        return jefeRepository.findById(jefeId).orElse(null);
    }

    // eliminar
    public void eliminar(long jefeId){
        jefeRepository.deleteById(jefeId);
    }
}

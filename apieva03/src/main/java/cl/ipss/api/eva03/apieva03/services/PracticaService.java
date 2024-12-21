package cl.ipss.api.eva03.apieva03.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ipss.api.eva03.apieva03.models.Practica;
import cl.ipss.api.eva03.apieva03.repositories.PracticaRepository;

@Service
public class PracticaService {

    @Autowired
    public PracticaRepository practicaRepository;

    // crear
    public Practica crear(Practica practica) {
        return practicaRepository.save(practica);
    }

    // listar
    public List<Practica> ListarTodos() {
        return practicaRepository.findAll();
    }

    // buscar
    public Practica buscar(long id) {
        return practicaRepository.findById(id).orElse(null);
    }

    // eliminar
    public void eliminar(long id) {
        practicaRepository.deleteById(id);
    }

}

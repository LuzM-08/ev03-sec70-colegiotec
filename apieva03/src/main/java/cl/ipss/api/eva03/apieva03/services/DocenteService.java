package cl.ipss.api.eva03.apieva03.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ipss.api.eva03.apieva03.models.Docente;
import cl.ipss.api.eva03.apieva03.repositories.DocenteRepository;

@Service
public class DocenteService {

    @Autowired
    public DocenteRepository docenteRepository;

    // crear
    public Docente crear(Docente docente) {
        return docenteRepository.save(docente);
    }

    // listar
    public List<Docente> ListarTodos() {
        return docenteRepository.findAll();
    }

    // buscar
    public Docente buscar(long docId) {
        return docenteRepository.findById(docId).orElse(null);
    }

    // eliminar
    public void eliminar(long docId) {
        docenteRepository.deleteById(docId);
    }

}

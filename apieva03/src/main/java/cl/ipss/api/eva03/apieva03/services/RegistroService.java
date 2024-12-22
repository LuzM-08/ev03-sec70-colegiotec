package cl.ipss.api.eva03.apieva03.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ipss.api.eva03.apieva03.models.Registro;
import cl.ipss.api.eva03.apieva03.repositories.RegistroRepository;

@Service
public class RegistroService {
     @Autowired
    public RegistroRepository registroRepository;

    // crear
    public Registro crear(Registro registro) {
        return registroRepository.save(registro);
    }

    // listar 
    public List<Registro> ListarTodos(){
        return registroRepository.findAll();
    }

    // buscar
    public Registro buscar (long regId){
        return registroRepository.findById(regId).orElse(null);
    }

    // eliminar
    public void eliminar(long regId){
        registroRepository.deleteById(regId);
    }


}

package cl.ipss.api.eva03.apieva03.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ipss.api.eva03.apieva03.models.Empresa;
import cl.ipss.api.eva03.apieva03.repositories.EmpresaRepository;

@Service
public class EmpresaService {

        @Autowired
    public EmpresaRepository empresaRepository;

    // crear
    public Empresa crear(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    // listar 
    public List<Empresa> ListarTodos(){
        return empresaRepository.findAll();
    }

    // buscar
    public Empresa buscar (long empId){
        return empresaRepository.findById(empId).orElse(null);
    }

    // eliminar
    public void eliminar(long empId){
        empresaRepository.deleteById(empId);
    }

}

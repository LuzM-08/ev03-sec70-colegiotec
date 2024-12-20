package cl.ipss.api.eva03.apieva03.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.ipss.api.eva03.apieva03.models.Docente;
import cl.ipss.api.eva03.apieva03.models.Empresa;
import cl.ipss.api.eva03.apieva03.models.Estudiante;
import cl.ipss.api.eva03.apieva03.models.Jefe;
import cl.ipss.api.eva03.apieva03.models.Practica;
import cl.ipss.api.eva03.apieva03.models.Registro;
import cl.ipss.api.eva03.apieva03.responses.DocenteResponse;
import cl.ipss.api.eva03.apieva03.responses.DocentesResponse;
import cl.ipss.api.eva03.apieva03.responses.PracticaResponse;
import cl.ipss.api.eva03.apieva03.responses.PracticasResponse;
import cl.ipss.api.eva03.apieva03.responses.RegistroResponse;
import cl.ipss.api.eva03.apieva03.responses.RegistrosResponse;
import cl.ipss.api.eva03.apieva03.responses.EstudianteResponse;
import cl.ipss.api.eva03.apieva03.responses.EstudiantesResponse;
import cl.ipss.api.eva03.apieva03.responses.EmpresaResponse;
import cl.ipss.api.eva03.apieva03.responses.EmpresasResponse;
import cl.ipss.api.eva03.apieva03.responses.JefeResponse;
import cl.ipss.api.eva03.apieva03.responses.JefesResponse;
import cl.ipss.api.eva03.apieva03.services.DocenteService;
import cl.ipss.api.eva03.apieva03.services.EmpresaService;
import cl.ipss.api.eva03.apieva03.services.EstudianteService;
import cl.ipss.api.eva03.apieva03.services.JefeService;
import cl.ipss.api.eva03.apieva03.services.PracticaService;
import cl.ipss.api.eva03.apieva03.services.RegistroService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
@RequestMapping("api/docente")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;
    private PracticaService practicaService;
    private EstudianteService estudianteService;
    private RegistroService registroService;
    private EmpresaService empresaService;
    private JefeService jefeService;

    // Crear Práctica - Post
    @PostMapping(value = "practica/crear", produces = "application/json")
    public ResponseEntity<Object> createDocente(@RequestBody Practica practica) {

        if (practica.getDescripcion().equals("") || practica.getDescripcion() == null) {
            throw new RuntimeException("La descripción es requerida");
        }
        practicaService.crear(practica);

        // Estructura de Respuesta
        PracticaResponse practicaResponse = new PracticaResponse();
        practicaResponse.setStatus(200);
        practicaResponse.setMessage("Práctica creada correctamente");
        practicaResponse.setPractica(practica);

        return ResponseEntity.ok()
                .body(practicaResponse);

    }

    // Listar Prácticas - Get
    @GetMapping(value = "practica/listar", produces = "application/json")
    public ResponseEntity<Object> getPracticas() {
        PracticasResponse practicasResponse = new PracticasResponse();
        practicasResponse.setStatus(200);
        practicasResponse.setMessage("Prácticas listadas correctamente");
        practicasResponse.setPractica(practicaService.ListarTodos());

        return ResponseEntity.ok()
                .body(practicasResponse);
    }

    // Buscar Práctica por Id - Get
    @GetMapping(value = "practica/buscar/{id}", produces = "application/json")
    public ResponseEntity<Object> getPracticas(@PathVariable long id) {
        PracticaResponse practicaResponse = new PracticaResponse();
        practicaResponse.setStatus(200);
        practicaResponse.setMessage("Práctica encontrada");
        practicaResponse.setPractica(practicaService.buscar(id));

        return ResponseEntity.ok()
                .body(practicaResponse);
    }

    // Actualizar Práctica por Id - Put
    @PutMapping(value = "practica/actualizar/{id}", produces = "application/json")
    public ResponseEntity<Object> setPractica(@PathVariable long id, @RequestBody Practica practicaRequest) {
        PracticaResponse practicaResponse = new PracticaResponse();
        Practica practica = new Practica();
        practica = practicaService.buscar(id);
        practica.setId(practicaRequest.getId());
        practica.setDescripcion(practicaRequest.getDescripcion());
        practica.setFechaFin(practicaRequest.getFechaFin());
        practica.setFechaIni(practicaRequest.getFechaIni());
        practica.setDocente(practicaRequest.getDocente());
        practica.setEmpresa(practicaRequest.getEmpresa());
        practica.setEstudiante(practicaRequest.getEstudiante());
        practicaService.crear(practica);

        practicaResponse.setStatus(200);
        practicaResponse.setMessage("Práctica actualizada exitosamente");
        practicaResponse.setPractica(practica);
        return ResponseEntity.ok()
                .body(practicaResponse);
    }

    // Eliminar Práctica por Id - Delete
    @DeleteMapping(value = "practica/eliminar/{id}", produces = "application/json")
    public ResponseEntity<Object> deletePractica(@PathVariable long id) {
        PracticaResponse practicaResponse = new PracticaResponse();
        practicaService.eliminar(id);
        practicaResponse.setStatus(200);
        practicaResponse.setMessage("Práctica eliminada exitosamente");
        return ResponseEntity.ok()
                .body(practicaResponse);

    }

    // Crear Docente - Post
    @PostMapping(value = "docente/crear", produces = "application/json")
    public ResponseEntity<Object> createDocente(@RequestBody Docente docente) {

        if (docente.getNombreCompleto().equals("") || docente.getNombreCompleto() == null) {
            throw new RuntimeException("El nombre es requerido");
        }
        docenteService.crear(docente);

        // Estructura de Respuesta
        DocenteResponse docenteResponse = new DocenteResponse();
        docenteResponse.setStatus(200);
        docenteResponse.setMessage("Docente creado correctamente");
        docenteResponse.setDocente(docente);

        return ResponseEntity.ok()
                .body(docenteResponse);

    }

    // Listar Docente - Get
    @GetMapping(value = "docente/listar", produces = "application/json")
    public ResponseEntity<Object> getDocentes() {
        DocentesResponse docentesResponse = new DocentesResponse();
        docentesResponse.setStatus(200);
        docentesResponse.setMessage("Docentes listados correctamente");
        docentesResponse.setDocente(docenteService.ListarTodos());

        return ResponseEntity.ok()
                .body(docentesResponse);
    }

    // Buscar Docente por Id - Get
    @GetMapping(value = "docente/buscar/{id}", produces = "application/json")
    public ResponseEntity<Object> getDocente(@PathVariable long id) {
        DocenteResponse docenteResponse = new DocenteResponse();
        docenteResponse.setStatus(200);
        docenteResponse.setMessage("Docente encontrado");
        docenteResponse.setDocente(docenteService.buscar(id));

        return ResponseEntity.ok()
                .body(docenteResponse);
    }

    // Actualizar Docente por Id - Put
    @PutMapping(value = "docente/actualizar/{id}", produces = "application/json")
    public ResponseEntity<Object> setDocente(@PathVariable long id, @RequestBody Docente docenteRequest) {
        DocenteResponse docenteResponse = new DocenteResponse();
        Docente docente = new Docente();
        docente = docenteService.buscar(id);
        docente.setId(docenteRequest.getId());
        docente.setNombreCompleto(docenteRequest.getNombreCompleto());
        docente.setCarrera(docenteRequest.getCarrera());
        docente.setCorreo(docenteRequest.getCorreo());
        docenteService.crear(docente);

        docenteResponse.setStatus(200);
        docenteResponse.setMessage("Docente actualizado exitosamente");
        docenteResponse.setDocente(docente);
        return ResponseEntity.ok()
                .body(docenteResponse);
    }

    // Eliminar Docente por Id - Delete
    @DeleteMapping(value = "docente/eliminar/{id}", produces = "application/json")
    public ResponseEntity<Object> deleteDocente(@PathVariable long id) {
        DocenteResponse docenteResponse = new DocenteResponse();
        docenteService.eliminar(id);
        docenteResponse.setStatus(200);
        docenteResponse.setMessage("Docente eliminado exitosamente");
        return ResponseEntity.ok()
                .body(docenteResponse);

    }

    // Crear Estudiante - Post
    @PostMapping(value = "estudiante/crear", produces = "application/json")
    public ResponseEntity<Object> createEstudiante(@RequestBody Estudiante estudiante) {

        if (estudiante.getNombreCompleto().equals("") || estudiante.getNombreCompleto() == null) {
            throw new RuntimeException("El nombre completo es requerido");
        }
        estudianteService.crear(estudiante);

        // Estructura de Respuesta
        EstudianteResponse estudianteResponse = new EstudianteResponse();
        estudianteResponse.setStatus(200);
        estudianteResponse.setMessage("Estudiante creado(a) correctamente");
        estudianteResponse.setEstudiante(estudiante);

        return ResponseEntity.ok()
                .body(estudianteResponse);

    }

    // Listar Estudiantes - Get
    @GetMapping(value = "estudiante/listar", produces = "application/json")
    public ResponseEntity<Object> getEstudiante() {
        EstudiantesResponse estudiantesResponse = new EstudiantesResponse();
        estudiantesResponse.setStatus(200);
        estudiantesResponse.setMessage("Estudiantes listados(as) correctamente");
        estudiantesResponse.setEstudiante(estudianteService.ListarTodos());

        return ResponseEntity.ok()
                .body(estudiantesResponse);
    }

    // Buscar Estudiantes por Id - Get
    @GetMapping(value = "estudiante/buscar/{id}", produces = "application/json")
    public ResponseEntity<Object> getEstudiante(@PathVariable long id) {
        EstudianteResponse estudianteResponse = new EstudianteResponse();
        estudianteResponse.setStatus(200);
        estudianteResponse.setMessage("Estudiante encontrado(a)");
        estudianteResponse.setEstudiante(estudianteService.buscar(id));

        return ResponseEntity.ok()
                .body(estudianteResponse);
    }

    // Actualizar Estudiantes por Id - Put
    @PutMapping(value = "estudiante/actualizar/{id}", produces = "application/json")
    public ResponseEntity<Object> setEstudiante(@PathVariable long id, @RequestBody Estudiante estudianteRequest) {
        EstudianteResponse estudianteResponse = new EstudianteResponse();
        Estudiante estudiante = new Estudiante();
        estudiante = estudianteService.buscar(id);
        estudiante.setId(estudianteRequest.getId());
        estudiante.setCarrera(estudianteRequest.getCarrera());
        estudiante.setCorreo(estudianteRequest.getCorreo());
        estudiante.setNombreCompleto(estudianteRequest.getNombreCompleto());
        estudianteService.crear(estudiante);

        estudianteResponse.setStatus(200);
        estudianteResponse.setMessage("Estudiante actualizada exitosamente");
        estudianteResponse.setEstudiante(estudiante);
        return ResponseEntity.ok()
                .body(estudiante);
    }

    // Eliminar Estudiantes por Id - Delete
    @DeleteMapping(value = "estudiante/eliminar/{id}", produces = "application/json")
    public ResponseEntity<Object> deleteEstudiante(@PathVariable long id) {
        EstudianteResponse estudianteResponse = new EstudianteResponse();
        estudianteService.eliminar(id);
        estudianteResponse.setStatus(200);
        estudianteResponse.setMessage("Estudiante eliminado(a) exitosamente");
        return ResponseEntity.ok()
                .body(estudianteResponse);
    }

    // Crear Registro - Post
    @PostMapping(value = "registro/crear", produces = "application/json")
    public ResponseEntity<Object> createRegistro(@RequestBody Registro registro) {

        if (registro.getDescripcion().equals("") || registro.getDescripcion() == null) {
            throw new RuntimeException("La descripción es requerida");
        }
        registroService.crear(registro);

        // Estructura de Respuesta
        RegistroResponse registroResponse = new RegistroResponse();
        registroResponse.setStatus(200);
        registroResponse.setMessage("Registro creado correctamente");
        registroResponse.setRegistro(registro);

        return ResponseEntity.ok()
                .body(registroResponse);

    }

    // Listar Registros - Get
    @GetMapping(value = "registro/listar", produces = "application/json")
    public ResponseEntity<Object> getRegistros() {
        RegistrosResponse registrosResponse = new RegistrosResponse();
        registrosResponse.setStatus(200);
        registrosResponse.setMessage("Registros listados correctamente");
        registrosResponse.setRegistro(registroService.ListarTodos());

        return ResponseEntity.ok()
                .body(registrosResponse);
    }

    // Buscar Registros por Id - Get
    @GetMapping(value = "registro/buscar/{id}", produces = "application/json")
    public ResponseEntity<Object> getRegistros(@PathVariable long id) {
        RegistroResponse registroResponse = new RegistroResponse();
        registroResponse.setStatus(200);
        registroResponse.setMessage("Registro encontrado(a)");
        registroResponse.setRegistro(registroService.buscar(id));

        return ResponseEntity.ok()
                .body(registroResponse);
    }

    // Actualizar Registros por Id - Put
    @PutMapping(value = "registro/actualizar/{id}", produces = "application/json")
    public ResponseEntity<Object> setRegistros(@PathVariable long id, @RequestBody Registro registroRequest) {
        RegistroResponse registroResponse = new RegistroResponse();
        Registro registro = new Registro();
        registro = registroService.buscar(id);
        registro.setId(registroRequest.getId());
        registro.setDescripcion(registroRequest.getDescripcion());
        registro.setTitulo(registroRequest.getTitulo());
        registro.setPractica(registroRequest.getPractica());
        registroService.crear(registro);

        registroResponse.setStatus(200);
        registroResponse.setMessage("Registro actualizado exitosamente");
        registroResponse.setRegistro(registro);
        return ResponseEntity.ok()
                .body(registro);
    }

    // Eliminar Registro por Id - Delete
    @DeleteMapping(value = "registro/eliminar/{id}", produces = "application/json")
    public ResponseEntity<Object> deleteRegistro(@PathVariable long id) {
        RegistroResponse registroResponse = new RegistroResponse();
        registroService.eliminar(id);
        registroResponse.setStatus(200);
        registroResponse.setMessage("Registro eliminado exitosamente");
        return ResponseEntity.ok()
                .body(registroResponse);
    }

    // Crear Empresa - Post
    @PostMapping(value = "empresa/crear", produces = "application/json")
    public ResponseEntity<Object> createEmpresa(@RequestBody Empresa empresa) {

        if (empresa.getDireccion().equals("") || empresa.getDireccion() == null) {
            throw new RuntimeException("La dirección es requerida");
        }
        empresaService.crear(empresa);

        // Estructura de Respuesta
        EmpresaResponse empresaResponse = new EmpresaResponse();
        empresaResponse.setStatus(200);
        empresaResponse.setMessage("Empresa creada correctamente");
        empresaResponse.setEmpresa(empresa);

        return ResponseEntity.ok()
                .body(empresaResponse);

    }

    // Listar Empresa - Get
    @GetMapping(value = "empresa/listar", produces = "application/json")
    public ResponseEntity<Object> getEmpresa() {
        EmpresasResponse empresasResponse = new EmpresasResponse();
        empresasResponse.setStatus(200);
        empresasResponse.setMessage("Empresas listadas correctamente");
        empresasResponse.setEmpresa(empresaService.ListarTodos());

        return ResponseEntity.ok()
                .body(empresasResponse);
    }

    // Buscar Empresa por Id - Get
    @GetMapping(value = "empresa/buscar/{id}", produces = "application/json")
    public ResponseEntity<Object> getEmpresa(@PathVariable long id) {
        EmpresaResponse empresaResponse = new EmpresaResponse();
        empresaResponse.setStatus(200);
        empresaResponse.setMessage("Registro encontrado(a)");
        empresaResponse.setEmpresa(empresaService.buscar(id));

        return ResponseEntity.ok()
                .body(empresaResponse);
    }

    // Actualizar Empresa por Id - Put
    @PutMapping(value = "empresa/actualizar/{id}", produces = "application/json")
    public ResponseEntity<Object> setEmpresa(@PathVariable long id, @RequestBody Empresa empresaRequest) {
        EmpresaResponse empresaResponse = new EmpresaResponse();
        Empresa empresa = new Empresa();
        empresa = empresaService.buscar(id);
        empresa.setId(empresaRequest.getId());
        empresa.setDireccion(empresaRequest.getDireccion());
        empresa.setNombre(empresaRequest.getNombre());
        empresa.setNumber(empresaRequest.getNumber());
        empresa.setRubro(empresaRequest.getRubro());
        empresa.setJefe(empresaRequest.getJefe());
        empresaService.crear(empresa);

        empresaResponse.setStatus(200);
        empresaResponse.setMessage("Empresa actualizada exitosamente");
        empresaResponse.setEmpresa(empresa);
        return ResponseEntity.ok()
                .body(empresa);
    }

    // Eliminar Empresa por Id - Delete
    @DeleteMapping(value = "empresa/eliminar/{id}", produces = "application/json")
    public ResponseEntity<Object> deleteEmpresa(@PathVariable long id) {
        EmpresaResponse empresaResponse = new EmpresaResponse();
        empresaService.eliminar(id);
        empresaResponse.setStatus(200);
        empresaResponse.setMessage("Empresa eliminada exitosamente");
        return ResponseEntity.ok()
                .body(empresaResponse);
    }

    // Crear Jefe - Post
    @PostMapping(value = "jefe/crear", produces = "application/json")
    public ResponseEntity<Object> createJefe(@RequestBody Jefe jefe) {

        if (jefe.getNombreCompleto().equals("") || jefe.getNombreCompleto() == null) {
            throw new RuntimeException("El nombre completo es requerido");
        }
        jefeService.crear(jefe);

        // Estructura de Respuesta
        JefeResponse jefeResponse = new JefeResponse();
        jefeResponse.setStatus(200);
        jefeResponse.setMessage("Jefe creado correctamente");
        jefeResponse.setJefe(jefe);

        return ResponseEntity.ok()
                .body(jefeResponse);

    }

    // Listar Registros - Get
    @GetMapping(value = "jefe/listar", produces = "application/json")
    public ResponseEntity<Object> getJefe() {
        JefesResponse jefesResponse = new JefesResponse();
        jefesResponse.setStatus(200);
        jefesResponse.setMessage("Jefes listados correctamente");
        jefesResponse.setJefe(jefeService.ListarTodos());

        return ResponseEntity.ok()
                .body(jefesResponse);
    }

    // Buscar Registros por Id - Get
    @GetMapping(value = "jefe/buscar/{id}", produces = "application/json")
    public ResponseEntity<Object> getJefe(@PathVariable long id) {
        JefeResponse jefeResponse = new JefeResponse();
        jefeResponse.setStatus(200);
        jefeResponse.setMessage("Jefe encontrado");
        jefeResponse.setJefe(jefeService.buscar(id));

        return ResponseEntity.ok()
                .body(jefeResponse);
    }

    // Actualizar Práctica por Id - Put
    @PutMapping(value = "jefe/actualizar/{id}", produces = "application/json")
    public ResponseEntity<Object> setEmpresa(@PathVariable long id, @RequestBody Jefe jefeRequest) {
        JefeResponse jefeResponse = new JefeResponse();
        Jefe jefe = new Jefe();
        jefe = jefeService.buscar(id);
        jefe.setId(jefeRequest.getId());
        jefe.setNombreCompleto(jefeRequest.getNombreCompleto());
        jefeService.crear(jefe);

        jefeResponse.setStatus(200);
        jefeResponse.setMessage("Empresa actualizada exitosamente");
        jefeResponse.setJefe(jefe);
        return ResponseEntity.ok()
                .body(jefe);
    }

    // Eliminar Registro por Id - Delete
    @DeleteMapping(value = "jefe/eliminar/{id}", produces = "application/json")
    public ResponseEntity<Object> deleteJefe(@PathVariable long id) {
        JefeResponse jefeResponse = new JefeResponse();
        jefeService.eliminar(id);
        jefeResponse.setStatus(200);
        jefeResponse.setMessage("Jefe eliminado exitosamente");
        return ResponseEntity.ok()
                .body(jefeResponse);

    }
}

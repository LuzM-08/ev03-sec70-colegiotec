package cl.ipss.api.eva03.apieva03.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.ipss.api.eva03.apieva03.models.Practica;
import cl.ipss.api.eva03.apieva03.models.Registro;
import cl.ipss.api.eva03.apieva03.responses.PracticaResponse;
import cl.ipss.api.eva03.apieva03.responses.PracticasResponse;
import cl.ipss.api.eva03.apieva03.responses.RegistroResponse;
import cl.ipss.api.eva03.apieva03.responses.RegistrosResponse;
import cl.ipss.api.eva03.apieva03.services.PracticaService;
import cl.ipss.api.eva03.apieva03.services.RegistroService;

@Controller
@RequestMapping("api/estudiante")
public class EstudianteController {
    @Autowired
    private PracticaService practicaService;
    @Autowired
    private RegistroService registroService;

    // Crear Práctica - Post
    @PostMapping(value = "practica/crear", produces = "application/json")
    public ResponseEntity<Object> createPractica(@RequestBody Practica practica) {

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

    // Listar Practicas - Get
    @GetMapping(value = "practica/listar", produces = "application/json")
    public ResponseEntity<Object> getPracticas() {
        PracticasResponse practicasResponse = new PracticasResponse();
        practicasResponse.setStatus(200);
        practicasResponse.setMessage("Prácticas listadas correctamente");
        practicasResponse.setPractica(practicaService.ListarTodos());

        return ResponseEntity.ok()
                .body(practicasResponse);
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

}

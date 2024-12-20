package cl.ipss.api.eva03.apieva03.responses;

import java.util.List;

import cl.ipss.api.eva03.apieva03.models.Estudiante;
import lombok.Data;

@Data
public class EstudiantesResponse {
    private int status;
    private String message;
    private List<Estudiante> estudiante;

}

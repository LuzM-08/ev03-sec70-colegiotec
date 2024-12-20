package cl.ipss.api.eva03.apieva03.responses;

import cl.ipss.api.eva03.apieva03.models.Estudiante;
import lombok.Data;

@Data
public class EstudianteResponse {
    private int status;
    private String message;
    private Estudiante estudiante;

}

package cl.ipss.api.eva03.apieva03.responses;

import cl.ipss.api.eva03.apieva03.models.Docente;
import lombok.Data;

@Data
public class DocenteResponse {

    private int status;
    private String message;
    private Docente docente;

}



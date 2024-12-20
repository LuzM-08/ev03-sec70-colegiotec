package cl.ipss.api.eva03.apieva03.responses;

import java.util.List;

import cl.ipss.api.eva03.apieva03.models.Docente;
import lombok.Data;

@Data
public class DocentesResponse {

    private int status;
    private String message;
    private List<Docente> docente;

}

package cl.ipss.api.eva03.apieva03.responses;

import java.util.List;

import cl.ipss.api.eva03.apieva03.models.Practica;
import lombok.Data;

@Data
public class PracticasResponse {
    private int status;
    private String message;
    private List<Practica> practica;

}

package cl.ipss.api.eva03.apieva03.responses;
import cl.ipss.api.eva03.apieva03.models.Practica;
import lombok.Data;

@Data
public class PracticaResponse {
    private int status;
    private String message;
    private Practica practica;
}

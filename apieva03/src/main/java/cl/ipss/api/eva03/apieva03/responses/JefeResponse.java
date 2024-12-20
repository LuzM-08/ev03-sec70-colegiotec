package cl.ipss.api.eva03.apieva03.responses;
import cl.ipss.api.eva03.apieva03.models.Jefe;
import lombok.Data;

@Data
public class JefeResponse {
    private int status;
    private String message;
    private Jefe jefe;
}

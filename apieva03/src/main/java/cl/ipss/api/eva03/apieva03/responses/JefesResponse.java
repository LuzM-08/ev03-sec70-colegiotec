package cl.ipss.api.eva03.apieva03.responses;
import java.util.List;

import cl.ipss.api.eva03.apieva03.models.Jefe;
import lombok.Data;

@Data
public class JefesResponse {
    private int status;
    private String message;
    private List<Jefe> jefe;
}
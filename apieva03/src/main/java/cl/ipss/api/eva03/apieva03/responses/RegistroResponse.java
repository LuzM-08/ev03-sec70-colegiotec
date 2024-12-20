package cl.ipss.api.eva03.apieva03.responses;

import cl.ipss.api.eva03.apieva03.models.Registro;
import lombok.Data;

@Data
public class RegistroResponse {
    private int status;
    private String message;
    private Registro registro;

}

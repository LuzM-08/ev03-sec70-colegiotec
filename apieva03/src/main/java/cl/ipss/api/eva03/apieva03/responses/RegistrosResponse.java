package cl.ipss.api.eva03.apieva03.responses;

import java.util.List;

import cl.ipss.api.eva03.apieva03.models.Registro;
import lombok.Data;

@Data
public class RegistrosResponse {
    private int status;
    private String message;
    private List<Registro> registro;
}

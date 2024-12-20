package cl.ipss.api.eva03.apieva03.responses;

import cl.ipss.api.eva03.apieva03.models.Empresa;
import lombok.Data;

@Data
public class EmpresaResponse {
private int status;
    private String message;
    private Empresa empresa;
}

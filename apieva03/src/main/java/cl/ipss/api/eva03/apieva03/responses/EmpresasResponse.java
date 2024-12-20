package cl.ipss.api.eva03.apieva03.responses;

import java.util.List;

import cl.ipss.api.eva03.apieva03.models.Empresa;
import lombok.Data;

@Data
public class EmpresasResponse {
private int status;
    private String message;
    private List<Empresa> empresa;
}

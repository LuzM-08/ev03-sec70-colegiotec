package cl.ipss.api.eva03.apieva03.models;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long est_id;
    private String nombreCompleto;
    private String correo;
    private String carrera;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estudiante", cascade = { CascadeType.ALL })
    private List<Practica> practica;

}

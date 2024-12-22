package cl.ipss.api.eva03.apieva03.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empId;
    private String nombre;
    private String rubro;
    private String direccion;
    private long telefono;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "jefeId")
    private Jefe jefe;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "empresa", cascade = { CascadeType.ALL })
    private List<Practica> practica;

}

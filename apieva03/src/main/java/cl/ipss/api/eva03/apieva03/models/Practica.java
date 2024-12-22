package cl.ipss.api.eva03.apieva03.models;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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
@EntityListeners(AuditingEntityListener.class)
public class Practica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long practId;
    private LocalDate fechaIni;
    private LocalDate fechaFin;
    private String descripcion;
    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "estId")
    private Estudiante estudiante;
    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "docId")
    private Docente docente;
    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "empId")
    private Empresa empresa;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "practica", cascade = { CascadeType.ALL})
    private List<Registro> registro;

    @CreatedDate
    private LocalDate fecha_crea;
    @LastModifiedDate
    private LocalDate fecha_modi;

}

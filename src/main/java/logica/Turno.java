
package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Turno implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_turno;
    
    @Temporal(TemporalType.DATE)
    private Date facha_turno;
    
    private String hora_turno;
    private String afeccion;
    
    @ManyToOne
    @JoinColumn(name="ID_ODONTO")
    private Odontologo odonto;
    
    @ManyToOne
    @JoinColumn(name="ID_PACIEN")
    private Paciente pacien;
    

    public Turno() {
    }

    public Turno(int id_turno, Date facha_turno, String hora_turno, String afeccion) {
        this.id_turno = id_turno;
        this.facha_turno = facha_turno;
        this.hora_turno = hora_turno;
        this.afeccion = afeccion;
    }

    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }

    public Date getFacha_turno() {
        return facha_turno;
    }

    public void setFacha_turno(Date facha_turno) {
        this.facha_turno = facha_turno;
    }

    public String getHora_turno() {
        return hora_turno;
    }

    public void setHora_turno(String hora_turno) {
        this.hora_turno = hora_turno;
    }

    public String getAfeccion() {
        return afeccion;
    }

    public void setAfeccion(String afeccion) {
        this.afeccion = afeccion;
    }
    
    
}

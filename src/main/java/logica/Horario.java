 
package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Horario implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_horario;
    private String inicio_horario;
    private String fin_horario;
    
    public Horario() {
    }

    public Horario(int id_horario, String inicio_horario, String fin_horario) {
        this.id_horario = id_horario;
        this.inicio_horario = inicio_horario;
        this.fin_horario = fin_horario;
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public String getInicio_horario() {
        return inicio_horario;
    }

    public void setInicio_horario(String inicio_horario) {
        this.inicio_horario = inicio_horario;
    }

    public String getFin_horario() {
        return fin_horario;
    }

    public void setFin_horario(String fin_horario) {
        this.fin_horario = fin_horario;
    }
    
    
}

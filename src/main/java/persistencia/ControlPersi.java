
package persistencia;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;


public class ControlPersi {
    HorarioJpaController horarioJpa = new HorarioJpaController();
    OdontologoJpaController OdontologoJpa = new OdontologoJpaController();
    PacienteJpaController pacienteJpa = new PacienteJpaController();
    PersonaJpaController personaJpa = new PersonaJpaController();
    ResponsableJpaController responsableJpa = new ResponsableJpaController();
    SecratarioJpaController secretarioJpa = new SecratarioJpaController();
    TurnoJpaController turnoJpa = new TurnoJpaController();
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();

    public void crearUsuario(Usuario usu) {
        usuarioJpa.create(usu);
    
    }

    public List<Usuario> getUsuarios() {
        
       return usuarioJpa.findUsuarioEntities();
    
    
    }

    public void borrarUsuario(int id) {
 
        try {
            usuarioJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControlPersi.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }

    public Usuario traerUsuarios(int id) {
 
        return usuarioJpa.findUsuario(id);
    
    }

    public void editarUsuario(Usuario usu) {
 
        try {
            usuarioJpa.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControlPersi.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}

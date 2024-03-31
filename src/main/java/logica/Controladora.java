package logica;

import java.util.ArrayList;
import java.util.List;
import persistencia.ControlPersi;

public class Controladora {

    ControlPersi conPersi = new ControlPersi();

    public void crearUsuario(String nombreUsuario, String contrasenia, String rol) {

        Usuario usu = new Usuario();
        usu.setNombreUsuario(nombreUsuario);
        usu.setContrasenia(contrasenia);
        usu.setRol(rol);

        conPersi.crearUsuario(usu);

    }

    public List<Usuario> getUsuarios() {

        return conPersi.getUsuarios();

    }

    public void borrarUsuario(int id) {

        conPersi.borrarUsuario(id);

    }

    public Usuario traerUsuarios(int id) {

        return conPersi.traerUsuarios(id);

    }

    public void editarUsuario(Usuario usu) {

        conPersi.editarUsuario(usu);

    }

    public boolean comprobarIngreso(String usuario, String contrasenia) {

        boolean ingreso = false;

        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios = conPersi.getUsuarios();

        for (Usuario usu : listaUsuarios) {
            if (usu.getNombreUsuario().equals(usuario)) {
                if (usu.getContrasenia().equals(contrasenia)) {
                    ingreso = true;
                } else {
                    ingreso = false;
                }
            }
        }

        return ingreso;
    }

}

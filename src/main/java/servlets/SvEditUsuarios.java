
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Usuario;

@WebServlet(name = "SvEditUsuarios", urlPatterns = {"/SvEditUsuarios"})
public class SvEditUsuarios extends HttpServlet {
    Controladora conLogica = new Controladora();
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         int id = Integer.parseInt(request.getParameter("id"));
         Usuario usu = conLogica.traerUsuarios(id);
         
         HttpSession misession = request.getSession();
         misession.setAttribute("usuEditar", usu);
         
         System.out.println("el nombre es:"+ usu.getNombreUsuario());
         
         response.sendRedirect("editarUsuario.jsp");
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       String nombreUsuario = request.getParameter("nombreUsu");
       String contrasenia = request.getParameter("contrasenia");
       String rol = request.getParameter("rol");
        
      Usuario usu = (Usuario)request.getSession().getAttribute("usuEditar");
      usu.setNombreUsuario(nombreUsuario);
      usu.setContrasenia(contrasenia);
      usu.setRol(rol);
      
      conLogica.editarUsuario(usu);
      
      response.sendRedirect("SvUsuarios");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

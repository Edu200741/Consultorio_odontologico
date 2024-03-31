<%-- 
    Document   : altasUsuario
    Created on : 29 mar 2024, 19:59:38
    Author     : pc
--%>

<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="components/head.jsp"%>
<%@ include file="components/bodyPrimeraParte.jsp"%>

<h1>Edicion de Usuarios</h1>
<p>Este es el apartado para dar modificar a un usuario del sistema.</p>

<% Usuario usu =(Usuario) request.getSession().getAttribute("usuEditar");%>

<form class="user" action="SvEditUsuarios" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombreUsu" name="nombreUsu"
                   placeholder="Nombre Usuario" value="<%= usu.getNombreUsuario() %>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="password" class="form-control form-control-user" id="contrasenia" name="contrasenia"
                   placeholder="Contrasenia" value="<%=usu.getContrasenia() %>">
        </div>
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user" id="rol" name="rol"
                   placeholder="Rol" value="<%=usu.getRol() %>">
        </div>
        
        
        <!-- aca va todo relacionado con horarios y usuarios-->
        
        
    </div>
    
  
     
    <button  class="btn btn-primary btn-user btn-block" type="submit">
        Guardar Modificacion
    </button>
   
</form>

<%@ include file="components/bodyFinal.jsp"%>


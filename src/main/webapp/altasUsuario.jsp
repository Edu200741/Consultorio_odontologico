<%-- 
    Document   : altasUsuario
    Created on : 29 mar 2024, 19:59:38
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="components/head.jsp"%>
<%@ include file="components/bodyPrimeraParte.jsp"%>

<h1>Altas Usuarios</h1>
<p>Este es el apartado para dar de altas a los diferentes usuarios del sistema.</p>



<form class="user" action="SvUsuarios" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombreUsu" name="nombreUsu"
                   placeholder="Nombre Usuario">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="password" class="form-control form-control-user" id="contrasenia" name="contrasenia"
                   placeholder="Contrasenia">
        </div>
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user" id="rol" name="rol"
                   placeholder="Rol">
        </div>
        
        
        <!-- aca va todo relacionado con horarios y usuarios-->
        
        
    </div>
    
  
     
    <button  class="btn btn-primary btn-user btn-block" type="submit">
        Crear Usuario
    </button>
   
</form>

<%@ include file="components/bodyFinal.jsp"%>


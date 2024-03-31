<%-- 
    Document   : altas
    Created on : 26 mar 2024, 12:56:32
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="components/head.jsp"%>
<%@ include file="components/bodyPrimeraParte.jsp"%>

<h1>Altas Odontólogo</h1>
<p>esto es una prueba</p>



<form class="user">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="dni"
                   placeholder="DNI">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombre"
                   placeholder="Nombre">
        </div>
        <div class="col-sm-6 mb-3 ">
            <input type="text" class="form-control form-control-user" id="apellido"
                   placeholder="Apellido">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="telefono"
                   placeholder="Telefono">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="direccion"
                   placeholder="Direccion">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="fechaNac"
                   placeholder="Fecha Nac">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="especialidad"
                   placeholder="Especialidad">
        </div>
        
        <!-- aca va todo relacionado con horarios y usuarios-->
        
        
    </div>
    
  
     
    <a href="#" class="btn btn-primary btn-user btn-block">
        Crear Odontólogo
    </a>
   
</form>

<%@ include file="components/bodyFinal.jsp"%>

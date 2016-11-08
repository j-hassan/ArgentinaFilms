<jsp:include page="MasterPageCabecera.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    
<div class="contenido">

<c:if test="${userLogueado.rango != 'admin'}" >
	<div class="container left-addon inner-addon">
		<img src="imgs/SinPermisos.png" class="text-center img-responsive" width="10px%" style="margin:auto;">
		<br>
        <h1 class="text-center">Usted no tiene permisos para estar ac�.<br><br></h1>  
    </div>
</c:if>  
    
    
    
<c:if test="${userLogueado.rango == 'admin'}">

    <div class="login">
		<h1 class="text-center titulo-seccion"><img src="imgs/CambiarRango.png" class="imagen-seccion" />CAMBIAR RANGO A USUARIO</h1>
	</div>
        
        <div class="${tipoMensaje}"><b>${mensajeResultado}</b></div>
        
        <form role="form" class="login form-horizontal" action="CambiarRangoUsuario" method="POST"> 
        
            <div class="form-group"> 
                <label class="control-label col-sm-2">Nombre de usuario:</label>                 
                <div class="col-sm-10">
                    <div>
                        <div>
                            <div>
                                <input type="text" class="form-control" name="txtNombreUsuario" placeholder="Ingrese el nombre de usuario" maxlength=15 required>
                            </div>
                        </div>
                    </div>
                </div>                 
            </div>             
            <div class="form-group"> 
                <label class="control-label col-sm-2">Rango:</label>                 
                <div class="col-sm-10">
                    <div>
                        <div>
                            <div>
                                <select id="ddlRango" name="ddlRango" class="input-sm">
		               				<option value="novato">Novato</option>
		                			<option value="moderador">Moderador</option>
		                			<option value="admin">Administrador</option>
		            			</select>
                            </div>
                        </div>
                    </div>
                </div>                 
            </div>             
 
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div>
                        <div>
                            <div>
                                <button type="submit" class="btn btn-success" id="btnCambiarRango">Cambiar rango</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>             
        </form>
        
 </c:if>       
        
</div>
    



<jsp:include page="MasterPageFooter.jsp" />
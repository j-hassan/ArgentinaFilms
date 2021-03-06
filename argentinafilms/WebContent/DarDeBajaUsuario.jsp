<jsp:include page="MasterPageCabecera.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<c:import url="/ListarUsuarios" /> <!-- llamo servlet al cargar pagina -->
    
<div class="contenido">

<c:if test="${userLogueado.rango != 'admin' && userLogueado.rango != 'moderador'}" >
	<div class="container left-addon inner-addon">
		<img src="imgs/SinPermisos.png" class="text-center img-responsive" width="10px%" style="margin:auto;">
		<br>
        <h1 class="text-center">Usted no tiene permisos para estar ac�.<br><br></h1>  
    </div>
</c:if>  
    
    
    
<c:if test="${userLogueado.rango == 'admin' || userLogueado.rango == 'moderador'}">

 	
	<div class="login">
		<h1 class="text-center titulo-seccion"><img src="imgs/Banear.png" class="imagen-seccion" style="margin-top: -50px!important;"/>DAR DE BAJA USUARIO</h1>
	</div>

	<div class="${tipoMensaje}"><b>${mensajeResultado}</b></div>

		<input type="text" id="inputBuscarUsuarioDarDeBaja" class="form-control"
						placeholder="Buscar usuario..." style="font-size: 18px; width:500px; margin: auto;">
<br>
<br>
		<table class="table" style="font-color: yellow!important; font-size: 14px!important; width: 900px!important; margin: auto;"> 
		    <thead> 
		        <tr> 
		            <th>Nombre de usuario</th> 
		            <th>Nombre y Apellido</th> 
		            <th>E-mail</th> 
		            <th>Rango</th>
		            <th>Acci�n</th>
		        </tr>         
		    </thead>     
		
		    <tbody>
		    
		   		 <c:if test="${usuarios.size() == 0 || usuarios == null}">
					<tr><td colspan="5" align="center">No existen usuarios activos.</td></tr>
				</c:if>
		    
				<c:forEach items="${usuarios}" var="usuario">
				<c:if test="${userLogueado.usuario != usuario.usuario}">
				<form action="DarDeBajaUsuario" method="GET" id="filaUsuario">
				
				
				
				<input name="userSeleccionado" value="${usuario.usuario}" type="hidden"></input>
				<input name="pagActual" value="${paginaActual}" type="hidden"></input>
				
						<tr>
						<td><a href="VerPerfilUsuario.jsp/?id="${usuario.usuario}></a>${usuario.usuario}</td>
						<td>${usuario.nombre} ${usuario.apellido}</td>
						<td>${usuario.email}</td>
						<td>${usuario.rango}</td>

						                    	
                    	<td><button type="submit" class="btn btn-danger btn-sm" style="margin: auto!important" onclick="return confirm('�Est� completamente seguro?')">Dar de baja</button></td>
						</tr>
					
				</form>
				</c:if>
				</c:forEach>
			</tbody>
		</table>


	<div class="paginado" align="center">


		<ul class="pagination lead" data-pg-collapsed> 
		<c:if test="${paginaActual != 1}">
		    <li>
		        <a href="DarDeBajaUsuario.jsp?pagina=1">&laquo;</a>
		    </li>    
		 </c:if>   
		     
		     
		 <c:forEach begin="1" end="${cantPaginas}" var="i">    


		    <li <c:if test="${paginaActual == i}">class="active"</c:if>>
		        <a href="DarDeBajaUsuario.jsp?pagina=${i}">${i}</a>
		    </li>     

		   </c:forEach> 
		    
		    <c:if test="${paginaActual lt cantPaginas}">
		    <li>
		        <a href="DarDeBajaUsuario.jsp?pagina=${cantPaginas}">&raquo;</a>
		    </li>     
		    </c:if>
		</ul>


	</div>
   
   
   <hr>     
        
        <div align=center style="width: 100%; margin:auto;">
        	<a href="Administrar.jsp" class="btn btn-primary">Volver</a>
        </div> 
        
 </c:if>       
        
</div>
    



<jsp:include page="MasterPageFooter.jsp" />
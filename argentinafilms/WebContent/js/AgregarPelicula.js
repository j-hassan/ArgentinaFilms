﻿function cargarActores() {
	 $.get('ServletCompletarActores',  function(responseText) {
     	var jsonObj =jQuery.parseJSON(responseText);
     	$('#completarActores').append( '<option value="">'+" Elija una opción" + '</option>');
             for (i = 0; i < jsonObj.length; i++)
             { 
                  
                 		 $('#completarActores').append( '<option value="'+jsonObj[i].id_actor+'">'+jsonObj[i].apellido +" - "+jsonObj[i].nombre + '</option>');
             }
 
});
}

function cargarGeneros() {
	
	 $.get('ServletCargarGenero',  function(responseText) {
	     	var jsonObj =jQuery.parseJSON(responseText);
	     	$('#completarGeneros').append( '<option value="">'+" Elija una opción" + '</option>');
	             for (i = 0; i < jsonObj.length; i++)
	             { 
	                  
	                 		 $('#completarGeneros').append( '<option value="'+jsonObj[i].genero_id+'">'+jsonObj[i].genero+'</option>');
	             }
	 
	});
}

function cargarDirectores() {
	
	 $.get('ServletCargarDirector',  function(responseText) {
	     	var jsonObj =jQuery.parseJSON(responseText);
	     	$('#completarDirectores').append( '<option value="">'+" Elija una opción" + '</option>');
	             for (i = 0; i < jsonObj.length; i++)
	             { 
	                  
	                 		 $('#completarDirectores').append( '<option value="'+jsonObj[i].id_director+'">'+jsonObj[i].apellido +" - "+jsonObj[i].nombre+ '</option>');
	             }
	 
	});
}

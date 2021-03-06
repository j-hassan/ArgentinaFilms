﻿function ActivarCuenta(){


	$('#btnConfirmarCodigo').attr("disabled", true);


        $.post('ActivarCuenta', {

            txtCodActivacion: $('#txtCodActivacion').val(),
            usuarioConfirmacion: $('#usuarioConfirmacion').val()

        }, function (data) {

            if (data == "codInvalido"){

                swal({
                    title: "Código erróneo",
                    text: "El código ingresado es incorrecto. Reintentá por favor",
                    type: "error"
                });
                
                $('#btnConfirmarCodigo').attr("disabled", false);
            }

            if(data== "codValido")

                swal({
                    title: "Registro exitoso",
                    text: "Tu cuenta ha sido activada con éxito. Ya podés agregar películas, public reseñas, comentar y mucho más!",
                    type: "success"
                }, function () {
                      window.location.href = 'Inicio.jsp';
                  });



        })
}
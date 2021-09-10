/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$("tr #btn1").click(function(e){
    e.prevenDefault();
    var cod= $(this).parent().find('#codigo').val();
    swal({
        title: "Esta Seguro de Eliminar?",
        text: "Una vez eliminado deberá agregar de nuevo!",
        type: "warning",
        showCancelButton: true,
        confirmButtonClass: "btn-danger",
        confirmButtonText: "Sí, Eliminar!",
        cancelButtonText: "No, Cancelar!",
        closeOnConfirm: false,
        closeOnCancel: false
    },
            function (isConfirm) {
                if (isConfirm) {
                    eliminarPregunta(cod);
                    swal("Eliminado!", "La pregunta se ha eiminado", "success");
                } else {
                    swal("Cancelado", "Cancelaste la eliminación", "error");
                }
            });

function eliminarPregunta(cod) {
    var url = "Preguntas" + cod;
    console.log("eliminado");
    $.ajax({
    type:'POST',
            name:opcion,
            value:2,
            url: url,
            async:true,
            success:function (r) {
            }
    })
    }
});   

$("#btn2").click(function(){
   Swal.fire({
  icon: 'error',
  title: 'Oops...',
  text: 'Quiere eliminar la pregunta',
  footer: '<a href="">Why do I have this issue?</a>'
});
});   
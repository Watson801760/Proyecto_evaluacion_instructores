/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function redireccion (value){
    if (value == "Instructor") {
        location.href="Actualizar_Funcionario.jsp";
    }else if (value == "Administrador") {
        location.href="MenuAdministrador.jsp";
        
    }else if (value=="Aprendiz"){
        location.href="Instructores.jsp ";
    }
}
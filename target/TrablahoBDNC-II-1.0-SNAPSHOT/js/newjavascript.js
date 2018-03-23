/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//esconde as telas de login e cadastro
$(document).ready(function () {
    $("#centerLogar").hide();
    $("#centerRegistro").hide();
});

/*
 * mostra as telas de login
 * ao botão entar ser clicado
 */
$(document).ready(function () {
    $("#login").click(function () {
        $("#centerLogar").show();
        $("#carouselExampleIndicators").hide();
        $("#registrar").css("pointer-events", "none");
    });
});

/*
 * mostra as telas de cadastro
 * ao clicar em cadastro
 */
$(document).ready(function () {
    $("#registrar").click(function () {
        $("#centerLogar").hide();
        $("#carouselExampleIndicators").hide();
        $("#centerRegistro").show();
        $("#login").css("pointer-events", "none");
    });
});

/*
 *cancelar login
 */
$(document).ready(function () {
    $("#cancelogin").click(function () {
        $("#centerLogar").hide();
        $("#registrar").css("pointer-events", "");
    });
});
/*
 * efeitos do carrosel
 */


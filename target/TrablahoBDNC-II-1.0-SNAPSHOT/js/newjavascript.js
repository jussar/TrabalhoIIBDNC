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
 * menu usuario
 */
    function htmlbodyHeightUpdate(){
		var height3 = $( window ).height()
		var height1 = $('.nav').height()+50
		height2 = $('.main').height()
		if(height2 > height3){
			$('html').height(Math.max(height1,height3,height2)+10);
			$('body').height(Math.max(height1,height3,height2)+10);
		}
		else
		{
			$('html').height(Math.max(height1,height3,height2));
			$('body').height(Math.max(height1,height3,height2));
		}
		
	}
	$(document).ready(function () {
		htmlbodyHeightUpdate();
		$( window ).resize(function() {
			htmlbodyHeightUpdate();
		});
		$( window ).scroll(function() {
			height2 = $('.main').height();
  			htmlbodyHeightUpdate();
		});
	});
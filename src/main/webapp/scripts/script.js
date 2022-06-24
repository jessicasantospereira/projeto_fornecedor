/**
 * 
 */
jQuery(document).ready(function(){
	jQuery("input#cnpj").on("keyup", function(e)
	{
	    $(this).val(
	        $(this).val()
	        .replace(/\D/g, '')
	        .replace(/^(\d{2})(\d{3})?(\d{3})?(\d{4})?(\d{2})?/, "$1.$2.$3/$4-$5"));
	});

});


jQuery(document).on('click', '#apagar_fornecedor', function(e) {
	let resposta = confirm("Confirma a exclusão?");
	if (resposta == true) {
		confirm("Apagado com sucesso!");
		iziToast.sucess({
            title: '|',
            message: 'Apagado com sucesso',
        });
	}
	
});

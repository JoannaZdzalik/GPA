/**
 * 
 */

$('document').ready(function() {

	$('button[type="submit"]').click(function(event) {
		event.preventDefault();

       var offerToCreate = $("#offerForm").serializeArray(); 		
	
		$.post("/gpa/addoffer", offerToCreate , function() {
			iziToast.show({
				title: 'Sukces',
				message: 'Oferta została dodana pomyślnie.',
				position: 'topRight',
				timeout: 5000,
				color: 'green'
			});

		}).fail(function(response) {
			console.log(response);
			iziToast.show({
				title: 'Błąd',
				message: 'Coś poszło nie tak!',
				position: 'topRight',
				color: 'red'
			});
		});
	});
}); 
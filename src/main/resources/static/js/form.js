/**
 * 
 */

$('document').ready(function() {

	$('button[type="submit"]').click(function(event) {
		event.preventDefault();

	var offerToCreate = {'title': $('#title').val(),
        			'validFor': $('#validFor').val(),
        			'durationOfWork': $('#durationOfWork').val(),
        			'additionalInfo': $('#additionalInfo').val(),
        			'percentVAT': $('#percentVAT').val()}
	
		$.post("/gpa/addoffer", offerToCreate , function() {
			console.log("Offer created: " + JSON.stringify(offerToCreate));
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
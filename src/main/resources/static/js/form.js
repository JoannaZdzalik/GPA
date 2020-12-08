/**
 * 
 */

$('document').ready(function() {

	$('button[type="submit"]').click(function(event) {
		event.preventDefault(); 

      var offerToCreate = $("#offerForm").serialize();
      
		$.post("/gpa/addoffer", offerToCreate , function(data) {
		console.log('created offer is: ' + JSON.stringify(offerToCreate));
		console.log(data);
			iziToast.success({
				title: 'Sukces',
				message: data,
				position: 'topRight',
				timeout: 5000,
				color: 'green'
			});
		}).fail(function(data) {
			console.log('wyszlo ci zle: ' + data.responseText );
			iziToast.error({
				title: 'Błąd',
				message: data.responseText,
				position: 'topRight',
				timeout: 5000,
				color: 'red'
			});
		}); 
	}); 
}); 
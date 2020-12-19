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
				message: data.status,
				position: 'topRight',
				timeout: 5000,
				color: 'green'
			});
		}).fail(function(data) {
			console.log('Błąd. ResponseText: ' + data.responseText );
			var data=data.responseText;
			var jsonResponse = JSON.parse(data);
			console.log(jsonResponse["status"]);
			iziToast.error({
				title: 'Błąd',
				message: jsonResponse["status"],
				position: 'topRight',
				timeout: 5000,
				color: 'red'
			});
		}); 
	}); 
}); 
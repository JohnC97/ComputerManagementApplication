
$(document).ready(function() {
	$("#driver").click(function(event) {
		$('#divID').html('');
		var free = document.getElementById("free").value;
		changetext("Searching");
		document.getElementById("free").value = "";
		if (!free == "") {
			$.getJSON('http://localhost:8080/ComputerManagement/webservice/computers/name/' + free, function(jd) {
					changetext("success");
					$('#divID').append('<div class="divisionclass" id="division' + jd.id + '" style="clear: left;">');
					$('#divID').append('<table>');
					$('#divID').append('<p style="float: left;"> <img id="image' + jd.id + '" src="' + jd.computerImgSrc + '"></p>');
					$('#divID').append('<br>');
					$('#divID').append('<tr><th>ID:</th><td>'    + jd.id 			  +		   '</td></tr>');
					$('#divID').append('<tr><th>Name:</th><td>'  + jd.computerName  +		   '</td></tr>');
					$('#divID').append('<tr><th>Price:</th><td>' + jd.computerPrice + ":-" + '</td></tr>');
					$('#divID').append('<tr><th>Type:</th><td>'  + jd.computerType  + 	   '</td></tr>');
					$('#divID').append('<tr><th>Spec:</th><td>'  + jd.computerSpec  + 	   '</td></tr>');
					$('#divID').append('<br><br>');
					$('#divID').append('</div>');
					$('#divID').append('</div>');
					$('#divID').append('</table>');
		     changetext("Search Result for: " + free);
		   });
			
		} else {
			changetext("NO SEARCH WORDS GIVEN");
		}
		
	});

});

function changetext(string) {
	if (string == null) {
		string = "";
	}
	document.getElementById("paragraph").innerHTML = string;
}
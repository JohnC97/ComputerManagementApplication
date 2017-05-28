
$(document).ready(function() {
	$("#driver").click(function(event) {
		$('#divID').html('');
		var free = document.getElementById("free").value;
		changetext("Searching");
		document.getElementById("free").value = "";
		var i = 0;
		if (!free == "") {
			$.getJSON('http://localhost:8080/ComputerManagement/webservice/computers/name/' + free, function(jd) {
					changetext("success");
					jd.forEach(function (jd){
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
						i++;
						return null;
					});
		     changetext(i + " posts found for search word(s): " + free);
		   });
			
		} else {
			changetext("You must enter atleast one search word");
		}
		
	});

});

function changetext(string) {
	if (string == null) {
		string = "";
	}
	document.getElementById("paragraph").innerHTML = string;
}
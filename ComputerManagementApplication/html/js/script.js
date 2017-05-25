
$(document).ready(function() {
	/* --- DRIVER GET ALL DATA JSON --- */
	$("#driver").click(function(event) {
		var i = 0;
		$('#div').html('');
		changetext("Loading JSON data from database..");
		$.getJSON('http://localhost:8080/ComputerManagement/webservice/computers/', function(jd) {
		// Should be able to get with id
			jd.forEach(function (jd) {
				$('#div').append('<div class="divisionclass" id="division' + jd.id + '" style="clear: left;">');
				$('#div').append('<table>');
				$('#div').append('<p style="float: left;"> <img id="image' + jd.id + '" src="' + jd.computerImgSrc + '"></p>');
				$('#div').append('<br>');				
				$('#div').append('<tr><th>ID:</th><td>'    + jd.id 			  +		   '</td></tr>');
				$('#div').append('<tr><th>Name:</th><td>'  + jd.computerName  +		   '</td></tr>');
				$('#div').append('<tr><th>Price:</th><td>' + jd.computerPrice + ":-" + '</td></tr>');
				$('#div').append('<tr><th>Type:</th><td>'  + jd.computerType  + 	   '</td></tr>');
				$('#div').append('<tr><th>Spec:</th><td>'  + jd.computerSpec  + 	   '</td></tr>');
				$('#div').append('<br><br>');
				$('#div').append('</div>');
				$('#div').append('<div id="spacediv">');
				$('#div').append('<br><br>');
				$('#div').append('</div>');
				i++;
	     });
	     $('#div').append('</table>');
	     changetext(i + " post found");
	   });
	});        
	changetext();
	
	$(document).ready(function() {
		$("#clear").click(function(event) {
			console.log("CLEAR");
			changetext();
			$('#div').html('');
	        });
	    });
	       
	 });

function changetext(string) {
	if (string == null) {
		string = "";
	}
	document.getElementById("paragraph").innerHTML = string;
}

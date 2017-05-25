
$(document).ready(function() {
	$("#driver").click(function(event) {
		$('#divID').html('');
		var startValue = new Number(document.getElementById("startValue").value);
		var endValue = new Number(document.getElementById("endValue").value);
		changetext("Searching");
		document.getElementById("startValue").value = "";
		document.getElementById("endValue").value = "";
		var i = 0;
		
//		if (startValue > endValue) {
//			alert("startValue is greater than endValue:\nstartValue: " 
//					+ startValue 
//					+ "\nendValue: " + endValue);
//			alert("startValue is a: " + typeof startValue
//				+ "\n endValue is a: " + typeof endValue);
//		}
		
		if (!startValue == "" && !endValue == "" && startValue >= 0 && endValue > startValue) {
			$.getJSON('http://localhost:8080/ComputerManagement/webservice/computers?start=' + startValue + '&end=' + endValue, function(jd) {
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
					});
		     changetext(i + " post found between " + startValue + ":- and " + endValue + ":-");
		   });
			
		} else if (startValue > endValue) {
			changetext("lowest value must be lower than highest");
		}
		
	});

});

function changetext(string) {
	if (string == null) {
		string = "";
	}
	document.getElementById("paragraph").innerHTML = string;
}
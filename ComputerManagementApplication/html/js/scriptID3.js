
$(document).ready(function() {
	$("#driver").click(function(event) {
		$('#divID').html('');
		var id = document.getElementById("mySearch").value;
		changetext("Searching");
		if (!id == "") {
			$.getJSON('http://localhost:8080/ComputerManagement/webservice/computers/id/' + id, function(jd) {
				//if (jd.success()) {
					changetext("success");
					$('#divID').append('<div class="divisionclass" id="division' + jd.id + '" style="clear: left;">');
					$('#divID').append('<table>');
					$('#divID').append('<p style="float: left;"> <img id="image' + jd.id + '" onclick="changetext()" src="' + jd.computerImgSrc + '"></p>');
					$('#divID').append('<br>');
					$('#divID').append('<tr><th>ID:</th><td>'    + jd.id 			  +		   '</td></tr>');
					$('#divID').append('<tr><th>Name:</th><td>'  + jd.computerName  +		   '</td></tr>');
					$('#divID').append('<tr><th>Price:</th><td>' + jd.computerPrice + ":-" + '</td></tr>');
					$('#divID').append('<tr><th>Type:</th><td>'  + jd.computerType  + 	   '</td></tr>');
					$('#divID').append('<tr><th>Spec:</th><td>'  + jd.computerSpec  + 	   '</td></tr>');
					$('#divID').append('<br><br>');
					$('#divID').append('</div>');
					$('#divID').append('<div id="spacediv">');
					$('#divID').append('<br><br><br><br><br><br><br><br>');
					$('#divID').append('</div>');
					$('#divID').append('</table>');					
				//} else {
					//changetext("No such id as: " + id);
				//}
		     changetext("Result for ID: " + id);
		   });
		} else {
			changetext("NO ID GIVEN");
		}
		
	});    
});

function changetext(string) {
	if (string == null) {
		string = "";
	}
	document.getElementById("paragraph").innerHTML = string;
}














//   <script type="text/javascript" language="javascript" src="js/script.js">
//      console.log("Loading json..");
//         $(document).ready(function() {
//            
//			/* --- DRIVER GET ALL DATA JSON --- */
//        	 $("#driver").click(function(event) {
//				var i = 1;
//				
//               $.getJSON('http://localhost:8080/ComputerManagement/webservice/computers/', function(jd) {
//            	   // Should be able to get with id
//              	 jd.forEach(function (jd) {
//              	   $('#div').append('<div id="division' + jd.id + '" style="clear: left;">');
//            	   $('#div').append('<table>');                 
//                   $('#div').append('<p style="float: left;"><img  id="image' + jd.id + '" onclick="changetext()" src="' + jd.computerImgSrc + '"></p>'); 
//                   $('#div').append('<br><br>');
//                 
//					// IT'S ALIVE                    
//                    $('#div').append('<tr><th style="text-align: right; padding-right: 1rem;">ID:</th><td>'    + jd.id 			  +		   '</td></tr>');
//                    $('#div').append('<tr><th style="text-align: right; padding-right: 1rem;">Name:</th><td>'  + jd.computerName  +		   '</td></tr>');
//                    $('#div').append('<tr><th style="text-align: right; padding-right: 1rem;">Price:</th><td>' + jd.computerPrice + ":-" + '</td></tr>');
//                    $('#div').append('<tr><th style="text-align: right; padding-right: 1rem;">Type:</th><td>'  + jd.computerType  + 	   '</td></tr>');
//                    $('#div').append('<tr><th style="text-align: right; padding-right: 1rem;">Spec:</th><td>'  + jd.computerSpec  + 	   '</td></tr>');
//                    $('#div').append('<br><br>');
//                    $('#div').append('</div>');
//                 });
//                 $('#div').append('</table>');
//               });
//            });        
//			
//			
//            $(document).ready(function() {
//            	$("#clear").click(function(event) {
//            		console.log("CLEAR");
//            		$('#div').html('');
//                });
//            });
//               
//         });
//      </script>


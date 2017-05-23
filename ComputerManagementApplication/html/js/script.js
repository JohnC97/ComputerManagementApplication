
$(document).ready(function() {
	/* --- DRIVER GET ALL DATA JSON --- */
	//alert("hello");
	$("#driver").click(function(event) {
		var i = 1;
		$('#div').html('');
		changetext("Loading JSON data from database..");
		$.getJSON('http://localhost:8080/ComputerManagement/webservice/computers/', function(jd) {
		// Should be able to get with id
			jd.forEach(function (jd) {
				$('#div').append('<div class="divisionclass" id="division' + jd.id + '" style="clear: left;">');
				$('#div').append('<table>');                 
				$('#div').append('<p style="float: left;"> <img id="image' + jd.id + '" onclick="changetext()" src="' + jd.computerImgSrc + '"></p>'); 
				$('#div').append('<br>');
		// IT'S ALIVE
		// Here is javascript getting all values from json
				/*
				if (jd.id == 1) {
					alert("id is 1");
				}
				*/
				
				$('#div').append('<tr><th>ID:</th><td>'    + jd.id 			  +		   '</td></tr>');
				$('#div').append('<tr><th>Name:</th><td>'  + jd.computerName  +		   '</td></tr>');
				$('#div').append('<tr><th>Price:</th><td>' + jd.computerPrice + ":-" + '</td></tr>');
				$('#div').append('<tr><th>Type:</th><td>'  + jd.computerType  + 	   '</td></tr>');
				$('#div').append('<tr><th>Spec:</th><td>'  + jd.computerSpec  + 	   '</td></tr>');
				$('#div').append('<br><br>');
				$('#div').append('</div>');
	     });
	     $('#div').append('</table>');
	     changetext();
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


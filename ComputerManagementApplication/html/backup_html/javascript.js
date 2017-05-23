
function test() {
	
	console.log("CONSOLE");
	
//	return document.getElementById("pTest").innerHTML = "hello";
//	return "hello"; // WORKS
	var data = (function(){
				console.log("Inside function");
			var read = new XMLHttpRequest();
				console.log("XMLHtteRequest()");
//			read.open('GET', 'http://localhost:8080/ComputerManagement/webservice/computers/', true);
			read.open('GET', 'https://www.w3schools.com/');
				console.log("GET url");
			read.send();
				console.log(".send");
			var text = read.responseText;
				console.log("return text");
				console.log("text: " + text);
			return text;
	  })();
	return data + "WAT";
}

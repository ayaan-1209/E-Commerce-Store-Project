function validate(){
	var user = document.getElementById("ruser");
	var pass = document.getElementById("rpass");
	var firstname = document.getElementById("fname");
	var lastname = document.getElementById("lname");
	var email = document.ElementById("email");
	var street = document.ElementById("street");
	var apt = document.ElementById("apt");
	var country = docuemnt.ElementById("country");
	var zip = document.ElementById("zip");
	var regex = /^[0-9a-zA-Z]+$/;
	var regex2 = /^[a-zA-z]+$/;
	if(user.value == ''){
		alert("Please enter a username");
		return false;
	}
	if(!(user.value.match(regex))){
		alert("username must be alphanumeric");
		return false;
	}
	if(pass.value==''){
		alert("Please enter a password");
		return false;
	}
	if(firstname.value == ''){
		alert("Please enter a first name");
		return false;
	}
	if(lastname.value == ''){
		alert("Please enter a last name");
		return false;
	}
	if(email.value == ''){
		alert("Please enter an email");
		return false;
	}
		
	if(street.value == ''){
		alert("Please enter a street");
		return false;
	}
	if(country.value == ''){
		alert("Please enter a country");
		return false;
	}
	if(zip.value == ''){
		alert("Please enter an zip");
		return false;
	}
	if(!(firstname.value.match(regex2))){
		alert("first name needs to be only alphabet characters");
		return false;
	}
	if(!(lastname.value.match(regex2))){
		alert("last name needs to be only alphabet characters");
		return false;
	}
	if(!(street.value.match(regex))){
		alert("street must be alphanumeric");
		return false;
	}
	if(!(zip.value.match(regex))){
		alert("zip must be alphanumeric");
		return false;
	}
	if(!(country.value.match(regex2))){
		alert("country must only contain alphabet characters");
		return false;
	}
}
		


function validateLogin(){
	var user = document.getElementById("luser");
	var pass = document.getElementById("lpass");
	var regex = /^[0-9a-zA-Z]+$/;
	if(user.value == ''){
		alert("Please enter a username");
		return false;
	}
	if(!(user.value.match(regex))){
		alert("username must be alphanumeric");
		return false;
	}
	if(pass.value==''){
		alert("Please enter a password");
		return false;
	}
		
}

function register(){
	if(validate()){
		
	}
}

function login(){
	if(validateLogin()){
		
	}
}
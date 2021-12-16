/**
 * 
 */
//------selector--------

const login = document.querySelector("#submit__login");
const user = document.querySelector("#uname__login");

const pass = document.querySelector("#psw__login");

const errorUser = document.querySelector("#user");
const errorPsw = document.querySelector("#password");
const loginFail = document.querySelector(".login__fail");
const loginSucc = document.querySelector(".login__success");

// Show warning error
function validateForm() {
	if(user.value == "" ){
		errorUser.classList.remove("hidden");
		if(pass.value == ""){
		errorPsw.classList.remove("hidden");
		}
		return false;
		
	}
	if(pass.value == ""){
		errorPsw.classList.remove("hidden");
		return false;
		
	}
	
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	var passw=   /[a-zA-Z0-9!@#$%^&*]{3,16}$/;
	if(!user.value.match(mailformat)){
		document.querySelector("#user1").classList.remove("hidden");
		return false;
	}
	
	if(!pass.value.match(passw)){
		document.querySelector("#password1").classList.remove("hidden");
		return false;
	}
return true;
}

// Remove warning
user.addEventListener("input",()=>{
	errorUser.classList.add("hidden");
	document.querySelector("#user1").classList.add("hidden");
})

pass.addEventListener("input",() =>{
	errorPsw.classList.add("hidden");
	document.querySelector("#password1").classList.add("hidden");
})
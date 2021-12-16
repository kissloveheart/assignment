/**
 * 
 */
//------selector--------
const form = document.querySelector(".login--input")
const login = document.querySelector("#submit__login");
const user = document.querySelector("#uname__login");
const username = document.querySelector("#name__login");

const pass = document.querySelector("#psw__login");
const passre = document.querySelector("#rpsw__login");

const errorUser = document.querySelector("#user");
const errorUser2 = document.querySelector("#user2");
const errorPsw = document.querySelector("#password");
const errorPsw2 = document.querySelector("#password2");
const errorPsw3 = document.querySelector("#password3");
const loginFail = document.querySelector(".login__fail");
const loginSucc = document.querySelector(".login__success");
const check = document.querySelector(".check");

let result = true;

// Show warning error
function validateRegister() {
	let checkNull = true;
	if (user.value == "") {
		errorUser.classList.remove("hidden");
		checkNull = false;
	}
	if (username.value == "") {
		errorUser2.classList.remove("hidden");
		checkNull = false;
	}

	if (pass.value == "") {
		errorPsw.classList.remove("hidden");
		checkNull = false;
	}

	if (passre.value == "") {
		errorPsw2.classList.remove("hidden");
		checkNull = false;
	}



	if (!checkNull) {
		return false;
	}



	var passw = /[a-zA-Z0-9!@#$%^&*]{3,16}$/;
	if (!pass.value.match(passw)) {
		document.querySelector("#password1").classList.remove("hidden");
		return false;
	}
	if (result) {
		return false;
	}
	return true;
}

// check email exist ?

const checkMail = function() {
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if (!user.value.match(mailformat)) {
		document.querySelector("#user1").classList.remove("hidden");
		return false;
	}

	return true;
}

async function checkExistMail(email) {
  if (checkMail()) {
    check.innerHTML = "";
    const response = await fetch(`CheckEmail?email=${email}`);
    const data = await response.text();
    if (data == "true") {
      check.insertAdjacentHTML(
        "beforeend",
        ` <div class="checkMail checkMail--fail">Email này đã đăng ký</div>`
      );
    } else if (data == "false") {
      check.insertAdjacentHTML(
        "beforeend",
        `<div class="checkMail checkMail--success">Bạn có thể sử dụng email này</div>`
      );
      result = false;
      console.log(result);
    }
  }
}


user.addEventListener("blur", () => {
	checkExistMail(user.value);
})

// check reenter password
passre.addEventListener("blur", () => {
	if (passre.value != pass.value) {
		errorPsw3.classList.remove("hidden");
	}
})

pass.addEventListener("blur", () => {
	if (passre.value != "" && passre.value == pass.value) {
		errorPsw3.classList.add("hidden");
	}
})


// Remove warning
user.addEventListener("input", () => {
	errorUser.classList.add("hidden");
	document.querySelector("#user1").classList.add("hidden");
	check.innerHTML = "";
})

username.addEventListener("input", () => {
	errorUser2.classList.add("hidden");
})

pass.addEventListener("input", () => {
	errorPsw.classList.add("hidden");
	document.querySelector("#password1").classList.add("hidden");
})

passre.addEventListener("input", () => {
	errorPsw2.classList.add("hidden");
	errorPsw3.classList.add("hidden");
})
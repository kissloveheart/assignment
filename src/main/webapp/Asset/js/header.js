
//-----Selector----------

const searchResponsive = document.querySelector(".nav__search--input");
const navIcon = document.querySelector(".nav__search--icon");
const searchForm = document.querySelector(".nav__search");



//-------Nav Repsponsive------

navIcon.addEventListener("click", (e) => {
	e.preventDefault;
	if (searchResponsive.className === "nav__search--input") {
		searchResponsive.className += " nav__search--respon";
	} else {
		searchResponsive.className = "nav__search--input";
	}

})



/**
 * 
 */

//-------selector---
const add = document.querySelector(".btn--cart");
const addDiv = document.querySelector("#cart");
const addCheckOut = document.querySelector(".cart");
const remove = document.querySelectorAll("#delete");
const addNotify = document.querySelector("#mark");




//------ Fetch to servlet--------

const updateCart = function(action, id) {
	addDiv.innerHTML = `<p><i class="fa fa-spinner fa-pulse" aria-hidden="true"></i> Đang xử lý</p>`;
	//fetch
	let aPromise = fetch(`CartBehavior?action=${action}&id=${id}`);
	// get result
	aPromise.then(res => {
		if (res.ok) {
			console.log("connected");
			res.json().then(list => {
				if (list != null) {
					showList(list);
					//console.log(list);	
				} else {
					addNotify.insertAdjacentHTML("afterend", `<p class="noItem">Chưa có món hàng nào</p>`);
					addDiv.innerHTML = "";
					document.querySelector("#btn--cart")?.parentElement.removeChild(document.querySelector("#btn--cart"));

				}
			})

		}
	}).catch(err => console.log(err));
}

//----------show the list------
const showList = function(list) {

	document.querySelector(".noItem")?.parentElement.removeChild(document.querySelector(".noItem"));
	if (document.querySelector("#btn--cart") == null) {
		addCheckOut.insertAdjacentHTML("beforeend", `<a href="MVC?action=checkout"><button 
				id="btn--cart">Thanh toán</button></a>`);
	}

	addDiv.innerHTML = "<tr><th>Điện thoại</th><th>Số lượng</th></tr>";
	list.forEach((item, index) => {
		addDiv.insertAdjacentHTML(
			"beforeend", `	<tr>
					<td>${item.name}</td>
					<td>${item.number}</td>
					<td id="delete" data-id="${item.id}">Xóa</td>
				</tr>` )
	});
}

//-------add event click------
if (add != null) {
	add.addEventListener("click", (e) => {
		e.preventDefault();
		updateCart("add", add.dataset.id);
	});
}


//----------remove event click---------

addDiv.addEventListener("click", (e) => {
	e.preventDefault();
	click = e.target;
	//console.dir(click);
	if (click.tagName == "TD" && click.id == "delete") {
		updateCart("remove", click.dataset.id);
	}

})



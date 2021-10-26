/**
 * 
 */

let form = document.getElementById("newItem");
	
	let subBtn = document.getElementById("sub-btn");
	//subBtn.addEventListener('click', (e) => {
		//e.preventDefault();
		//
	//})
	
	var reimb;
	
	form.addEventListener("submit", (e) => {
		e.preventDefault();
		let id = document.getElementById("id").value;
		let amount = document.getElementById("amount").value;
		let description = document.getElementById("description").value;
		let type = document.getElementById("type").value;
		
		reimb = {
				id, amount, description, type
		}
		
		
	})



const getBtn = document.getElementById("get-btn");
const postBtn = document.getElementById("post-btn");

const getData = () => {
	axios
		.get(`http://localhost:8080/ERSReimbursement/getsessionuser.json`)
		.then(res => {
			console.log(res.data);
		})
	
};

const postData = () => {
	axios
		.post(`http://localhost:8080/ERSReimbursement/sub.json`, reimb)
		.then(res => {
			console.log(res);
		})
		.catch(err => {
			console.log(`The error is: ${err}`);
		})
};

getBtn.addEventListener('click', getData);
postBtn.addEventListener('click', postData);
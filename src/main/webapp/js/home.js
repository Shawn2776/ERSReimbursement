/**
 * 
 */
window.onload = function()
{
	getSessUser();
	getAllReimbursements();
}

function getSessUser() {
	
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function()
	{
		if (xhttp.readyState == 4 && xhttp.status == 200)
		{
			let usr = JSON.parse(xhttp.responseText);
			document.getElementById("welcomeHeading").innerText = `Welcome ${usr.firstName}`;
			document.getElementById("subHeading").innerText = `Your EmployeeID is: ${usr.userId}`;
			
		}
	}
	
	xhttp.open("GET", "http://localhost:8080/ERSReimbursement/getsessionuser.json");
	
	xhttp.send();
}




function getAllReimbursements() {
	axios
		.get("http://localhost:8080/ERSReimbursement/allReimbursements.json")
		.then(res => {
			console.log(res);
		})
		.catch(err => {
			console.log(err);
		})
}
	
	
	
	
/*
		
		}
		
	const request = new XMLHttpRequest();
		
		request.open("POST", "/ERSReimbursement/submitreimbursement.json");
		request.onload = function () {
			console.log("in doIt")
			console.log(request.responseText);
			request.send(data);
		
		}
	
	
	
	)
	

	
	
}
*/






// let amnt = document.getElementById("amount").value
// let data = JSON.stringify({"amount": amount, "type": type, "description": desctription, "reimbAuthor": userid});
// xhttp.send(data)
// HelloJavascript 
// getsessionreimb()




/*
working dta extractor





*/
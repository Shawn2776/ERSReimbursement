const myForm = document.getElementById('myForm');

myForm.addEventListener('submit', function (e) {
	e.preventDefault();
	
	let trihard = document.getElementById("subHeading").innerText;
	let triharder = parseInt(trihard.substring(trihard.length - 1));
	
	
	
	const formData = new FormData(this);
	
	const searchParams = new URLSearchParams();
	
	for (const pair of formData) {
		searchParams.append(pair[0], pair[1]);
	}
	
	searchParams.append('id', triharder);
	
	axios
		.post('http://localhost:8080/ERSReimbursement/sub.json', searchParams)
		.then(res => {
			console.log(res.data);
			
			alert('Reimbursement Submitted Successfully. Please Press OK to Continue...');
		}).catch(err => {
			alert(err)
		})
	
	document.getElementById("myForm").reset()
	/*
	fetch('http://localhost:8080/ERSReimbursement/sub.json', {
		method: 'POST',
		data: 'searchParams'
	}).then(function (res) {
		return res.text();
	}).then(function (text) {
		console.log(text);
	}).catch(function (error) {
		console.error(error);
	})
	
	*/
})
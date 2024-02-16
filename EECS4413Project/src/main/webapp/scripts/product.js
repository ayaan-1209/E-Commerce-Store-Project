function validate(){
	if (document.getElementById("reviewtext").value == '') {
		alert("Must write something inorder to review");
		return false;
	}
	var p = document.getElementById("rating").value;
	if(p <= 0 || p > 5){
		alert("rating value must be between 1-5");
		return false;
	}		
	return true;
}


function makeProductRequest(url){
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	makeProduct(urlParams);
	var request= new XMLHttpRequest(); //prepare an HTTP request
	request.open("GET", (url + "?bid="+urlParams.get('bid')), true);
	request.onreadystatechange = function() {
		handler(request);
	};
	request.send();
}

function makeProduct(urlParams){
	const name = urlParams.get('name');
	const desc = urlParams.get('description');
	const img = urlParams.get('img');
	const price = urlParams.get('price');
	document.getElementById("name").innerHTML = name;
	document.getElementById("desc").innerHTML = desc;
	document.getElementById("img").src = img; 
	document.getElementById("price").innerHTML = "$"+price;
	
}

function handler(request){
  if ((request.readyState == 4) && (request.status == 200)){
	 var target = document.getElementById("reviews");
     var rs=JSON.parse(request.responseText);
     makeReviews(rs, target)
   }
} 

function makeReviews(rs, target){
	    
	document.getElementById("averageRating").innerHTML= rs.averageRating;
	document.getElementById("nReviews").innerHTML = rs.numberOfReviews;
	for(var i = 0; i < rs.reviews.length; i++){
		var review = rs.reviews[i];
		var p = document.createElement('p');
		p.className="fw-bold lead mb-2";
		p.innerHTML =review.username + " rating-"+review.rating;
		var p2= document.createElement('p2');
		p2.className="text-muted fw-light mb-4";
		p2.innerHTML = review.reviewText;
		target.appendChild(p);
		target.appendChild(p2);
	}
}

function writeReview(url){
	if(validate()){	
		var request= new XMLHttpRequest(); //prepare an HTTP request
		const queryString = window.location.search;
		const urlParams = new URLSearchParams(queryString);
		var data = "review="+document.getElementById("reviewtext").value+"&rating="+document.getElementById("rating").value+"&bid="+urlParams.get('bid');
		request.open("POST", (url + "?" + data), true);
		request.send();
		setTimeout(function(){
   			window.location.reload();
		}, 500);
	}
}

function addToCart(url){
		var request= new XMLHttpRequest(); //prepare an HTTP request
		const queryString = window.location.search;
		const urlParams = new URLSearchParams(queryString);
		request.open("POST", (url + "?bid=" + urlParams.get('bid')), true);
		request.send();
		alert("added to cart");
}
function makeCatalogRequest(url){
	var request= new XMLHttpRequest(); //prepare an HTTP request
	request.open("GET", (url), true);
	request.onreadystatechange = function() {
		handler(request);
	};
	request.send();
}


function handler(request){
  if ((request.readyState == 4) && (request.status == 200)){
	 var target = document.getElementById("cat");
     var rs=JSON.parse(request.responseText);
     makeCatalog(rs, target)
   }
} 

function makeCatalog(rs, target){     
	//reset catalog 
    var child = target.lastElementChild; 
    while (child) {
        target.removeChild(child);
        child = target.lastElementChild;
    }

	for(var i = 0; i < rs.items.length; i++){
		var item = rs.items[i];
		var div = document.createElement('div');
		div.className="col-12 col-md-4 col-lg-3 mb-5";
		var a = document.createElement('a');
		a.className="product-item";
		a.href="product.html?name="+item.name+"&description="+item.description+"&bid="+item.bid+"&img="+item.img+"&price="+item.price;
		var img = document.createElement('img');
		img.src = item.img;
		img.className="img-fluid product-thumbnail";
		img.width=200;
		img.height=200;
		a.appendChild(img);
		var header = document.createElement('h3');
		header.innerText = item.name;
		header.className="product-title"
		a.appendChild(header);
		var price = document.createElement('strong');
		price.innerText = '$'+ item.price;
		price.className="product-price"
		a.appendChild(price);
		div.appendChild(a);
		target.appendChild(div);
	}
}

function filterCatalog(url){
	var request= new XMLHttpRequest(); //prepare an HTTP request
	var data = '';
	if(document.getElementById("brand1").checked) data+= "apple=true";
	else data+="apple=false";
	
	if(document.getElementById("brand2").checked) data+= "&samsung=true";
	else data+="&samsung=false";
	
	if(document.getElementById("type1").checked) data+= "&phone=true";
	else data+="&phone=false";
	
	if(document.getElementById("type2").checked) data+= "&laptop=true";
	else data+="&laptop=false";
	
	request.open("GET", (url + "?" + data), true);
	request.onreadystatechange = function() {
		handler(request);
	};
	request.send();
}
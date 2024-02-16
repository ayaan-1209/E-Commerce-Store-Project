function makeCartRequest(url){
	var request= new XMLHttpRequest(); //prepare an HTTP request
	request.open("GET", (url), true);
	request.onreadystatechange = function() {
		handler(request);
	};
	request.send();
}


function handler(request){
  if ((request.readyState == 4) && (request.status == 200)){
	 var target = document.getElementById("cart");
     var rs=JSON.parse(request.responseText);
     makeCart(rs, target);
   }
} 

function makeCart(rs, target){     
	//reset catalog 
    var child = target.lastElementChild; 
    while (child) {
        target.removeChild(child);
        child = target.lastElementChild;
    }
    
	for(var i = 0; i < rs.items.length; i++){
		var item = rs.items[i];
		var tr = document.createElement('tr');
		var td = document.createElement('td');
		td.className = "product-thumbnail";
		var img = document.createElement('img');
		img.src = item.img;
		img.className = "img-fluid";
		img.alt = "Image";
		td.appendChild(img);
		tr.appendChild(td);
		var td2 = document.createElement('td');
		td2.className="product-name";
		var h2 = document.createElement('h2');
		h2.className="h5 text-black";
		h2.innerHTML=item.name;
		td2.appendChild(h2);
		tr.appendChild(td2);
		var td3 = document.createElement('td');
		td3.innerHTML="$"+item.price;
		tr.appendChild(td3);
		var td4 = document.createElement('td');
		var a = document.createElement('a');
		a.className="btn btn-black btn-sm";
		a.onclick=function removeFromCart(){
						var request= new XMLHttpRequest(); //prepare an HTTP request
						request.open("DELETE", ("rest/cart?bid="+item.bid), true);
						request.send();
						setTimeout(function(){window.location.reload();}, 500);
		};
		a.innerHTML='X';
		td4.appendChild(a);
		tr.appendChild(td4);
		target.appendChild(tr);
	}
}
function cookSearchRequest(){
	var url = document.location.href,
	params = url.split('?')[1].split('&'),
	data = {}, tmp;
	for (var i = 0, l = params.length; i < l; i++) {
		tmp = params[i].split('=');
		data[tmp[0]] = tmp[1];
	}
//	console.log(data.area);
	searchTheCook(data.area);

}


function searchTheCook(area){
//create object to give area as property.
	var sendArea ={areas:[area]};
//	console.log(sendArea);
	var searchArea = $.ajax({
		type: 'POST',
		url: "search/cook",
		data:JSON.stringify(sendArea),
		headers: { 
			'Accept': 'application/json',
			'Content-Type': 'application/json' 
		},
		dataType: "json",
		success: function(resultData) { 
			console.log(resultData);
			if(resultData && undefined != resultData.searchResponse){
//				console.log("call success");
				cookSearchData(resultData.searchResponse);
			}else{
				alert('call failed');
			}
		}  
//		success: cookSearchData(resultData.searchResponse) 
	});
//	loginUser.error(function() { alert("Something went wrong"); });
	
}

function cookSearchData(responseText){
	// Add the server data to the template
	$("#searchTemplate").tmpl(responseText).appendTo("#searchContainer");
       	
}

function testFunction(id){
	alert('Hi -- '+id);
}



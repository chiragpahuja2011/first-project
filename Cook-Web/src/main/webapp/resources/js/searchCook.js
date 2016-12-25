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
		url: "search/",
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

//	console.log(responseText);   		

// JSON parsing is not needed as the data is already in object form. 
 //var dataFromServer = JSON.parse(responseText);

    var dataFromServer = responseText;   //response text is an array of objects.
    var i =0;
    var getTable;
    var newRow;
    var newTd1;
    var newTd2;
    var newTd3;
    var para;
    var leftSideData;
    var rightSideData;
    var dataObject;
   getTable = document.getElementById("cookData");
    while (i < dataFromServer.length){ 
	dataObject = dataFromServer[i];

//	console.log(dataObject);


	newRow   = document.createElement("tr");
	newTd1   = document.createElement("td");
	newTd2   = document.createElement("td");
	newTd3   = document.createElement("td");

	newTd1.setAttribute("class", "details detailsLeft");
//	newTd1.setAttribute("style", "background-color:red");	
	newTd2.setAttribute("style", "width:15%");
//	newTd2.setAttribute("style", "background-color:green");		
	newTd3.setAttribute("class", "details detailsRight");
//	newTd3.setAttribute("style", "background-color:orange");	  
	getTable.appendChild(newRow);
	newRow.appendChild(newTd1);
	newRow.appendChild(newTd2);
	newRow.appendChild(newTd3);


                para = document.createElement("p");
		para.innerHTML = "Name: " + dataObject.firstName + " " + dataObject.lastName;
		newTd1.appendChild(para);

        	para = document.createElement("p");  
		para.innerHTML = "Speciality: " + dataObject.speciality;
		newTd1.appendChild(para);


		para = document.createElement("p"); 
		para.innerHTML = "Charges:" + dataObject.charges;
		newTd1.appendChild(para);

		para = document.createElement("button"); 
		para.innerHTML = "Visit Full Profile";
		newTd1.appendChild(para);


	i = i+1;

        if (i < dataFromServer.length) {
		dataObject = dataFromServer[i];
		para = document.createElement("p");
		para.innerHTML = "Name: " + dataObject.firstName + " " + dataObject.lastName;
		newTd3.appendChild(para);


         	para = document.createElement("p");  
		para.innerHTML = "Speciality: " + dataObject.speciality;
                newTd3.appendChild(para);

		para = document.createElement("p"); 
		para.innerHTML = "Charges:" + dataObject.charges;
                newTd3.appendChild(para);

		para = document.createElement("button"); 
		para.innerHTML = "Visit Full Profile"
		newTd1.appendChild(para);
		
		i = i+1;  
	}    
}
       	
}



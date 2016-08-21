function searchCook(){

	var e = document.getElementById("area_search");
	var areaSelected = e.options[e.selectedIndex].value;
	if(areaSelected != undefined && "" != areaSelected){
		window.location.href = "cookSearch.html?area="+areaSelected;

	} else{
		alert('Please select an area');
	}
}


function loadScript(){
	var url = document.location.href,
	params = url.split('?')[1].split('&'),
	data = {}, tmp;
	for (var i = 0, l = params.length; i < l; i++) {
		tmp = params[i].split('=');
		data[tmp[0]] = tmp[1];
	}
	var element = document.getElementById('area_search');
	console.log(data.area);
	element.value = data.area;
}

function signUp(){
	window.location.href = "signUp"
}


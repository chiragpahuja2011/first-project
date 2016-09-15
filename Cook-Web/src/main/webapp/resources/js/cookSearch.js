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


function submitSignUp(){
	var user = {};
	user.firstName = document.getElementById('firstName').value;
	user.lastName = document.getElementById('lastName').value;
	user.emailId = document.getElementById('userName').value;
	user.password = document.getElementById('userPassword').value;
	user.confirmPassword = document.getElementById('confirmPassword').value;
	user.age = document.getElementById('userAge').value;
	user.mobileNumber = document.getElementById('mobileNumber').value;
	user.chargeMonthly = document.getElementById('salary').value;

	var createUser = $.ajax({
	      type: 'POST',
	      url: "cook",
	      data:JSON.stringify(user),
	      headers: { 
        		'Accept': 'application/json',
        		'Content-Type': 'application/json' 
    	     },
	      dataType: "json",
	      success: function(resultData) { alert(" Server call success ful  Save Complete") }
	});
	createUser.error(function() { alert("Something went wrong"); });
	//user.userName = document.ge
}


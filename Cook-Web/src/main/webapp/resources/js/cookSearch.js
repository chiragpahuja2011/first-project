function searchCook(){

	var e = document.getElementById("areaSearch");
	var areaSelected = e.options[e.selectedIndex].value;
	if(areaSelected != undefined && "" != areaSelected){
		window.location.href = "cook-search?area="+areaSelected;

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
	loadAreas(data.area);

}

function signUp(){
	window.location.href = "cook-signup"
}

function uploadImage(){
	window.location.href = "cook-upload"
}


function login(){
	window.location.href = "cook-login"

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
	user.gender = $("input[type='radio'][name='gender']:checked").val();

	// Get the specialiity
	var checkboxValues = [];
	$('input[name=speciality]:checked').map(function() {
		checkboxValues.push($(this).val());
	});
	user.speciality = checkboxValues;

	// Get the area selected 
	var areaSelected = $("#workSelect").val();
	user.workingArea = areaSelected;

	var createUser = $.ajax({
		type: 'POST',
		url: "cookSignup/cook",
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


function loadData(){
	var loadData = $.ajax({
		type: 'GET',
		url: "cookSignup/loadData",
		headers: { 
			'Accept': 'application/json',
			'Content-Type': 'application/json' 
		},
		dataType: "json",
		success: function(resultData) {
			console.log('Call is success');
			if(undefined != resultData){
				var specData = resultData.specData;
				var areaData = resultData.areaData;
				$('#specData').html("");
				$('#workSelect').html("");
				var specInput = JSON.parse(specData);
				$.each(specInput, function() {	
					var html = '<input type="checkbox" name="speciality" value="'+this.spec_code+'">'+this.spec_desc+'</input>';
					$('#specData').append(html);
				});
				var areaInput = JSON.parse(areaData);
				$.each(areaInput, function() {	
					var html = '<option value='+this.area_code+'>'+this.area_desc+'</option>';
					$('#workSelect').append(html);
				});
			}
		}
	});
}

function loadAreas(inoutArea){
	var loadData = $.ajax({
		type: 'GET',
		url: "cookSignup/loadData",
		headers: { 
			'Accept': 'application/json',
			'Content-Type': 'application/json' 
		},
		dataType: "json",
		success: function(resultData) {
			console.log('Call is success');
			if(undefined != resultData){
				var specData = resultData.specData;
				var areaData = resultData.areaData;
				$('#areaSearch').html("");
				$('#areaSearch').append('<option value="" selected="selected">Select An Area</option>')
				var areaInput = JSON.parse(areaData);
				$.each(areaInput, function() {	
					var html = '<option value='+this.area_code+'>'+this.area_desc+'</option>';
					$('#areaSearch').append(html);
				});

				if(undefined != inoutArea){
					var element = document.getElementById('areaSearch');
					element.value = inoutArea;
				}
			}
		}
	});

}

function submitLogin(){
	var user = {};
	user.emailId = document.getElementById('userName').value;
	user.password = document.getElementById('userPassword').value;
	var loginUser = $.ajax({
		type: 'POST',
		url: "login/validate",
		data:JSON.stringify(user),
		headers: { 
			'Accept': 'application/json',
			'Content-Type': 'application/json' 
		},
		dataType: "json",
		success: function(resultData) { 
			console.log(resultData);
			if(resultData && undefined != resultData.userInfo){
				alert(" Login succcess");
			}else{
				alert('user Not present .. please try again');
			}
		}
	});
	loginUser.error(function() { alert("Something went wrong"); });

}

function uploadFormData(){
	var oMyForm = new FormData();
	oMyForm.append("file", imageFile.files[0]);

	var uploadImage = $.ajax({
		url: 'fileUpload/image',
		data: oMyForm,
		dataType: 'text',
		processData: false,
		contentType: false,
		type: 'POST',
		success: function(data){
			alert("image uploaded successfully");
		}
	});
	uploadImage.error(function() { alert("image upload failure"); });

}

function getImage(){

	var uploadImage = $.ajax({
		url: 'fileUpload/image/2',
		headers: { 
			'Accept': 'application/json',
			'Content-Type': 'application/json' 
		},
		type: 'GET',
		success: function(data){
			document.getElementById("ItemPreview").src = "data:image/png;base64," + data.imageData;
		}
	});
	uploadImage.error(function() { alert("image upload failure"); });

}

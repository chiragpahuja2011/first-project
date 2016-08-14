function searchCook(){
var element = document.getElementById('area_search');

	if(element.selectedIndex == 0){
		// Validation failed
		alert('Please select a area');
	}else{
		// Fetch the json based on the 
		$.get( "users", function( data ) {
			//  $( ".result" ).html( data );
			console.log(data);
			  alert( "Load was performed." );
			});
		
		
//		var str = '[{ "name": "chirag pahuja",        "imageURL": "http://abc.png", "gender": "male", "speciality": ["North","south" ]    },   {"name": "harish pal",        "imageURL": "http://abc.png",        "gender": "male",        "speciality": [ "North",          "south"        ]    },    {        "name": "Cook didi",        "imageURL": "http://abc.png",        "gender": "female",        "speciality": [            "North","south"     ]  }]';
//	console.log(str);
//	data =JSON.parse(str);
//	$('#results-ul').html("");
//    $.each(data, function() {				
//        var html = '<li style="height:120px;"><img src="" alt="image_not_provided" style="width:100px; float:left;"><div style= "overflow:hidden; padding-left:80px;">		<div>'+this.name+'</div><div>'+this.gender+'</div></li><br/>';
//        $('#results-ul').append(html);
//     });
	}
		
}
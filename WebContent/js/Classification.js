$(document).ready(function(){
	
	 fetch_classification()
	$("#classificationForm").submit(function(event){
		event.preventDefault();
		/*console.log($("#classificationForm").serialize());*/
		$.ajax({
			url:'ClassificationController',
			type:'post',
			data: $("#classificationForm").serialize(),
	success: function(data){
		//alert(data);	
		}
		});
	//	$('#myModel').modal('toggle');
		return false;
	});
	
	
	 $(document).on("click",".editaction", function(){
		  $('#myModel').modal('toggle');
		  $('#myModel .modal-title').html("Edit classification");
		  $('#myModel #action').val('edit');
		  $('#myModel #btnaction').val('Edit changes');
		var id=$(this).attr("data-id");
		var action='fetchsingle';
		// ajax call goes here
		 $.ajax({
            url: 'ClassificationController',
            type: 'post',
            data: {action:action,id:id},
            success: function(data) {           	
           	  $('#classificationId').val(data.classificationId);
           	  $('#classificationName').val(data.classificationName);
           	 
					}
            
		  	});
	});

	
	$(document).on("click",".deleteaction", function(){
		
		var id=$(this).attr("data-id");
			$.ajax({
				url:'ClassificationController',
				type:'post',
				data:{action:'delete',id:id},
				success:function(data){
					alert(data);
					// fetch_classification();
				}
		});
		
	});
	
	
	
		
	
});

function fetch_classification(){
	
	$.ajax({
		url:'ClassificationController',
		type:'get',
		success:function(datas){
			$.each(datas.classification,function(key,classification){
				
				/*console.log(datas.classification);*/
				var row=`<tr>
				<td>${classification.id}</td>
				<td>${classification.classificationname}</td>
				<td><button class='btn btn-warning btn-small editaction'data-id='${classification.id}'>Edit</button></td>
				<td><button class='btn btn-danger btn-small deleteaction-id='${classification.id}'>Delete</button></td>
				
			</tr>`;
				
				$("#classificationTable tbody").append(row);
			})
			
		}
	});
	
}

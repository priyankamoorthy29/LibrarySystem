$(document).ready(function(){
	fetch_classification();
	$("#classificationForm").submit(function(event){
		event.preventDefault();
		console.log($("#classificationForm").serialize());
		$.ajax({
			url:'ClassificationController',
			type:'post',
			data: $("#classificationForm").serialize(),
	success: function(data){
		//alert(data);	
		}
		});
		$('#myModel').modal('toggle');
		return false;
	});
	
	$(document).on("click",".editaction", function(){
		
		alert($(this).attr("data-id"))
		
	});
	
	$(document).on("click",".deleteaction", function(){
		
		alert($(this).attr("data-id"))
		
	});
	
	function fetch_classification(){
		
		$.ajax({
			url:'ClassificationController',
			type:'get',
			success:function(datas){
				$.each(datas.classification,function(key,classification){
					
					console.log(datas.classification);
					var row=`<tr>
					<td>${classification.id}</td>
					<td>${classification.classificationname}</td>
					<td><button class='btn btn-warning btn-small editaction'data-id='${classification.id}'>Edit</button></td>
					<td><button class='btn btn-danger btn-small deleteaction'data-id='${classification.id}'>Delete</button></td>
					
				</tr>`;
					
					$("#classificationTable tbody").append(row);
				})
				
			}
		});
		
	}
		
	
});

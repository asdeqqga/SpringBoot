/**
 * 
 */
$(document).ready(function(){
				
	// user1 목록1
	$('.user1.list1').click(function(){					
		
		$.ajax({
			url: '/Ch09/user1',
			method: 'GET',
			dataType: 'json',
			success: function(data){
				console.log(data);	
			}						
		});
	});
	
	$('.user1.list2').click(function(){
		
		let uid = 'a104';
		
		$.ajax({
			url: '/Ch09/user1/'+uid,
			method: 'GET',
			dataType: 'json',
			success: function(data){
				console.log(data);	
			}						
		});
		
	});
	
	$('.user1.register').click(function(){
		
		let jsonData = {
			"uid": "t101",
			"name": "홍길동",
			"hp": "010-9999-9999",
			"age": 22
		};
		
		$.ajax({
			url: '/Ch09/user1/',
			method: 'POST',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);	
			}						
		});
		
	});
	
	$('.user1.modify').click(function(){
		
		let jsonData = {
				"uid": "t101",
				"name": "홍길동",
				"hp": "010-3333-2222",
				"age": 29
			};
			
			$.ajax({
				url: '/Ch09/user1/',
				method: 'PUT',
				data: jsonData,
				dataType: 'json',
				success: function(data){
					console.log(data);	
				}						
			});
		
	});
	
	$('.user1.delete').click(function(){
		let uid = 't101';
		
		$.ajax({
			url: '/Ch09/user1/'+uid,
			method: 'DELETE',
			dataType: 'json',
			success: function(data){
				console.log(data);	
			}						
		});
		
	});
});		
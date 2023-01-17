/**
 * 
 */
$(document).ready(function(){
				
	// member 목록1
	$('.member.list1').click(function(){					
		
		$.ajax({
			url: '/Ch09/member',
			method: 'GET',
			dataType: 'json',
			success: function(data){
				console.log(data);	
			}						
		});
	});
	
	$('.member.list2').click(function(){
		
		let uid = 't101';
		
		$.ajax({
			url: '/Ch09/member/'+uid,
			method: 'GET',
			dataType: 'json',
			success: function(data){
				console.log(data);	
			}						
		});
		
	});
	
	$('.member.register').click(function(){
		
		let jsonData = {
			"uid": "t101",
			"name": "홍길동",
			"hp": "010-9999-9999",
			"pos": "사원",
			"dep": 101
		};
		
		$.ajax({
			url: '/Ch09/member/',
			method: 'POST',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);	
			}						
		});
		
	});
	
	$('.member.modify').click(function(){
		
		let jsonData = {
			"uid": "t101",
			"name": "홍길동",
			"hp": "010-3333-3333",
			"pos": "주임",
			"dep": 102
		};
			
		$.ajax({
			url: '/Ch09/member/',
			method: 'PUT',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);	
			}						
		});
		
	});
	
	$('.member.delete').click(function(){
		let uid = 't101';
		
		$.ajax({
			url: '/Ch09/member/'+uid,
			method: 'DELETE',
			dataType: 'json',
			success: function(data){
				console.log(data);	
			}						
		});
		
	});
});	
/**
 * 
 */
$(document).ready(function(){
				
		// user1 목록1
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
			
			let uid = 'a104';
			
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
				"uid": "s101",
				"name": "홍길동",
				"hp": "010-1234-1101",
				"age": 19
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
		
		$('.user1.modify').click(function(){
			
			let jsonData = {
					"uid": "s101",
					"name": "홍길동",
					"hp": "010-1234-2220",
					"age": 29
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
			let uid = 's101';
			
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
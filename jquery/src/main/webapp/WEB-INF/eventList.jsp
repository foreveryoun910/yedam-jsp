<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script>
        	// 이벤트목록
        	$(document).ready(function(){
        		$.ajax({
        			url: 'EventListServlet', // 요청페이지
        			dataType: 'json',
        			success: eventListFnc,
        			error: function(reject){
        				console.error(reject);
        			}
        		});
        	});
        	
        	// 이벤트목록조회 콜백함수
        	function eventListFnc(data){
        		let table = $('<table />').attr('border', '1');
        		
        		for(let i=0; i<data.length; i++){
	        		let br = $('<br>');
        			let tr1 = $('<tr />');
        			let a = $('<a />').attr('href', data[i].eventLink).attr('target', '_blank');
            		let img = $('<img />').attr('src', 'img/' + data[i].eventImage).attr('width', '50%').attr('height', '50%').attr('alt', '이벤트 이미지');
            		let td_image = $('<td />');
            		$(a).append(img)
            		$(td_image).append(a);
            		$(tr1).append(td_image);
            		
            		let tr2 = $('<tr />');
            		let td_title = $('<td />').text(data[i].eventTitle);
       				$(tr2).append(td_title);

       				let tr3 = $('<tr />');
       				let td_period = $('<td />').text(data[i].eventPeriod);
					$(tr3).append(td_period);
					
       				$(table).append(tr1, tr2, tr3, br);
        		}
        		$('#list').append(table);
        	}
        </script>	
</head>
<body>
	<div id="list">
	</div>
</body>
</html>
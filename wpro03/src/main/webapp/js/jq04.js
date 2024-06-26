$(document).ready(function() {
	// 01. HTML 문서를 text로 읽기
	$('#test1').click(function() {
		//alert("a");
		$("#disp").empty();
		
		//$("#disp").load("jq04.html");
		$("#disp").hide().load("jq04.html", function() {
			$(this).fadeIn(); // effect 처리
		});
	});
	
	// 02. JSON 읽기
	$('#test2').click(function() {
		$("#disp").empty();

		$.getJSON('jq04_json.jsp', function(datas) { // getJSON : JSON 전용
			//$("#disp").text(datas);
			
			let items =[];
			let str = "<ul>";
			$.each(datas.products, function(index, data) {
				console.log(data)
				
				let s = "<li>" + (index + 1) + ") " + data["code"] + " " + data["sang"] + " " + data["su"] + " " + data.dan + "</li>";
				items.push(s);
			});
			// 배열의 모든 항목을 하나의 문자열로 결합
			str += items.join('') + "</ul>";
			
			$("#disp").html(str);
		});
	});	
	
	// 03. XML 읽기
	$('#test3').click(function() {
		//alert("3");
		$.get('jq04_xml.jsp', function(datas) {
		//$.post('jq04_xml.jsp', function(datas) {
			//alert(datas);			
			// 하위 element(요소)를 검색할 때 find()
			//alert($(datas).find('product').length);
			$("#disp").empty();
			
			
			$(datas).find('product').each(function() {
				let product = $(this);
				let str = "<div>";
				str += product.find('code').text() + " ";
				str += product.find('prod').text() + " ";
				str += product.find('su').text() + " ";
				str += product.find('danga').text();
				str += "</div>";
				$("#disp").append(str);
			});
		}).fail(function() {
			$('#disp').text('test3 처리 오류');
		});
	});
	
	// 04. JSON 읽기 02
	$('#test4').click(function() {
		//alert('4');
		$("#disp").empty();
		
		$.ajax({
			type:"get", 		// 요청 방식 get
			url:'jq04_json.jsp',
			//data:{'code':3, 'sang':book},	// jq04_json.jsp?cod=3&asng=book 이라는 뜻
			dataType:"json",	// 반환 data type
			success:function(datas) {
				//alert(datas);
				let str = "";
				let count = 0;
				str += "<table border = '1'>";
				str += "<tr><th>코드</th><th>품명</th><th>수량</th><th>단가</th></tr>";
				
				$.each(datas.products, function(idx, data) {
					str += "<tr>";
					str += "<td>" + data["code"] + "</td>";
					str += "<td>" + data["sang"] + "</td>";
					str += "<td>" + data["su"] + "</td>";
					str += "<td>" + data["dan"] + "</td>";
					str += "</tr>";
					count++;
				});
				str += "</table>";
				$("#disp").append(str);
				$("#disp").append(`건수 : ${count}개`);
			},
			error:function(){
				$('#disp').text('test4 처리 오류');
			}
		});
	});
	
	
	// 05. XML 읽기 02
	$('#test5').on("click", function() {
		//alert('5');
		$("#disp").empty();
		
		$.ajax({
			type:"post", 		// 요청 방식 post
			url:'jq04_xml.jsp',
			dataType:"xml",	// 반환 data type
			success:function(datas) {
				
				let count = 0;
				str = "<table border = '1'>";
				str += "<tr><th>코드</th><th>품명</th><th>수량</th><th>단가</th></tr>"
				
				$(datas).find("product").each(function() {
					str += "<tr>";
					str += "<td>" + $(this).find("code").text() + "</td>";
					str += "<td>" + $(this).find("prod").text() + "</td>";
					str += "<td>" + $(this).find("su").text() + "</td>";
					str += "<td>" + $(this).find("danga").text() + "</td>";
					str += "</tr>";
					count++;
				});
				str += "</table>";
				$("#disp").append(str);
				$("#disp").append(`건수(XML) : ${count}개`);
			},
			error:function(){
				$('#disp').text('test5 처리 오류');
			}
		});
	});
});
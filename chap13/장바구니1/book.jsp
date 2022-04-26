<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>책 정보 상세보기</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script type="text/javascript">
function cartAdd() {
	var serData = $('#addForm').serialize();
	$.ajax({
		url:'/shop/add',
		method:'post',
		cache:false,
		data:serData,
		dataType:'json',
		success:function(res){
			alert(res.added ? '장바구니에 저장 성공':'저장 실패');
			if(res.added){
				location.href='/shop/list';
			}
		},
		error:function(xhr,status,err){
			alert('에러:'+err);
		}
	});
	return false;
}
</script>
</head>
<body>
<h3>도서정보 상세보기</h3>
<form id='addForm' onsubmit="return cartAdd();">
	<div>제목 : <label>Java로 살아남기</label>
		<input type="hidden" id="title" name="title" value="Java로 살아남기">
	</div>
	<div>가격 : <label>25,000원</label>
		<input type="hidden" id="price" name="price" value="25000">
	</div>
	<p>
	<div>
		<button type="submit" >장바구니에 담기</button>
		<button type="reset" >취 소</button>
	</div>
</form>
</body>
</html>
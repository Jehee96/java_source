<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../js/script.js"></script>
<script type="text/javascript">
window.onload = function(){
	document.getElementById("btnAdminLogin").onclick=funcAdminLogin;
	document.getElementById("btnAdminHome").onclick=funcAdminHome;
}
</script>
</head>
<body>
<form action="adminloginproc.jsp" name="adminLoginform" method="post">
<table>
  <tr>
  	<td colspan="2" style="text-align: center;">
  		<br><h1>👤 관리자 로그인</h1><br>
  	</td>
  </tr>
  <tr>
  	<td style="text-align: center;"><h2>관리자 ID : </h2></td>
  	<td><input type="text" name="adminid"></td>
  </tr>
  <tr>
  	<td style="text-align: center;"><h2>관리자 PW : </h2></td>
  	<td><input type="text" name="adminpasswd"></td>
  </tr>
  <tr>
  	<td colspan="2" style="text-align: center;">
  		<input type="button" value="관리자 로그인" id="btnAdminLogin">
  		<input type="button" value="메인 페이지" id="btnAdminHome">
  	</td>
  </tr>
</table>	
</form>
</body>
</html>






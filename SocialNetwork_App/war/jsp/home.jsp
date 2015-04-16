
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
<p> Welcome b2a ya ${it.name} </p>


<p> This is should be user home page </p>

<form action="/social/doSearch" method="post"> 
<input type="hidden" name="userName" value="${it.name}" >
<p>Enter user name</p>
<input type="text" name="friendName" /> 
<input type="submit" value="Search" />

</form>
<p>Requests Notifications Here</p>
<form action="/social/showURFR" method="post"> 
<input type="submit" value="See" />
</form>

</form>

<p>Message here</p>
<form action="jsp/Message" > 
<input type="submit" value="Write" />

</form>

</body>
</html>
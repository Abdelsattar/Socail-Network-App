<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
<p> Welcome ${it.name} ^_^ </p>


<form action="/social/doSearch" method="post"> 
<input type="hidden" name="userName" value="${it.name}" >
<p>Enter user name</p>
<input type="text" name="friendName" /> 
<input type="submit" value="Search" />

</form>

<!-- shai bl ne3na3 -->
<p>click</p>
<form action="/social/showURFR" method="post"> 
<input type="submit" value="See" />

</form>

<br>
<br>
<br>

<!-- lactel :D -->
<form action="/social/CreatePost" method="post">
  Post : <textarea rows="5" cols="50" name = "post"></textarea> <br>
  
  Feeling : <select name = "Feeling">
  				<option value = "Happy">Happy</option>
  				<option value = "Sad">Sad</option>
  				<option value = "Confused">Confused</option>
  				<option value = "lonly">lonely</option>
  				<option value = "Exasted">Exhasted</option>
  				<option value = "LOL">LOL</option>
  				<option value = "Confused">Confused</option></del>
  			</select>
  
  
  Privacy : <select name = "privacy">
  				<option value = "public">Public</option>
  				<option value = "private">Private</option>
  				<option value = "closed">Closed</option>
  			</select>
  <input type="submit" value="Post">
  
  </form>

</body>
</html>
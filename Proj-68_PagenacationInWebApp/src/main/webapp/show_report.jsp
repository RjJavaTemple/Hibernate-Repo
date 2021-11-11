<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
<c:when test="${! empty PageData }">
<h1 style="color: green; text-align: center;">The Report Data Is::::</h1>

<table border="1" align="center" bgcolor="pink">
<c:forEach var="SetAndImpClass" items="${PageData}">
<tr>
    <td>${SetAndImpClass.ActorId}</td>
    <td>${SetAndImpClass.ActorName}</td>
    <td>${SetAndImpClass.ActorAddress}</td>
    <td>${SetAndImpClass.ActorSalary}</td>
    <td>${SetAndImpClass.ActorColor}</td>
    <td>${SetAndImpClass.ActorGender}</td>
    <td>${SetAndImpClass.ActorCurrentFilm}</td>
</tr>
</c:forEach>
</table>
<br>
<p style="text-align: center;">
<c:forEach var="i" begin="1" end="${pagesCount }" step="1">
[<a href="Controler?PageNo=${i}&s1=link">${i }</a>] &nbsp;&nbsp;&nbsp;
</c:forEach>
</p>
</c:when>

</c:choose>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>路线结果</title>
</head>
<body style="text-align: center">
<table>
  <%
    List<String> lines=(List<String>) request.getAttribute("lines");
    if(lines!=null){
  %>
  <tr>
    <th style="border: orange solid 2px;font-size: 40pt">所属线路</th>
  </tr>
  <%for(String s:lines){%>
  <tr>
    <td style="border: orange solid 2px;font-size: 20pt"><%=s%></td>
  </tr>
  <%}%>
  <%
    }
    else {
  %>
  <%}%>
</table>
</body>
</html>

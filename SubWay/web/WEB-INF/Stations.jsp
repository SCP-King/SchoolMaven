<%@ page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>站点结果</title>
</head>
<body style="text-align: center">
<table>
        <%
      List<String> stations=(List<String>) request.getAttribute("stations");
      if(stations!=null){
    %>
    <tr>
        <th style="font-size: 40pt;border: orange solid 2px;">站点名称</th>
    </tr>
        <%for (String s:stations){%>
    <tr>
        <td style="border: orange solid 2px;font-size: 20pt"><%=s%></td>
    </tr>
        <%}%>
        <%
      }
    %>
</table>
</body>
</html>

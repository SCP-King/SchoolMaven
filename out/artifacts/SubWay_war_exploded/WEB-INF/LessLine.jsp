<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.pojo.Station" %>
<%@ page import="org.apache.commons.collections.CollectionUtils" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
<html>
<head>
    <title>最少换乘路线</title>
    <style>
        th{
            border: orange solid 2px;
            font-size: 40pt
        }
        td{
            border: orange solid 2px;
            font-size: 20pt
        }
    </style>
</head>
<body>
<table>
    <%
        List<Station> stations=(List<Station>) request.getAttribute("stations");
        if(stations!=null){
            boolean flag=false;
            List<String> a=new ArrayList<>();
            List<String> b=new ArrayList<>();
            List<String> c=new ArrayList<>();
            List<String> ab=new ArrayList<>();
            List<String> bc=new ArrayList<>();
    %>
    <tr>
        <th>路线站点名</th>
    </tr>
    <tr>
        <td>站点数量:<%=stations.size()%></td>
    </tr>
    <%for(int i=0;i<stations.size();i++){
        a=null;
        b=null;
        c=null;
        flag=false;
        if(i-1>0) a=stations.get(i-1).getLines();
        b=stations.get(i).getLines();
        if(i+1<stations.size()) c=stations.get(i+1).getLines();
        if(a!=null&&c!=null){
            bc= (List<String>) CollectionUtils.intersection(b,c);
            flag=!Collections.disjoint(a,c);
        }
        else flag=true;


    %>
    <tr>
        <td>
            <%=stations.get(i).getStationname()%>
            <%if(!flag){%>
            <%="(换乘"+bc.get(0)+")"%>
            <%}%>
        </td>
    </tr>
    <%}%>
    <%}%>
</table>
</body>
</html>

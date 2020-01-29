<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<jsp:useBean id="sb" class="mybeans.ScheduleDBBean" scope="request"/>
<%!
   ArrayList colname;
   ArrayList data;
   //ArrayList rowdata;
%>
<%
   colname = sb.getColname();
   data = sb.getData();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
timerID = setInterval('clock()',1000);

function clock() {
	document.getElementById("view_clock").innerHTML = getNow();
}

function getNow() {
	var now = new Date();
	var year = now.getFullYear();
	var mon = now.getMonth()+1;
	var day = now.getDate();
	var hour = now.getHours();
	var min = now.getMinutes();
	var sec = now.getSeconds();
	var s = year + "年" + mon + "月" + day + "日" + hour + "時" + min + "分" + sec + "秒";
	return s;
}
</script>
<link
	href="https://fonts.googleapis.com/css?family=Bebas+Neue&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans+JP&display=swap"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css.css" rel="stylesheet">
<title>schedule</title>


</head>
<body>

	<div class="hover_body">
		<header>
			<div class="header_logo">
				<h1>Aグループ共有スケジュール</h1>
			</div>
		</header>

		<div class="month_logo"><h2>&lt;&lt;12月&gt;&gt;</h2></div>
		<p>現在<span id="view_clock"></span>です。</p>
		<p><a href="http://user12:8080/Calendar/inputTOP.html">予定追加はこちら</a></p>


		<table class="table1">
			<tr>
				<th class="sunday">日</th>
				<th>月</th>
				<th>火</th>
				<th>水</th>
				<th>木</th>
				<th>金</th>
				<th class="saturday">土</th>
			</tr>
<% for(int i=0;i <5; i++){%>
<tr>
<%	for(int j=1;j <=7;j++){
	if((i*7+j)>31)break;%>

	<td>
	<%=	i*7+j %><br/>
	<%for(int a=0; a<data.size(); a++){
		ArrayList rowdata = (ArrayList) (data.get(a));
		if(Integer.parseInt(rowdata.get(1).toString())==(i*7+j)){%>
			<p class="a"><%=rowdata.get(0).toString()%> : <%=rowdata.get(2).toString()%></p><br/>
		<%}

	} %>
	</td>

	<%}%>
</tr>

<% } %>

<!--			<tr>
				<td>1<br></td>
				<td>2</td>
				<td>3</td>
				<td>4</td>
				<td>5</td>
				<td>6</td>
				<td>7</td>
			</tr>
			<tr>
				<td>8</td>
				<td>9</td>
				<td>10</td>
				<td>11</td>
				<td>12</td>
				<td>13</td>
				<td>14</td>
			</tr>
			<tr>
				<td>15</td>
				<td>16</td>
				<td>17</td>

				<td>19</td>
				<td>20</td>
				<td>21</td>
			</tr>
			<tr>
				<td>22</td>
				<td>23</td>
				<td>24</td>
				<td>25</td>
				<td>26</td>
				<td>27</td>
				<td>28</td>
			</tr>
			<tr>
				<td>29</td>
				<td>30</td>
				<td>31</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>-->
		</table>

	</div>
</body>
</html>

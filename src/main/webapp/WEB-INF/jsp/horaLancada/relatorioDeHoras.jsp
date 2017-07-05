<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<a href="<c:url value='/horalancada/form' />"></a>
<table class="table table-hover">
	<thead>
		<tr>
			<th>Data</th>
			<th>Horas Normais</th>
			<th>Horas Extras</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${relatorio}" var="r">
			<tr>
				<td>${ r.data.time }</td>
				<td>${ r.horasNormais }</td>
				<td>${ r.horasExtras }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<c:import url="/WEB-INF/jsp/footer.jsp" />

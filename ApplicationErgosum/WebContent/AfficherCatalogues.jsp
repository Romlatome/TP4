<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="includes/header.jsp" />
	<article class="module width_3_quarter">
		<header><h3 class="tabs_involved">Liste du catalogue </h3>
		</header>
		<div class="tab_container">
		
		<div id="tab1" class="tab_content">
	<table class="tablesorter" cellspacing="0">
		<thead>
		<tr>
			<th>Les catalogues</th>
			<th>Quantité affectée</th>
			<th>Quantitée distribuée</th>
			<th>Différence</th>
		</tr>
		</thead>
		<c:forEach items="${catalogueComplet}" var="item">
			<tr>
				<td>${item[0].id}</td>
				<td>${item[1].quantite}</td>
				<td>${item[0].quantiteDistribuee}</td>
				<td>${item[1].quantite-item[0].quantiteDistribuee}</td>
				
			</tr>
		</c:forEach>
	</table>
	</div>
	</div>
	</article>

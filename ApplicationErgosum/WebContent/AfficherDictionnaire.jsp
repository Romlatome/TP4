<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	<jsp:include page="includes/header.jsp" />
	<section id="main" class="column">
	<article class="module width_3_quarter">
		<header><h3 class="tabs_involved">Liste des quantités vendues selon la catégorie </h3>
		</header>
		<div class="tab_container">
		
		<div id="tab1" class="tab_content">
	<table class="tablesorter" cellspacing="0">
		<thead>
		<tr>
			<th>Categorie</th>
			<th>Quantite Distribuee</th>
		</tr>
		</thead>
		<c:forEach items="${listeDico}" var="item">
			<tr>
				<td>${item[0]}</td>
				<td>${item[1]}</td>
				<c:set var ="total" value="${item[1] + total}"/>
				
			</tr>
		</c:forEach>
		<tr>
		<td>Total : ${total}</td>
		</tr>
	</table>
	</div>
	</div>
	</article>
	</section>
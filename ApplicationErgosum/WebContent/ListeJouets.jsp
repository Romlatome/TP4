<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="JavaScript">
	function checkAll(field) {
		for (i = 0; i < field.length; i++) {
			field[i].checked = true;
		}
	}
	function Chargement() {
		var obj = document.getElementById("id_erreur");
		if (obj.value != '')
			alert('Erreur signalée  : "' + obj.value + "'");
	}
</script>
</head>
<body onLoad="Chargement();">
	<jsp:include page="includes/header.jsp" />
	<article class="module width_3_quarter">
		<header><h3 class="tabs_involved">Liste des jouets</h3>
		
		</header>
		<div class="tab_container">
		
			
		<form action="Controleur" method="post" name="frmModif">
		<input type="hidden" name="action" value="supprimerJouet" id="type" />
		<div id="tab1" class="tab_content">
	<table class="tablesorter" cellspacing="0">
		<thead>
		<tr>
			<th><a href="javascript:checkAll(document.deleteForm.id)"></a></th>
			<th>Nom</th>
			<th>Categorie</th>
			<th>Tranche d'âge</th>
			<th>Action</th>
			
		</tr>
		</thead>
		<c:forEach items="${listeJouets}" var="item">
			<tr>
			    <td><input type="checkbox" name="id" value="${item.id}"></td>
				<td>${item.libelle}</td>
				<td>${item.codecateg.libcateg}</td>
				<c:choose>
							<c:when
								test="${item.codetranche.agemin == '2'}">
								<td> 2 à 4 ans</td>
							</c:when>
							<c:when
								test="${item.codetranche.agemin == '4'}">
								<td> 4 à 6 ans</td>
							</c:when>
							<c:when
								test="${item.codetranche.agemin == '6'}">
								<td> 6 à 10 ans</td>
							</c:when>
							<c:when
								test="${item.codetranche.agemin == '10'}">
								<td> 10 à 14 ans</td>
							</c:when>
							<c:otherwise>
								<td> 14 à 16 ans</td>

							</c:otherwise>
				</c:choose>
				<td><a href='Controleur?action=modifierJouet&num=${item.id}'>Modifier</a></td>
				
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
			
					<input type="submit" name="Delete Checked"
                                           value="Effacer les jouets cochés"  class="alt_btn"/>
			
		</tr>
	</table>
	</div>
	</form>
		</div>
		</article>
</body>
</html>

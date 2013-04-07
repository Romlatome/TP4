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
			alert('Erreur signal�e  : "' + obj.value + "'");
	}
</script>
</head>
<body onLoad="Chargement();">
	<jsp:include page="includes/header.jsp" />
	<section id="main" class="column">
	
	<c:if test="${(message == 'ajout')}">
		<h4 class="alert_success">Le jouet a �t� ajout� avec succ�s</h4>
		</c:if>
	
	<c:if test="${(message == 'modif')}">
		<h4 class="alert_success">Le jouet a �t� modifi� avec succ�s</h4>
		</c:if>
		
		<c:if test="${(message == 'suppri')}">
		<h4 class="alert_success">La suppression s'est d�roul�e correctement pour le(s) jouet(s)</h4>
		</c:if>
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
			<th>Tranche d'�ge</th>
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
								<td> 2 � 4 ans</td>
							</c:when>
							<c:when
								test="${item.codetranche.agemin == '4'}">
								<td> 4 � 6 ans</td>
							</c:when>
							<c:when
								test="${item.codetranche.agemin == '6'}">
								<td> 6 � 10 ans</td>
							</c:when>
							<c:when
								test="${item.codetranche.agemin == '10'}">
								<td> 10 � 14 ans</td>
							</c:when>
							<c:otherwise>
								<td> 14 � 16 ans</td>

							</c:otherwise>
				</c:choose>
				<td><a href='Controleur?action=modifierJouet&num=${item.id}'>Modifier</a></td>
				
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
			
					<input type="submit" name="Delete Checked"
                                           value="Effacer les jouets coch�s"  class="alt_btn"/>
			
		</tr>
	</table>
	</div>
	</form>
		</div>
		</article>
		</section>
</body>
</html>

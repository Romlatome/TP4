

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="includes/header.jsp" />

<section id="main" class="column"> <article
		class="module width_full">
	
		
	<form action="Controleur" method="post" name="frmModif">
		<input type="hidden" name="action" value="modificationFinaleJouet" id="type" />
		<br> 
		<header>
			<h3>Modifier un jouet</h3>
		</header>
		<div class="module_content">
		<fieldset>
				<label>Numéro</label> <input type="text" id="numero"
			name="numero" value="${jouet.id}" READONLY> <br> 
			</fieldset>
			<fieldset>
				<label>Libellé</label>  <input
			type="text" id="libelle" name="libelle" value="${jouet.libelle}"> <br>
			</fieldset>
			<fieldset style="width: 48%; float: left; margin-right: 3%;">
				<!-- to make two field float next to one another, adjust values accordingly -->
				<label>Categorie</label> <select name="lstCategorie" style="width: 92%;">
					<c:forEach items="${listeCategorie}" var="listeCategorie">
						<c:choose>
							<c:when
								test="${jouet.codecateg.id == listeCategorie.id}">
								<OPTION SELECTED VALUE="${listeCategorie.id}">${listeCategorie.libcateg}
									</option>
							</c:when>
							<c:otherwise>
								<OPTION VALUE="${listeCategorie.id}">${listeCategorie.libcateg}
									</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</fieldset>
			
		<fieldset style="width: 48%; float: left; margin-right: 3%;">
			<label>Tranche âge</label> <select name="lstTranche"
			style="width: 92%;">
			<c:forEach items="${listeTranche}" var="listeTr">
			<c:choose>
							<c:when
								test="${listeTr.id != jouet.codetranche.id && listeTr.agemin == '2'}">
								<OPTION VALUE="${listeTr.id}">2 à 4 ans</option>
							</c:when>
							<c:when
								test="${listeTr.id == jouet.codetranche.id && listeTr.agemin == '2'}">
								<OPTION SELECTED VALUE="${listeTr.id}">2 à 4 ans</option>
							</c:when>
							<c:when
								test="${listeTr.id != jouet.codetranche.id && listeTr.agemin == '4'}">
								<OPTION VALUE="${listeTr.id}">4 à 6 ans</option>
							</c:when>
							<c:when
								test="${listeTr.id == jouet.codetranche.id && listeTr.agemin == '4'}">
								<OPTION SELECTED VALUE="${listeTr.id}">4 à 6 ans</option>
							</c:when>
							<c:when
								test="${listeTr.id != jouet.codetranche.id && listeTr.agemin == '6'}">
								<OPTION VALUE="${listeTr.id}">6 à 10 ans</option>
							</c:when>
							<c:when
								test="${listeTr.id == jouet.codetranche.id && listeTr.agemin == '6'}">
								<OPTION SELECTED VALUE="${listeTr.id}">6 à 10 ans</option>
							</c:when>
							<c:when
								test="${listeTr.id != jouet.codetranche.id && listeTr.agemin == '10'}">
								<OPTION VALUE="${listeTr.id}">10 à 14 ans</option>
							</c:when>
							<c:when
								test="${listeTr.id == jouet.codetranche.id && listeTr.agemin == '10'}">
								<OPTION SELECTED VALUE="${listeTr.id}">10 à 14 ans</option>
							</c:when>
							<c:when
								test="${listeTr.id != jouet.codetranche.id && listeTr.agemin == '14'}">
								<OPTION VALUE="${listeTr.id}">14 à 16 ans</option>
							</c:when>
							<c:when
								test="${listeTr.id == jouet.codetranche.id && listeTr.agemin == '14'}">
								<OPTION SELECTED VALUE="${listeTr.id}">14 à 16 ans</option>
							</c:when>

				</c:choose>	
				</c:forEach>
		</select>
		</fieldset> 
			</div>
			
			<div class="clear"></div>
		<div class="submit_link">
		
			<input type="submit"  value="Modifier" class="alt_btn">
		</div>
	
	</form>
	</article>
	</section>
</body>
</html>

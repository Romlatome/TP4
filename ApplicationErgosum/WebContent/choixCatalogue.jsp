
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="includes/header.jsp" />
<section id="main" class="column">

	<article class="module width_full">
		<header>
			<h3>Choisir une date</h3>
		</header>
		<div class="module_content">
			<form action="Controleur" method="post" name="frmModif">
				<input type="hidden" name="action"
					value="afficheCatalogue" id="type" /> 
				
				<fieldset style="width: 48%; float: left; margin-right: 3%;">
				<!-- to make two field float next to one another, adjust values accordingly -->
				<label>Annee de debut</label> <select name="lstCatalogueDebut" style="width: 92%;">
					<c:forEach items="${listeCatalogue}" var="liste">
							<OPTION VALUE="${liste.id}">${liste.id}</option>
						</c:forEach>
				</select>
			</fieldset>
			
			<fieldset style="width: 48%; float: left; margin-right: 3%;">
				<!-- to make two field float next to one another, adjust values accordingly -->
				<label>Annee de fin</label> <select name="nbAnnees" style="width: 92%;">
					<c:forEach items="${listeCatalogue}" var="liste">
							<OPTION VALUE="${liste.id}">${liste.id}</option>
						</c:forEach>
				</select>
			</fieldset>
			
			<div class="clear"></div>

			<input type="submit"  value="Afficher" class="alt_btn">
				
			</form>
		</div>
	</article>
</section>
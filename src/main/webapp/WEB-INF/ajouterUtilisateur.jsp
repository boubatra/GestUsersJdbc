<jsp:include page="inc/header.jsp"/>

	<div id="corps">
	<h1 id="titre-principal">Ajout d'un utilisateur</h1>
		<div id="box">
			<form method="post">
				<div class="${status ? 'succes' : 'erreur'}">${statusMessage}</div>
	
				<input id="text" type="text" name="nom" placeholder="Entrez votre nom" value="${utilisateur.nom}"><span class="erreur">${erreurs.nom}</span><br><br>
				<input id="text" type="text" name="prenom" placeholder="Entrez votre prenom" value="${utilisateur.prenom}"><span class="erreur">${erreurs.prenom}</span><br><br>
				<input id="text" type="text" name="login" placeholder="Entrez votre login" value="${utilisateur.login}"><span class="erreur">${erreurs.login}</span><br><br>
				<input id="text" type="password" name="password" placeholder="Entrez votre mot de passe"><span class="erreur">${erreurs.password}</span><br><br>
				<input id="text" type="password" name="passwordBis" placeholder="Re-ecrivez votre mot de passe" ><span class="erreur">${erreurs.passwordBis}</span><br><br>
	
				<input id="button" type="submit" value="Soumettre"><br><br>
			</form>
		</div>
	</div>
	
<%@include file ="inc/footer.jsp" %>
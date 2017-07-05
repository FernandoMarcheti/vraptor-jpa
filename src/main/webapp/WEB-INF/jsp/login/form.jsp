<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="alura" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<alura:validationMessage name="loginInvalido"></alura:validationMessage>
<form action="<c:url value="/login/autentica" />" method="POST">
	<label for="login">Login</label>
	<input type="text" id="login" name="login" value="${login}" class="form-control" />
	
	<label for="login">Senha</label>
	<input type="password" id="senha" name="senha" class="form-control" />
	
	<input type="submit" value="Logar" class="btn" />
</form>

<c:import url="/WEB-INF/jsp/footer.jsp" />
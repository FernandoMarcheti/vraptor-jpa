<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="alura" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<form action="${linkTo[HoraLancadaController].salva(null) }" method="post">
	<label for="data">Data</label>
	<input type="text" id="data" name="horaLancada.data" class="form-control" />

	<label for="horaInicial">Hora Inicial</label>
	<input type="text" id="horaInicial" name="horaLancada.horaInicial" class="form-control" />
	
	<label for="horaFinal">Hora Final</label>
	<input type="text" id="horaFinal" name="horaLancada.horaFinal" class="form-control" />
	
	<input type="submit" value="Salvar Horas" />
</form>

<c:import url="/WEB-INF/jsp/footer.jsp" />
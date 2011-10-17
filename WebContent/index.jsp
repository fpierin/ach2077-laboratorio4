<%@ include file="WEB-INF/jspf/cabecalho.jspf"%>

Pontos geográficos cadastrados:
<br>
<br>
<jsp:useBean id="dao" class="br.usp.each.ach2077.laboratorio4.repositorios.PontoGeograficoDAO" />
<table cellspacing="2" cellpadding="2">
	<thead>
		<tr>
			<th>#</th>
			<th>Id</th>
			<th>Nome</th>
			<th>Graus</th>
			<th>Minutos</th>
			<th>Segundos</th>
		</tr>
	</thead>
	<c:forEach var="pontogeografico" items="${dao.lista}" varStatus="rowCounter">
		<tr>
			<td>${rowCounter.count}</td>		
			<td>${pontogeografico.id}</td>
			<td>${pontogeografico.nome}</td>
			<td>${pontogeografico.graus}</td>
			<td>${pontogeografico.minutos}</td>
			<td>${pontogeografico.segundos}</td>
			<td><a href="mvc?logica=Remover&id=${pontogeografico.id}">remover</a>
			</td>
		</tr>
	</c:forEach>
</table>
<br>
<br>
<a href="<c:url  value="adicionar.jsp"/>"> Adicionar novo ponto geográfico </a>

<%@ include file="WEB-INF/jspf/rodape.jspf"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="icon" href="./assets/img/book-2-fill.svg" type="image/svg" />
<link rel="stylesheet" href="./assets/css/style.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css"
	rel="stylesheet">

<style>
.table-caption {
	font-weight: bold;
	margin-top: 40px;
	margin-bottom: 10px;
}
</style>




<title>Reservas</title>

</head>
<body>
	<main>

		<header class="nav">
			<h3 style="text-decoration: underline;">Cadastro e Edição de
				Reservas:</h3>

		</header>

		<jsp:include page="../../components/menu.jsp">
			<jsp:param name="home" value="../../index_reserva.jsp" />
			<jsp:param name="reserva" value="reserva" />

		</jsp:include>

		<section class="container">
			<div class="p-4">
			
				<a href="./views/reserva/create_reserva.html"
					class="btn btn-primary mb-2 botao1">Nova Reserva</a> 
			

				<div class="table-responsive">
					<a href="./index.html" class="btn btn-secondary mb-2 botao1">Voltar
					para home</a>

					<table
						class="table table-custom   table-hover table-bordered">
						<h4 class="table-caption">Tabela de Reservas</h4>

						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">Origem</th>
								<th scope="col">Destino</th>
								<th scope="col">Data de ida</th>
								<th scope="col">Data de volta</th>
								<th scope="col">Preço</th>
								<th scope="col">Editar</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaReservas}" var="r">
								<tr>
									<td>${r.id_reserva}</td>
									<td>${r.origem}</td>
									<td>${r.destino}</td>
									<td>${r.data_de_ida}</td>
									<td>${r.data_de_volta}</td>
									<td>${r.preco}</td>

									<td>
										<div class="d-flex">
											<a href="reserva-edit?id_reserva=${r.id_reserva}"
												class="mx-1" title="Editar"> <i
												class="ri-file-edit-line"></i>
											</a> <a href="reserva-delete?id=${r.id_reserva}" class="mx-1"
												title="Cancelar"
												onclick="return confirm('Deseja excluir a viagem do id : ${r.id_reserva} e destino : ${r.destino} ?')">
												<i class="ri-delete-bin-2-line"></i>
											</a>
										</div>
									</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</section>
	</main>
	<footer>
		<p>Boa viagem é uma marca registrada de boaviagem S.A | CNPJ: xxxx
			| Todos os direitos reservados. Os preços anunciados neste site ou
			via e-mail promocional podem ser alterados. As fotos contidas nesta
			página são meramente ilustrativas. Este site trabalha 100% em
			criptografia SSL.</p>
	</footer>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"></script>
</body>
</html>


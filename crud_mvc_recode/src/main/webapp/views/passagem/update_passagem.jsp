<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Atualizar Reserva</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<link rel="stylesheet" href="./assets/css/style9.css">
 

<script src="./assets/js/updatepassagem.js"></script>


</head>

<body style="background-color: rgb(205, 227, 233);">
	<nav>
		<div>

			<jsp:include page="../../components/menu.jsp">
				<jsp:param name="home" value="../../index_passagem.jsp" />
				<jsp:param name="passagem" value="passagem" />

			</jsp:include>
		</div>
	</nav>

	<main class="container mt-5">
		<div class="row">
			<div class="col-12 col-md-8 col-lg-6 mx-auto">
				<div class="card bg-light">
					<div class="card bg-light">
						<article class="card-body mx-auto" style="max-width: 400px;">

						 

							<h4 class="card-title mt-3 text-left">Atualizar passagem</h4>

							 <form action="./passagem-update" onsubmit="return updatepassagem();">
								<div class="form-group">
									<label for="id_passagem"><strong>ID:</strong></label> <input
										type="text" id="id_passagem" name="id_passagem"
										class="form-control" value="${passagem.id_passagem}" readonly />
								</div>

								<div class="form-group">
									<label for="destino"><strong>Destino:</strong></label> <input
										type="text" id="destino" name="destino" class="form-control"
										value="${passagem.destino}" />
								</div>



								<div class="form-group">
									<label for="data_de_ida"><strong>Data de ida:</strong></label>
									<input type="text" id="data-de-ida" name="data_de_ida"
										class="form-control" value="${passagem.data_de_ida}" />
								</div>


								<div class="form-group">
									<label for="data-de-volta"><strong>Data de
											volta:</strong></label> <input type="text" id="data_de_volta"
										name="data_de_volta" class="form-control"
										value="${passagem.data_de_volta}" />
								</div>

								<div class="form-group">
									<label for="empresa"><strong>empresa:</strong></label> <input
										type="text" id="empresa" name="empresa" class="form-control"
										value="${passagem.empresa}" />
								</div>

								<div class="form-group">
									<label for="horario_da_ida"><strong>Horario da ida:</strong></label>
									<input type="text" id="horario-da-ida" name="horario_da_ida"
										class="form-control" value="${passagem.horario_da_ida}" />
								</div>


								<div class="form-group">
									<label for="horario_da_ida"><strong>Horario da volta:</strong></label>
									<input type="text" id="horario-da-volta" name="horario_da_volta"
										class="form-control" value="${passagem.horario_da_volta}" />
								</div>


								<p></p>
								<button type="submit" class="btn btn-primary">Enviar</button>
								<a href="./passagem" class="btn btn-danger"
									style="margin-left: 10px">Cancelar</a>
							</form>

						</article>
					</div>
				</div>
			</div>
	</main>

</body>
<footer>
	<p>Boa viagem é uma marca registrada de boaviagem S.A | CNPJ: xxxx
		| Todos os direitos reservados. Os preços anunciados neste site ou via
		e-mail promocional podem ser alterados. As fotos contidas nesta página
		são meramente ilustrativas. Este site trabalha 100% em criptografia
		SSL.</p>
</footer>

</html>
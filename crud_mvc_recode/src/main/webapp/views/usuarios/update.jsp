<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Atualizar Usuario</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<link rel="stylesheet" href="./assets/css/style9.css">
<script src="/crud_mvc_recode/assets/js/updateusuario.js"></script>

</head>

<body style="background-color: rgb(205, 227, 233);">
	<nav>
		<div>
			<jsp:include page="../../components/menu.jsp">
				<jsp:param name="home" value="../../index.jsp" />
				<jsp:param name="usuarios" value="usuario" />

			</jsp:include>
		</div>
	</nav>

	<main class="container mt-5">
		<div class="row">
			<div class="col-12 col-md-8 col-lg-6 mx-auto">
				<div class="card bg-light">
					<div class="card bg-light">
						<article class="card-body mx-auto" style="max-width: 400px;">

							 

							<h4 class="card-title mt-3 text-left">Atualizar conta</h4>

							<form action="./usuario-update" onsubmit="return updateusuario();" >
								<div class="form-group">
									<label for="id_cliente"><strong>ID:</strong></label> <input
										type="text" id="id_cliente" name="id_cliente"
										class="form-control" value="${cliente.id_cliente}" readonly />
								</div>

								<div class="form-group">
									<label for="NomeCompleto"><strong>Nome:</strong></label> <input
										type="text" id="NomeCompleto" name="NomeCompleto"
										class="form-control" placeholder="Nome completo"
										value="${cliente.nomeCompleto}" />
								</div>

								<div class="form-group">
									<label for="endereco"><strong>Endereço:</strong></label> <input
										type="text" id="endereco" name="endereco" class="form-control"
										placeholder="Digite o endereço" value="${cliente.endereco}" />
								</div>

								<div class="form-group">
									<label for="cep"><strong>Cep:</strong></label> <input
										type="text" id="cep" name="cep" class="form-control"
										placeholder="Digite o cep" value="${cliente.cep}" />
								</div>

								<div class="form-group">
									<label for="cpf"><strong>Cpf:</strong></label> <input
										type="text" id="cpf" name="cpf" class="form-control"
										placeholder="Digite o seu cpf" value="${cliente.cpf}" />
								</div>

								<div class="form-group">
									<label for="e_mail"><strong>E-mail (Ex: usuario@email.com)</strong></label> <input
										type="text" id="e_mail" name="e_mail" class="form-control"
										placeholder="Digite o seu e-mail" value="${cliente.e_mail}" />
								</div>

								<div class="form-group">
									<label for="senha"><strong>Senha (6 digitos):</strong></label> <input
										type="password" id="senha" name="senha" class="form-control"
										placeholder="Digite a sua senha com 6 dígitos"
										value="${cliente.senha}" />
								</div>

								<div class="form-group">
									<label for="telefone"><strong>Telefone:</strong></label> <input
										type="text" id="telefone" name="telefone" class="form-control"
										placeholder="Digite o seu telefone (máximo de 10 dígitos)"
										value="${cliente.telefone}" />
								</div>

								<p></p>
								<button type="submit" class="btn btn-primary">Enviar</button>
								<a href="./usuario" class="btn btn-danger"
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
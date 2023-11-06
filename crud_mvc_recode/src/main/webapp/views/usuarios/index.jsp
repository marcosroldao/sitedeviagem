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



<title>Usuarios</title>
</head>
<body>
	<main>
		<header class="nav">
			<h3 style="text-decoration: underline;">Cadastro e edição de
				Usuários:</h3>

		</header>

		<jsp:include page="../../components/menu.jsp">
			<jsp:param name="home" value="../../index.jsp" />
			<jsp:param name="usuarios" value="usuario" />

		</jsp:include>

		<section class="container">
			<div class="p-4">
			 <a href="./index.html" class="btn btn-secondary mb-2 botao1">Voltar para home</a>
			

				<div class="table-responsive">
					<a href="./views/usuarios/create.html"
					class="btn btn-primary mb-2 botao1">Novo Usuário</a>
					<table
						class="table table-custom   table-hover table-bordered">
						<h4 class="table-caption">Tabela de Usuários</h4>

						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">Nome</th>
								<th scope="col">Endereço</th>
								<th scope="col">CEP</th>
								<th scope="col">CPF</th>
								<th scope="col">E-mail</th>
								<th scope="col">Senha</th>
								<th scope="col">Telefone</th>
								<th scope="col">Data de Cadastro</th>
								<th scope="col">Editar/Excluir</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaUsuarios}" var="u">
								<tr>
									<td>${u.id_cliente}</td>
									<td>${u.nomeCompleto}</td>
									<td>${u.endereco}</td>
									<td>${u.cep}</td>
									<td>${u.cpf}</td>
									<td>${u.e_mail}</td>
									<td>${u.senha}</td>
									<td>${u.telefone}</td>
									<td>${u.dataCadastro}</td>

									<td>
										<div class="d-flex">
											<a href="usuario-edit?id_cliente=${u.id_cliente}"
												class="mx-1" title="Editar"> <i
												class="ri-file-edit-line"></i>
											</a> <a href="usuario-delete?id=${u.id_cliente}" class="mx-1"
												title="Cancelar"
												onclick="return confirm('Deseja excluir o usuário ${u.nomeCompleto}?')">
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


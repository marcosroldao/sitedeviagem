 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="stylesheet" href="assets/css/style10.css">

<!-- Navegação (nav) sem o link "Voltar" -->
<ul hidden >
    <a   id="brand0" href="index.jsp"  ></a>
    <li  >
        <a   href="<%=request.getParameter("usuarios")%>" >Usuarios  </a>
    </li>
    <li  >
        <a   href="<%=request.getParameter("reserva")%>" style="color: red" >Reserva </a>
    </li>
    <li  >
        <a   href="<%=request.getParameter("passagem")%>" style="color: red" > Passagens</a>
    </li>
</ul>


<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="gestao_for.dominio.Fornecedor"%>
        <%@ page import="gestao_for.dominio.Contato"%>
            <%@ page import="gestao_for.dominio.Endereco"%>
                <%@ page import="java.util.ArrayList"%>
                    <%
ArrayList<Fornecedor> lista = (ArrayList<Fornecedor>) request.getAttribute("fornecedor");
	
%>
                        <!DOCTYPE html>
                        <html>

                        <head>
                            <meta charset="utf-8">
                            <link rel="stylesheet" href="biblioteca/css/bootstrap.min.css">
                            <link rel="stylesheet" href="biblioteca/css/iziToast.min.css">
                            <link rel="stylesheet" href="biblioteca/css/font-awesome.min.css">
                            <link rel="stylesheet" href="style.css">
                            <link rel="icon" href="imagens/users.png">
                            <script src="biblioteca/js/jquery-3.6.0.min.js"></script>
                            <script src="biblioteca/js/iziToast.min.js"></script>
                            <script src="biblioteca/js/bootstrap.bundle.min.js"></script>
                            <script src="scripts/script.js"></script>
                            <title>Lista de fornecedores</title>
                        </head>

                        <body>
                            <div class="container">
                                <h1>Fornecedores Cadastrados</h1>
                                <a href="novo_for.html" class="btn btn-success">Cadastrar novo fornecedor</a>
                                <table id="tabela">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th style="width: 180px;">Nome Fantasia</th>
                                            <th>Razão Social</th>
                                            <th>CNPJ</th>
                                            <th style="width: 130px;">Contato</th>
                                            <th>E-mail</th>
                                            <th colspan="2" style="width: 180px;">Opções</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
			for (int i = 0; i < lista.size(); i++) {
			%>
                                            <tr>
                                                <td>
                                                    <%=lista.get(i).getId()%>
                                                </td>
                                                <td>
                                                    <%=lista.get(i).getNmFantasia() %>
                                                </td>
                                                <td>
                                                    <%=lista.get(i).getRzSocial() %>
                                                </td>
                                                <td>
                                                    <%=lista.get(i).getCnpj() %>
                                                </td>
                                                <td>
                                                    <%=lista.get(i).getContato().getNome() %>
                                                </td>
                                                <td>
                                                    <%=lista.get(i).getEmail() %>
                                                </td>
                                                <td>
                                                    <!--  <form action="EditarFornecedor" method="get">
						<input type="hidden" name="id_for" value="<%=lista.get(i).getId()%>">
						<input style="margin-right: 10px;" class="btn btn-info" type="submit" id_for="<%=lista.get(i).getId() %>" value="Editar" name="operacao">
					</form>  -->
                                                    <a href="EditarFornecedor?id_for=<%=lista.get(i).getId() %>&operacao=Editar" class="btn btn-info">Editar</a>
                                                </td>
                                                <td>
                                                    <!--<form action="ExcluirFornecedor" method="get">
						<input type="hidden" name="id_for" value="<%=lista.get(i).getId()%>">						
						<input class="btn btn-danger" id="apagar_fornecedor" type="submit" id_for="<%=lista.get(i).getId() %>" id_for="<%=lista.get(i).getId() %>" value="Excluir" name="operacao">
					</form>-->
                                                    <a href="ExcluirFornecedor?id_for=<%=lista.get(i).getId() %>&operacao=Excluir" id="apagar_fornecedor" class="btn btn-danger">Excluir</a>
                                                </td>
                                            </tr>
                                            <%
			}
			%>
                                    </tbody>

                                </table>
                            </div>
                        </body>

                        </html>
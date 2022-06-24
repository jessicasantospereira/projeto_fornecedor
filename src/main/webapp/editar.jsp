<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

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
        <title>Editar cadastro</title>
    </head>

    <body>
        <div class="container">
            <form action="AlterarFornecedor" method="get">
                <div class="row">
                	<div class="col-md-2">
                        <label for="razao_social">ID: </label>
                        <input type="text" class="col-md-12" id="id_for" name="id_for" value="<%out.print(request.getAttribute("id_for")); %>" readonly>

                    </div>
                    <div class="col-md-2">
                        <label for="status">Status: </label>
                        <select name="status" class="col-md-12" id="status">
                        <option value="rascunho">Rascunho</option>
                        <option value="ativo">Ativo</option>
                        <option value="inativo">Inativo</option>
                    </select>
                    </div>
                </div>
                <hr>
                <div class="row align-items-start">
                    <div class="col-md-4">
                        <label for="razao_social">Razão social: </label>
                        <input type="text" class="col-md-12" id="razao_social" name="razao_social" value="<%out.print(request.getAttribute("razao_social")); %>">

                    </div>
                    <div class="col-md-4">
                        <label for="nome_fantasia">Nome fantasia: </label>
                        <input type="text" class="col-md-12" id="nome_fantasia" name="nome_fantasia" value="<%out.print(request.getAttribute("nome_fantasia")); %>">

                    </div>
                    <div class="col-md-2">
                        <label for="tipo_empresa">Tipo empresa: </label>
                        <select name="tipo_empresa" class="col-md-12" id="tipo_empresa">
                        <option value="matriz">Matriz</option>
                        <option value="filial">Filial</option>
                    </select>
                    </div>
                    <div class="col-md-2">
                        <label for="tipo_fornecimento">Tipo de fornecimento: </label>
                        <select name="tipo_fornecimento" class="col-md-12" id="tipo_fornecimento">
                        <option value="servico">Serviço</option>
                        <option value="venda">Venda</option>
                    </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <label for="cnae">CNPJ </label>
                        <input type="text" class="col-md-12" id="cnpj" name="cnpj" value="<%out.print(request.getAttribute("cnpj")); %>">

                    </div>
                    <div class="col-md-2">
                        <label for="cnae">CNAE </label>
                        <input type="text" class="col-md-12" id="cnae" name="cnae" value="<%out.print(request.getAttribute("cnae")); %>">

                    </div>
                    <div class="col-md-4">
                        <label for="imunicipal">Inscrição municipal: </label>
                        <input type="text" class="col-md-12" id="imunicipal" name="imunicipal" value="<%out.print(request.getAttribute("imunicipal")); %>">

                    </div>
                    <div class="col-md-4">
                        <label for="iestadual">Inscrição estadual: </label>
                        <input type="text" class="col-md-12" id="iestadual" name="iestadual" value="<%out.print(request.getAttribute("iestadual")); %>">
                    </div>
                </div>
                <hr>
                <div class="row align-items-start">
                    <p><strong>Endereço</strong></p>
                    <div class="col-md-2" style="display:none;">
                        <input type="hidden" class="col-md-12" id="id_end" name="id_end" value="<%out.print(request.getAttribute("id_end")); %>">

                    </div>
                    <div class="col-md-4">
                        <label class="col-form-label" for="tipo_endereco">Tipo Endereco: </label>
                        <input class="col-md-12" type="text" maxlength="200" name="tipo_endereco" placeholder="Galpão, Edíficio, Sala comercial, etc." value="<%out.print(request.getAttribute("tipo_endereco")); %>">
                    </div>
                    <div class="col-md-4">

                        <label class="col-form-label" for="tipo_logradouro">Tipo Logradouro: </label>
                        <input class="col-md-12" type="text" maxlength="200" name="tipo_logradouro" value="<%out.print(request.getAttribute("tipo_logradouro")); %>">
                    </div>
                    <div class="col-md-4">

                        <label class="col-form-label" for="logradouro">Logradouro: </label>
                        <input class="col-md-12" type="text" maxlength="200" name="logradouro_empresa" value="<%out.print(request.getAttribute("logradouro_empresa")); %>">
                    </div>
                    <div class="col-md-4">
                        <label class="col-form-label" for="numero">Numero: </label>
                        <input class="col-md-12" type="number" name="numero_empresa" value="<%out.print(request.getAttribute("numero_empresa")); %>">
                    </div>
                    <div class="col-md-4">
                        <label class="col-form-label" for="bairro">Bairro: </label>
                        <input class="col-md-12" type="text" maxlength="200" name="bairro_empresa" value="<%out.print(request.getAttribute("bairro_empresa")); %>">
                    </div>
                    <div class="col-md-4">
                        <label class="col-form-label" for="complemento">Complemento: </label>
                        <input class="col-md-12" type="text" maxlength="200" name="complemento_empresa" value="<%out.print(request.getAttribute("complemento_empresa")); %>">
                    </div>
                    <div class="col-md-4">
                        <label class="col-form-label" for="cep">CEP: </label>
                        <input class="col-md-12" type="text" name="cep_empresa" value="<%out.print(request.getAttribute("cep_empresa")); %>">
                    </div>
                    <div class="col-md-4">
                        <label class="col-form-label" for="cidade">Cidade: </label>
                        <input class="col-md-12" type="text" name="cidade_empresa" value="<%out.print(request.getAttribute("cidade_empresa")); %>">
                    </div>
                    <div class="col-md-4">
                        <label class="col-form-label" for="estado">Estado: </label>
                        <input class="col-md-12" type="text" name="estado_empresa" value="<%out.print(request.getAttribute("estado_empresa")); %>">
                    </div>
                    <div class="col-md-4">
                        <label class="col-form-label" for="pais">Pais: </label>
                        <input class="col-md-12" type="text" name="pais_empresa" value="<%out.print(request.getAttribute("pais_empresa")); %>">
                    </div>

                </div>
                <hr>
                <div class="row align-items-start">
                    <p><strong>Contato</strong></p>
                    <div class="col-md-2" style="display:none;">
                        <input type="hidden" class="col-md-12" id="id_con" name="id_con" value="<%out.print(request.getAttribute("id_con")); %>">

                    </div>
                    <div class="col-md-4">
                        <label class="col-form-label" for="nome_contato">Nome: </label>
                        <input class="col-md-12" type="text" maxlength="200" name="nome_contato" value="<%out.print(request.getAttribute("nome_contato")); %>">
                    </div>
                    <div class="col-md-4">

                        <label class="col-form-label" for="email">E-mail: </label>
                        <input class="col-md-12" type="text" maxlength="200" name="email" value="<%out.print(request.getAttribute("email")); %>">
                    </div>
                    <div class="col-md-4">

                        <label class="col-form-label" for="departamento">Departamento: </label>
                        <input class="col-md-12" type="text" maxlength="200" name="departamento" value="<%out.print(request.getAttribute("departamento")); %>">
                    </div>
                    <div class="col-md-4">

                        <label class="col-form-label" for="tipo_tel">Tipo telefone: </label>
                        <input class="col-md-12" type="text" maxlength="200" name="tipo_tel" placeholder="Comercial, Celular, etc" value="<%out.print(request.getAttribute("tipo_tel")); %>">
                    </div>
                    <div class="col-md-4" style="padding-top: 35px;">
                        <label class="col-form-label" for="telefone">Telefone: </label>
                        <input class="col-md-2" type="text" name="ddd" placeholder="(DDD)" value="<%out.print(request.getAttribute("ddd")); %>">
                        <input class="col-md-2" type="text" name="ddi" placeholder="(DDI)" value="<%out.print(request.getAttribute("ddi")); %>">
                        <input class="col-md-4" type="text" name="telefone" placeholder="99999-9999" value="<%out.print(request.getAttribute("telefone")); %>">
                    </div>
                    <div class="col-md-4">
                        <label class="col-form-label" for="ramal">Ramal: </label>
                        <input class="col-md-12" type="text" maxlength="200" name="ramal" value="<%out.print(request.getAttribute("ramal")); %>">
                    </div>
                    <div class="col-md-4">
                        <label class="col-form-label" for="usuario">Usuário: </label>
                        <input class="col-md-12" type="text" maxlength="200" name="usuario" value="<%out.print(request.getAttribute("usuario")); %>">
                    </div>
                    <div class="col-md-4">
                        <label class="col-form-label" for="ramal">Senha: </label>
                        <input class="col-md-12" type="password" maxlength="10" name="senha" value="<%out.print(request.getAttribute("senha")); %>">
                    </div>



                </div>
                <hr>
                <div class="row">
                    <p>
                        <a class="btn btn-warning" href="main">Cancelar</a>
                        <input class="btn btn-info" type="submit" id="editar_fornecedor" value="Alterar" name="operacao">
                    </p>
                </div>
            </form>
        </div>
    </body>

    </html>
package br.com.crud.model;

import java.util.Date;

 
public class Cliente {

	

private int id_cliente;

private String NomeCompleto;

private String endereco;

private String cep;

private String cpf;

private String e_mail;

private String senha;

private String telefone;

private Date dataCadastro;

public int getId_cliente() {
	return id_cliente;
}

public void setId_cliente(int id_cliente) {
	this.id_cliente = id_cliente;
}

public String getNomeCompleto() {
	return NomeCompleto;
}

public void setNomeCompleto(String nomeCompleto) {
	NomeCompleto = nomeCompleto;
}

public String getEndereco() {
	return endereco;
}

public void setEndereco(String endereco) {
	this.endereco = endereco;
}

public String getCep() {
	return cep;
}

public void setCep(String cep) {
	this.cep = cep;
}

public String getCpf() {
	return cpf;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}

public String getE_mail() {
	return e_mail;
}

public void setE_mail(String e_mail) {
	this.e_mail = e_mail;
}

public String getSenha() {
	return senha;
}

public void setSenha(String senha) {
	this.senha = senha;
}

public String getTelefone() {
	return telefone;
}

public void setTelefone(String telefone) {
	this.telefone = telefone;
}

public Date getdataCadastro() {
	return dataCadastro;

}

public void setdataCadastro(Date dataCadastro) {

	this.dataCadastro = dataCadastro;

}

	
}





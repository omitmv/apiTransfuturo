package com.transfuturo.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados necessários para o login do usuário")
public class UsuarioLoginRequest {
    @Schema(description = "Login do usuário")
    private String login;
    @Schema(description = "Senha do usuário")
    private String senha;

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}

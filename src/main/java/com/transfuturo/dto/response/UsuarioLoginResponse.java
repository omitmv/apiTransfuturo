package com.transfuturo.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados de resposta para autenticação de usuários")
public class UsuarioLoginResponse {
    @Schema(description = "Indica se o usuário está autenticado")
    private boolean autenticado;
    @Schema(description = "Mensagem de resposta")
    private String mensagem;
    @Schema(description = "Token de autenticação")
    private String token;

    public UsuarioLoginResponse() {}

    public UsuarioLoginResponse(boolean autenticado, String mensagem) {
        this.autenticado = autenticado;
        this.mensagem = mensagem;
    }

    public UsuarioLoginResponse(boolean autenticado, String mensagem, String token) {
        this.autenticado = autenticado;
        this.mensagem = mensagem;
        this.token = token;
    }

    public boolean isAutenticado() { return autenticado; }
    public void setAutenticado(boolean autenticado) { this.autenticado = autenticado; }
    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
}

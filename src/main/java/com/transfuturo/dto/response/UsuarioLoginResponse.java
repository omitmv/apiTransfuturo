package com.transfuturo.dto.response;

public class UsuarioLoginResponse {
    private boolean autenticado;
    private String mensagem;
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

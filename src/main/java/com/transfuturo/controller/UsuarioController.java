package com.transfuturo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transfuturo.config.common.PasswordEncryptor;
import com.transfuturo.config.security.JwtUtil;
import com.transfuturo.dto.request.UsuarioLoginRequest;
import com.transfuturo.dto.response.UsuarioLoginResponse;
import com.transfuturo.repository.UsuarioRepository;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Controller para gerenciamento de usuários")
@RestController
@RequestMapping("/v1/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Schema(description = "Endpoint para autenticação de usuários, para utilização da api")
    @PostMapping("/login")
    public ResponseEntity<UsuarioLoginResponse> login(@RequestBody UsuarioLoginRequest request) {
        String senhaCriptografada = PasswordEncryptor.encryptMD5(request.getSenha());
        Map<String, Object> result = usuarioRepository.autenticarUsuario(request.getLogin(), senhaCriptografada);
        boolean autenticado = false;
        String mensagem = "Usuário ou senha inválidos.";
        String token = null;
        if (result != null && result.get("autenticado") != null && ((Number)result.get("autenticado")).intValue() == 1) {
            autenticado = true;
            mensagem = "Login realizado com sucesso.";
            token = jwtUtil.generateToken(request.getLogin());
        }
        return ResponseEntity.ok(new UsuarioLoginResponse(autenticado, mensagem, token));
    }
}

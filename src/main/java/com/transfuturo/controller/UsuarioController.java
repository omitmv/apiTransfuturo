package com.transfuturo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transfuturo.dto.request.UsuarioLoginRequest;
import com.transfuturo.dto.response.UsuarioLoginResponse;
import com.transfuturo.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<UsuarioLoginResponse> login(@RequestBody UsuarioLoginRequest request) {
        java.util.Map<String, Object> result = usuarioRepository.autenticarUsuario(request.getUsername(), request.getPassword());
        boolean autenticado = false;
        String mensagem = "Usuário ou senha inválidos.";
        if (result != null && result.get("autenticado") != null && ((Number)result.get("autenticado")).intValue() == 1) {
            autenticado = true;
            mensagem = "Login realizado com sucesso.";
        }
        return ResponseEntity.ok(new UsuarioLoginResponse(autenticado, mensagem));
    }
}

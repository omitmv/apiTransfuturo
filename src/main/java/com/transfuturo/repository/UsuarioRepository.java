package com.transfuturo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transfuturo.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @org.springframework.data.jpa.repository.Query(value = "SELECT CASE WHEN a.cd_usuario > 0 THEN 1 ELSE 0 END AS autenticado, '' AS mensagem FROM trans.tbctrusuario a WHERE login = ?1 AND senha = ?2", nativeQuery = true)
    java.util.Map<String, Object> autenticarUsuario(String login, String senha);
}

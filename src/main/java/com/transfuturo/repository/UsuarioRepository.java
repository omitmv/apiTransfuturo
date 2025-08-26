package com.transfuturo.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.transfuturo.entity.Usuario;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Repositório para gerenciamento de usuários")
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query(value = "SELECT CASE WHEN a.cd_usuario > 0 THEN 1 ELSE 0 END AS autenticado, '' AS mensagem FROM trans.tbctrusuario a WHERE login = ?1 AND senha = ?2", nativeQuery = true)
    Map<String, Object> autenticarUsuario(String login, String senha);
}

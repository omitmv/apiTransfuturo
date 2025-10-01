package com.transfuturo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transfuturo.entity.Funcionario;
import com.transfuturo.service.FuncionarioService;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Controller para gerenciamento de funcionários")
@RestController
@RequestMapping("/v1/funcionario")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService funcionarioService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<Funcionario>> listarFuncionarios() {
        List<Funcionario> funcionarios = funcionarioService.listarFuncionarios();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/listar-aniversariantes")
    public ResponseEntity<List<Funcionario>> listarFuncionariosAniversariantes() {
        List<Funcionario> funcionarios = funcionarioService.listarFuncionariosAniversariantes();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/listar-aniversariantes-admissao")
    public ResponseEntity<List<Funcionario>> listarFuncionariosAniversariantesAdmissao() {
        List<Funcionario> funcionarios = funcionarioService.listarFuncionariosAniversariantesAdmissao();
        return ResponseEntity.ok(funcionarios);
    }
}

package com.transfuturo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "funcionario")
@Getter
@Setter
public class Funcionario {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_funcionario")
  private Long idFuncionario;
  
  @Column(name = "nome_empresa")
  private String nomeEmpresa;
  
  @Column(name = "nome_funcionario")
  private String nomeFuncionario;
  
  @Column(name = "funcao")
  private String funcao;
  
  @Column(name = "data_admissao")
  private LocalDate dataAdmissao;
  
  @Column(name = "data_nascimento")
  private LocalDate dataNascimento;
}

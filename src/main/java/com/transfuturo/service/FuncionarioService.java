package com.transfuturo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transfuturo.entity.Funcionario;
import com.transfuturo.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public List<Funcionario> listarFuncionarios() {
        List<Object[]> resultados = repository.buscarFuncionarios();
        List<Funcionario> lista = new ArrayList<>();

        for (Object[] row : resultados) {
            Funcionario funcionario = new Funcionario();
            funcionario.setNomeEmpresa((String) row[0]);
            funcionario.setNomeFuncionario((String) row[1]);
            funcionario.setFuncao((String) row[2]);
            String dataAdmissaoStr = (String) row[3];
            String dataNascimentoStr = (String) row[4];

            if (dataAdmissaoStr != null && !dataAdmissaoStr.isEmpty()) {
                funcionario.setDataAdmissao(LocalDate.parse(dataAdmissaoStr, formatter));
            }
            
            if (dataNascimentoStr != null && !dataNascimentoStr.isEmpty()) {
                funcionario.setDataNascimento(LocalDate.parse(dataNascimentoStr, formatter));
            }
            
            funcionario.setIdFuncionario(((Number) row[5]).longValue());
            lista.add(funcionario);
        }

        return lista;
    }
}

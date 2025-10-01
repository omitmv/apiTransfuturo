package com.transfuturo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.transfuturo.entity.Funcionario;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Repositório para gerenciamento de funcionários")
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
  @Query(value = """
        SELECT 
            c.rsocialempresa AS empresa,
            a.nomecompletofunc AS nome,
            a.descfuncaocompleta AS funcao,
            TO_CHAR(a.dtadmfunc, 'DD/MM/YYYY') AS admissao,
            TO_CHAR(a.dtnasctofunc, 'DD/MM/YYYY') AS nascimento,
            a.codintfunc AS id_funcionario
        FROM GLOBUS.vw_funcionarios a
        LEFT JOIN GLOBUS.ctr_cademp b ON b.codigoempresa = a.codigoempresa
        LEFT JOIN GLOBUS.ctr_empautorizadas c ON c.codintempaut = b.codintempaut
        WHERE a.codigoempresa < 99
        AND a.situacaofunc NOT IN ('D')
        ORDER BY a.codigoempresa
        """, nativeQuery = true)
  List<Object[]> buscarFuncionarios();

  @Query(value = """
        SELECT 
            c.rsocialempresa AS empresa,
            a.nomecompletofunc AS nome,
            a.descfuncaocompleta AS funcao,
            TO_CHAR(a.dtadmfunc, 'DD/MM/YYYY') AS admissao,
            TO_CHAR(a.dtnasctofunc, 'DD/MM/YYYY') AS nascimento,
            a.codintfunc AS id_funcionario
        FROM GLOBUS.vw_funcionarios a
        LEFT JOIN GLOBUS.ctr_cademp b ON b.codigoempresa = a.codigoempresa
        LEFT JOIN GLOBUS.ctr_empautorizadas c ON c.codintempaut = b.codintempaut
        WHERE a.codigoempresa < 99
        AND a.situacaofunc NOT IN ('D')
        AND TO_CHAR( a.dtnasctofunc, 'MM' ) = TO_CHAR(SYSDATE, 'MM')
        ORDER BY a.codigoempresa
        """, nativeQuery = true)
  List<Object[]> buscarFuncionariosAniversariantes();

  @Query(value = """
        SELECT 
            c.rsocialempresa AS empresa,
            a.nomecompletofunc AS nome,
            a.descfuncaocompleta AS funcao,
            TO_CHAR(a.dtadmfunc, 'DD/MM/YYYY') AS admissao,
            TO_CHAR(a.dtnasctofunc, 'DD/MM/YYYY') AS nascimento,
            a.codintfunc AS id_funcionario
        FROM GLOBUS.vw_funcionarios a
        LEFT JOIN GLOBUS.ctr_cademp b ON b.codigoempresa = a.codigoempresa
        LEFT JOIN GLOBUS.ctr_empautorizadas c ON c.codintempaut = b.codintempaut
        WHERE a.codigoempresa < 99
        AND a.situacaofunc NOT IN ('D')
        AND TO_CHAR( a.dtadmfunc, 'MM' ) = TO_CHAR(SYSDATE, 'MM')
        ORDER BY a.codigoempresa
        """, nativeQuery = true)
  List<Object[]> buscarFuncionariosAniversariantesAdmissao();
}

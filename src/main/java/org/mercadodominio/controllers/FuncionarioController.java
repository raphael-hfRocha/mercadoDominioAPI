package org.mercadodominio.controllers;

import org.mercadodominio.models.Funcionario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    private List<Funcionario> listaFuncionarios = new ArrayList<>();

    @GetMapping
    public List<Funcionario> getAllUFuncionarios() {
        return listaFuncionarios;
    }

    @PostMapping
    public void addFuncionario(Funcionario funcionario) {
        listaFuncionarios.add(funcionario);
    }

    @PutMapping("/{FUNCIONARIO_ID}")
    public ResponseEntity<Funcionario> editFuncionario(@PathVariable("FUNCIONARIO_ID") int id, @RequestBody Funcionario funcionarioAtualizado) {
        listaFuncionarios = listaFuncionarios.stream().filter(f -> f.getFuncionarioId() == id).collect(Collectors.toList());
        for (Funcionario u : listaFuncionarios) {
                u.setFuncionarioNome(funcionarioAtualizado.getFuncionarioNome());
                u.setFuncionarioEmail(funcionarioAtualizado.getFuncionarioEmail());
                u.setFuncionarioIdade(funcionarioAtualizado.getFuncionarioIdade());
                return ResponseEntity.ok(u);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public void deleteFuncionario(int id) {
        listaFuncionarios.removeIf(f -> f.getFuncionarioId() == id);
    }

}

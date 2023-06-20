package com.juliano.br.produtos.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.juliano.br.produtos.modelo.ProdutoModelo;
import com.juliano.br.produtos.modelo.RespostaModelo;
import com.juliano.br.produtos.servico.Produtoservico;

@RestController
@CrossOrigin(origins = "*")
public class ProdutoControle {

    @Autowired
    private Produtoservico ps;

    @GetMapping("/listar")
    public Iterable<ProdutoModelo>listar(){
        return ps.listar(); 
    }

    @GetMapping("/")
    public String rota(){
        return "Api de produtos";
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoModelo pm){
        return ps.cadastrarAlterar(pm,"cadastrar");
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody ProdutoModelo pm){
     return ps.cadastrarAlterar(pm,"alterar");
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable Long id){
        return ps.remover(id);
    }
    

}

package com.juliano.br.produtos.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.juliano.br.produtos.modelo.ProdutoModelo;
import com.juliano.br.produtos.modelo.RespostaModelo;
import com.juliano.br.produtos.repositorio.ProdutoRepositorio;


@Service
public class Produtoservico {
    
    @Autowired
    private ProdutoRepositorio pr;
    @Autowired
    private RespostaModelo rm;

    // metodo para listar produtos

    public Iterable<ProdutoModelo> listar(){
        return pr.findAll();
    }

    // cadastrar Produtos ou alterar

    public ResponseEntity<?> cadastrarAlterar(ProdutoModelo pm,String acao){
        if(pm.getNome().equals("")){
            rm.setMsg("Nome do Produto não encontrado");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if(pm.getMarca().equals("")){
            rm.setMsg("Marca não encontrada");
            return new ResponseEntity<RespostaModelo>(rm,HttpStatus.BAD_REQUEST);
        }else{
            if(acao.equals("cadastrar")){
                return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.CREATED); 
            
            }else{
                return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.OK);  
            }
        }
            
    }

    // metodo para remover produtos
    public ResponseEntity<RespostaModelo>remover(Long id){
        pr.deleteById(id);
        rm.setMsg("produto removido com sucesso");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
    }


}

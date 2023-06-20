package com.juliano.br.produtos.repositorio;

import org.springframework.data.repository.CrudRepository;


import com.juliano.br.produtos.modelo.ProdutoModelo;

public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo,Long>{
    
}


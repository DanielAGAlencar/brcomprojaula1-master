package br.com.projaula1.service;


import br.com.projaula1.model.Produto;
import br.com.projaula1.model.Venda;

import br.com.projaula1.repository.ProdutoRepository;
import br.com.projaula1.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Venda save(Venda venda){
        Produto produto = produtoRepository.findById(venda.getProduto().getId())
                                           .orElse(new Produto());
        venda.setProduto(produto);
        return vendaRepository.save(venda);
    }

    public List<Venda> findAll(){
        return vendaRepository.findAll();
    }

    public Optional<Venda> findByid(int id){
        return vendaRepository.findById(id);
    }

    public void delete(int id){
        vendaRepository.deleteById(id);
    }
}

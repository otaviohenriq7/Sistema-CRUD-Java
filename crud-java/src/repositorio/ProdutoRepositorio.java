package repositorio;

import modelo.Produto;
import java.util.ArrayList;
import java.util.List;


public class ProdutoRepositorio{
    private List<Produto> produtos;
    private int proximoId;


    public ProdutoRepositorio(){
        this.produtos = new ArrayList<>();
        this.proximoId = 1;
    }


    public Produto salvar(Produto produto){
        produto.setId(proximoId++);
        produtos.add(produto);
        return produto;
    }


    public List<Produto> listarTodos(){
        return new ArrayList<>(produtos); // Retorna uma cópia da lista
    }


    public Produto buscarPorId(int id){
        for (Produto produto : produtos){
            if (produto.getId() == id){
                return produto;
            }
        }
        return null;
    }


    public boolean atualizar(int id, Produto produtoAtualizado){
        Produto produto = buscarPorId(id);

        if (produto != null){
            produto.setNome(produtoAtualizado.getNome());
            produto.setPreco(produtoAtualizado.getPreco());
            produto.setQuantidade(produtoAtualizado.getQuantidade());
            return true;
        }
        return false;
    }


    public boolean deletar(int id){
        Produto produto = buscarPorId(id);

        if (produto != null) {
            produtos.remove(produto);
            return true;
        }
        return false;
    }


    public boolean temProdutos(){
        return !produtos.isEmpty();
    }


    public int contarProdutos(){
        return produtos.size();
    }
}

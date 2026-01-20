package servico;

import modelo.Produto;
import repositorio.ProdutoRepositorio;
import java.util.List;


public class ProdutoServico{
    private ProdutoRepositorio produtoRepositorio;

    // Construtor
    public ProdutoServico(){
        this.produtoRepositorio = new ProdutoRepositorio();
    }


    public boolean criarProduto(String nome, double preco, int quantidade) {
        try{
            if (nome == null || nome.trim().isEmpty()){
                System.out.println("Erro: O nome do produto não pode ser vazio!");
                return false;
            }

            if (preco < 0){
                System.out.println("Erro: O preço não pode ser negativo!");
                return false;
            }

            if (quantidade < 0){
                System.out.println("Erro: A quantidade não pode ser negativa!");
                return false;
            }

            Produto produto = new Produto(0, nome, preco, quantidade);
            Produto produtoSalvo = produtoRepositorio.salvar(produto);
            System.out.println("Produto criado com sucesso! ID: " + produtoSalvo.getId());
            return true;

        }catch (Exception e){
            System.out.println("Erro ao criar produto: " + e.getMessage());
            return false;
        }
    }


    public List<Produto> listarTodosProdutos(){
        return produtoRepositorio.listarTodos();
    }


    public Produto buscarProdutoPorId(int id){
        return produtoRepositorio.buscarPorId(id);
    }


    public boolean atualizarProduto(int id, String nome, double preco, int quantidade){
        try{
            if (nome == null || nome.trim().isEmpty()){
                System.out.println("Erro: O nome do produto não pode ser vazio!");
                return false;
            }

            if (preco < 0){
                System.out.println("Erro: O preço não pode ser negativo!");
                return false;
            }

            if (quantidade < 0){
                System.out.println("Erro: A quantidade não pode ser negativa!");
                return false;
            }

            Produto produtoAtualizado = new Produto(id, nome, preco, quantidade);
            boolean sucesso = produtoRepositorio.atualizar(id, produtoAtualizado);

            if (sucesso){
                System.out.println("Produto atualizado com sucesso!");
                return true;
            }else{
                System.out.println("Produto não encontrado!");
                return false;
            }

        }catch (Exception e){
            System.out.println("Erro ao atualizar produto: " + e.getMessage());
            return false;
        }
    }

    public boolean deletarProduto(int id){
        boolean sucesso = produtoRepositorio.deletar(id);

        if (sucesso){
            System.out.println("Produto deletado com sucesso!");
            return true;
        }else{
            System.out.println("Produto não encontrado!");
            return false;
        }
    }

    public boolean existemProdutos(){
        return produtoRepositorio.temProdutos();
    }


    public int obterTotalProdutos(){
        return produtoRepositorio.contarProdutos();
    }
}

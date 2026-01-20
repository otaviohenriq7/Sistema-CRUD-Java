import modelo.Produto;
import servico.ProdutoServico;
import java.util.List;
import java.util.Scanner;

public class Main{
    private static ProdutoServico produtoServico = new ProdutoServico();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        int opcao;

        do{
            exibirMenu();
            opcao = lerOpcao();

            switch (opcao){
                case 1:
                    criarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    buscarProduto();
                    break;
                case 4:
                    atualizarProduto();
                    break;
                case 5:
                    deletarProduto();
                    break;
                case 0:
                    System.out.println("\n👋 Encerrando o sistema... Até logo!");
                    break;
                default:
                    System.out.println("\n✗ Opção inválida! Tente novamente.");
            }

            if (opcao != 0){
                pausar();
            }

        }while (opcao != 0);

        scanner.close();
    }


    private static void exibirMenu(){
        System.out.println("\n╔═════════════════════════════════════════════╗");
        System.out.println("║     SISTEMA CRUD - Otávio - PRODUTOS         ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.println("│ 1 - Criar Produto                            │");
        System.out.println("│ 2 - Listar Todos os Produtos                 │");
        System.out.println("│ 3 - Buscar Produto por ID                    │");
        System.out.println("│ 4 - Atualizar Produto                        │");
        System.out.println("│ 5 - Deletar Produto                          │");
        System.out.println("│ 0 - Sair                                     │");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.print("Escolha uma opção: ");
    }


    private static int lerOpcao(){
        try{
            return Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException e){
            return -1;
        }
    }


    private static void criarProduto(){
        System.out.println("\n═══ CRIAR NOVO PRODUTO ═══");

        try{
            System.out.print("Nome do produto: ");
            String nome = scanner.nextLine();

            System.out.print("Preço: R$ ");
            double preco = Double.parseDouble(scanner.nextLine());

            System.out.print("Quantidade em estoque: ");
            int quantidade = Integer.parseInt(scanner.nextLine());

            produtoServico.criarProduto(nome, preco, quantidade);

        }catch (NumberFormatException e) {
            System.out.println("✗ Erro: Valor numérico inválido!");
        }catch (Exception e) {
            System.out.println("✗ Erro ao criar produto: " + e.getMessage());
        }
    }


    private static void listarProdutos(){
        System.out.println("\n═══ LISTA DE PRODUTOS ═══");

        List<Produto> produtos = produtoServico.listarTodosProdutos();

        if (produtos.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
        }else{
            System.out.println("Total de produtos: " + produtos.size());
            System.out.println("─────────────────────────────────────");
            for(Produto produto : produtos){
                System.out.println(produto);
            }
        }
    }


    private static void buscarProduto(){
        System.out.println("\n═══ BUSCAR PRODUTO ═══");

        try{
            System.out.print("Digite o ID do produto: ");
            int id = Integer.parseInt(scanner.nextLine());

            Produto produto = produtoServico.buscarProdutoPorId(id);

            if (produto != null) {
                System.out.println("\n✓ Produto encontrado:");
                System.out.println(produto);
            }else{
                System.out.println("✗ Produto não encontrado!");
            }

        }catch (NumberFormatException e){
            System.out.println("✗ Erro: ID inválido!");
        }
    }

    private static void atualizarProduto(){
        System.out.println("\n═══ ATUALIZAR PRODUTO ═══");

        try{
            System.out.print("Digite o ID do produto a atualizar: ");
            int id = Integer.parseInt(scanner.nextLine());

            Produto produtoExistente = produtoServico.buscarProdutoPorId(id);

            if (produtoExistente != null){
                System.out.println("\nProduto atual: " + produtoExistente);
                System.out.println("\nDigite os novos dados:");

                System.out.print("Novo nome: ");
                String nome = scanner.nextLine();

                System.out.print("Novo preço: R$ ");
                double preco = Double.parseDouble(scanner.nextLine());

                System.out.print("Nova quantidade: ");
                int quantidade = Integer.parseInt(scanner.nextLine());

                produtoServico.atualizarProduto(id, nome, preco, quantidade);

            }else{
                System.out.println("✗ Produto não encontrado!");
            }

        }catch (NumberFormatException e) {
            System.out.println("✗ Erro: Valor inválido!");
        }
    }

    private static void deletarProduto(){
        System.out.println("\n═══ DELETAR PRODUTO ═══");

        try{
            System.out.print("Digite o ID do produto a deletar: ");
            int id = Integer.parseInt(scanner.nextLine());

            Produto produto = produtoServico.buscarProdutoPorId(id);

            if(produto != null) {
                System.out.println("\nProduto a ser deletado: " + produto);
                System.out.print("Confirma a exclusão? (S/N): ");
                String confirmacao = scanner.nextLine();

                if (confirmacao.equalsIgnoreCase("S")) {
                    produtoServico.deletarProduto(id);
                }else{
                    System.out.println("✗ Operação cancelada!");
                }
            }else{
                System.out.println("✗ Produto não encontrado!");
            }

        }catch (NumberFormatException e) {
            System.out.println("✗ Erro: ID inválido!");
        }
    }


    private static void pausar() {
        System.out.println("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }
}

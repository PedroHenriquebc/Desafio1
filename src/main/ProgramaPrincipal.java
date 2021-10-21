package main;

import java.util.List;
import java.util.Scanner;

import entidades.CarrinhoDeCompras;
import entidades.Loja;
import entidades.Produto;

public class ProgramaPrincipal {

	public static void main(String[] args) {

		Produto p0 = new Produto(0, "Feij�o", 6.99, 10);
		Produto p1 = new Produto(1, "Arroz", 5.99, 10);
		Produto p2 = new Produto(2, "Macarr�o", 2.99, 10);
		Produto p3 = new Produto(3, "A��car", 3.50, 10);

		Loja loja = new Loja();

		List<Produto> produtos = loja.getProdutos();
		produtos.add(p0);
		produtos.add(p1);
		produtos.add(p2);
		produtos.add(p3);

		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

		Scanner sc = new Scanner(System.in);
		int qtd;

		String entrada2 = "s";

		while (entrada2.equals("s")) {
			System.out.println("           	 ~ Tabela de produtos ~");
			System.out.println();
			System.out.println("C�digo      Produto 	    Pre�o unit.(R$)         Qtd em Estoque");
			System.out.println();
			for (int i = 0; i < produtos.size(); i++) {
				System.out.println(produtos.get(i));
			}

			System.out.println();
			System.out.print("Digite o c�digo do produto que deseja para adicion�-lo ao carrinho: ");

			int entrada = sc.nextInt();
			System.out.println("======================================================================");
			while (entrada < 0 || entrada > produtos.size() - 1) {
				System.out.print("Entrada inv�lida, digite o c�digo do produto que deseja para adicion�-lo ao carrinho: ");
				entrada = sc.nextInt();
			}
			
			for(int i = 0; i < loja.getProdutos().size(); i++) {
				if (entrada == i) {
					Produto produto = loja.getProdutos().get(i);
					if (produtos.get(i).getEstoque() > 0) {
						System.out.print("Digite a quantidade de "+ produto.getNome() +" que voc� deseja: ");
						qtd = sc.nextInt();
						while (qtd > produtos.get(i).getEstoque() || qtd < 0  ) {
							System.out.print("Entrada inv�lida ou estoque insuficiente de "+  produto.getNome()
									+ ", digite uma quantidade at� " + produtos.get(i).getEstoque() + ": ");
							qtd = sc.nextInt();
						}
						carrinho.inserir(produto);
						System.out.println("======================================================================");
						System.out.println("Voc� adcionou "+ qtd + " pacotes de "+ produto.getNome() + " no seu carrinho!");
						carrinho.somaCarrinho(produto, qtd);
						produtos.get(i).setEstoque(produtos.get(i).getEstoque() - qtd);
					} else {
						System.out.println("Desculpe, estoque insuficiente de " + produto.getNome() + " no momento.");
					}
				}
			}

			System.out.println();
			System.out.printf("Valor total do Carrinho = R$%.2f %n", carrinho.getValorTotal());
			System.out.print("Deseja adicionar mais itens no carrinho? (s/n): ");
			entrada2 = sc.next();
			System.out.println("======================================================================");
			while (!entrada2.equals("n") && !entrada2.equals("s")) {
				System.out.println("Entrada inv�lida, digite 's' para continuar comprando ou 'n' para ir � sess�o de pagamento: ");
				entrada2 = sc.next();
			}

		}


	}
}

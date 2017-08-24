import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Blog  {
	static Scanner text = new Scanner(System.in); //pegar texto do teclado fora da main

	private static  ArrayList <Post> posts = new ArrayList<Post>(); //arrayList de objetos do tipo post

	//métodos get e set do ArrayList ----------------------------------
	public ArrayList <Post> getPosts() {
		return posts;
	}

	public void setPosts(ArrayList <Post> posts) {
		Blog.posts = posts;
	}
 //--------------------------------------------------------------------

	public static void showAll() {
		for (int i = 0; i < posts.size(); i++) {
			System.out.println("\nCódigo do Post: "+(i+1));
			System.out.println("-------------------------------------------------------");
			posts.get(i).show();
		}
		System.out.println("-------------------------------------------------------");
	}

	public static void readData(Post p) {
		System.out.print("Digite o título: ");
		String titulo = text.nextLine();

		System.out.print("Digite o Conteúdo: ");
		String cont = text.nextLine();

		Date data = new Date(); //data gerada automaticamente

		p.setTitle(titulo);
		p.setContent(cont);
		p.setDate(data);

		//ira verificar qual é o tipo do objeto

		if(p instanceof News){ //Noticia
			System.out.print("Fonte da notícia: ");
			String fonte = text.nextLine();

			((News) p).setSource(fonte); //subclasse
		}
		else if(p instanceof ProductReview){ //Produto
			System.out.print("Marca: ");
			String marca = text.nextLine();

			System.out.print("Quantidade de estrelas: ");
			String verificaInt = text.nextLine();

			int numStar = verifica(verificaInt); //verifica se o valor é um inteiro

			//caso for digitado uma letra ou letras por engano, será atribuido apenas uma estrela
			if(numStar > 10) numStar = 10; //Máximo de estrelas
			if(numStar < 1) numStar = 1; //Minimo de estrelas

			((ProductReview) p).setBrand(marca); //subclasse
			((ProductReview) p).evaluate(numStar); //subclasse
		}

		posts.add(p); //adiciona ao arrayList
	}

	private static int verifica(String verificaInt) {
		try {
		      return Integer.valueOf(verificaInt); //retorna o valor convertido em inteiro
		}
		catch (NumberFormatException e) {  //se não for um inteiro, retorna um valor padrão para erro
			return -99; //valor aleatorio
		}
	}

	public static void main(String[] args) {
		int menu, tamanho;
		String verificaInt;

		Post aux = null;

		Scanner opc = new Scanner(System.in); //para ler do teclado

		do {
			System.out.println("\nBLOG: O que você quer fazer?\n");
			System.out.println("1 - Novo post de noticia\n" + "2 - Nova resenha de produto");
			System.out.println("3 - Novo post de outros assuntos\n" + "4 - Listar todas as postagens");
			System.out.println("5 - Curtir uma postagem\n" + "6 - Não curtir uma postagem\n" + "10 - Sair");
			System.out.print("Escolha a opção: ");
			verificaInt = opc.nextLine();

			menu = verifica(verificaInt);


			switch (menu) {
				case 1:
					aux = new News(); //upcast
					readData(aux);
					break;
				case 2:
					aux =  new ProductReview(); //upcast
					readData(aux);
					break;
				case 3:
					aux = new Post(); //upcast
					readData(aux);
					break;
				case 4:
					showAll();
					break;
				case 5:
					System.out.print("Digite o código do Post:");
					verificaInt =  opc.nextLine(); //passa o valor para uma string e verifica se é um inteiro
					menu = verifica(verificaInt);

					tamanho = posts.size();

					if(menu == -99) {
						System.out.println("\nEntrada inválida! Utilize apenas números inteiros");
					}
					else if(menu-1 >= tamanho) {
						System.out.println("\nCódigo inválido, postagem inexistente!");
					}
					else {
						aux.like(posts.get(menu-1)); //passa por parametro a posicao no arraylist
						System.out.println("\nPostagem curtida!");
					}

					break;
				case 6:
					System.out.print("Digite o código do Post:");
					verificaInt =  opc.nextLine(); //passa valor para uma string e verifica se é um inteiro
					menu = verifica(verificaInt);

					tamanho = posts.size();

					if(menu == -99) {
						System.out.println("\nEntrada inválida! Utilize apenas números inteiros");
					}

					else if(menu-1 >= tamanho) {
						System.out.println("\nCódigo inválido, postagem inexistente!");
					}
					else {
						aux.dislike(posts.get(menu-1)); //passa por parametro a posicao no arraylist
						System.out.println("\nPostagem não curtida!");
					}

					break;
				case 10:
					opc.close();
					System.out.println("\n\nDeixando o blog...\n");
					System.exit(0);
					break;
				default :
					System.out.println("\n\nValor inserido incorreto!\n");
			}
		} while(menu != 10);
	}
}

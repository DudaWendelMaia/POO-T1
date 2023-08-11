import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        ACMEPublishing acme = new ACMEPublishing();
        acme.executa();
        Scanner in= new Scanner(System.in);

        int op =0;
         do {
            System.out.println("===============================");
        System.out.println("[1] Cadastrar um novo autor e livro correspondente;");
        System.out.println("[2] Mostrar todos os autores cadastrados e livros correspondentes;");
        System.out.println("[0] Sair do sistema;");
        System.out.println("Digite a opção desejada: ");
        op = in.nextInt();

        switch (op) {
            case 1:
                
                System.out.println("Digite o nome do autor desejado: ");
                String nome = in.nextLine();
                System.out.println("Digite o código do autor; ");
                int codigo = in.nextInt();
                System.out.println("digite o titulo do livro: ");
                String titulo = in.nextLine();
                System.out.println("Digite o código: ");
                String isbn = in.nextLine();
                System.out.println("Digite o ano: ");
                int ano = in.nextInt();
                Livro l = new Livro(isbn, titulo,ano);
                Autor a  = new Autor(codigo, nome, l);
                acme.cadastraLivro(l);
                acme.cadastraAutor(a);

                
                break;
            
            case 2:
            ArrayList<Livro> livro = acme.mostraLivro();
            ArrayList<Autor> autor = acme.mostraAutor();
            for (Autor autor2 : autor) {
                System.out.println(autor2);
            }
            for (Livro liv : livro) {
                System.out.println(liv);
            }
             break;

        }
         } while (op!=0);
        in.close();

    }
}
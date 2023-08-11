import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;

public class ACMEPublishing {
    private Biblioteca biblioteca;

    private Grupo grupo;

    private ArrayList<String> dados;

    private Scanner entrada = null; // Atributo para entrada de dados
    // Construtor

    public ACMEPublishing() {
        try {
            String linha;
            BufferedReader streamEntrada = new BufferedReader(new FileReader("dados.txt"));
            entrada = new Scanner(streamEntrada); // Usa como entrada um arquivo

            PrintStream streamSaida = new PrintStream(new File("saida.txt"), Charset.forName("UTF-8"));
            System.setOut(streamSaida); // Usa como saida um arquivo

            dados = new ArrayList<>();

            while ((linha = streamEntrada.readLine()) != null) {
                dados.add(linha);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        entrada.useLocale(Locale.ENGLISH);
        biblioteca = new Biblioteca();
        grupo = new Grupo();
    }

    public void executa() {
        int pos = cadastraLivro(); // 1
        qtdLivrosCadastrados(); // 2
        pos = cadastraAutores(pos); // 3
        qtdAutoresCadastrados(); // 4
        pos = addLivroAutor(pos); // 5
        pos = livrosAutor(pos); // 6
        pos = nomesAutores(pos); // 7
        livroMaisAutores(); // 8
        autoresMaisLivros(); // 9
        livrosPorAno(pos);// 10

    }

    private int cadastraLivro() {
        for (int i = 0; i < dados.size(); i += 3) {
            if (dados.get(i).equals("-1")) {
                return i + 1;
            }

            int ano = Integer.parseInt(dados.get(i + 2));
            Livro livro = new Livro(dados.get(i), dados.get(i + 1), ano);

            if (!biblioteca.cadastraLivro(livro)) {
                // System.out.println("ISBN já cadastrado: " + livro.getisbn());
            } else {
                System.out.println("1;" + livro.getisbn() + ";" + livro.getTituloLivro() + ";" + livro.getAno());
            }
        }
        return -1;
    }

    public void qtdLivrosCadastrados() {
        System.out.println("2;" + biblioteca.qtdLivrosCadastrados());
    }

    private int cadastraAutores(int pos) {
        int codigo = 0;
        int posicaoLivro = pos;
        for (int i = posicaoLivro; i < dados.size(); i += 3) {
            if (dados.get(i).equals("-1"))
                return i + 1;

            codigo = Integer.parseInt(dados.get(i));
            Livro l = biblioteca.pesquisaLivro(dados.get(i + 2));
            Autor autor = new Autor(codigo, dados.get(i + 1), l);

            if (!grupo.cadastraAutor(autor)) {
                // System.out.println("Autor já cadastrado: " +
                // grupo.pesquisaAutor(autor.getCodigo()).getNome());
            } else {
                System.out.println("3;" + autor.getCodigo() + ";" + autor.getNome() + ";" + l.getisbn());
            }
        }
        return -1;
    }

    private void qtdAutoresCadastrados() {
        System.out.println("4;" + grupo.qtdAutoresCadastrados());
    }

    ArrayList<Integer> codigos = new ArrayList<>();

    private int addLivroAutor(int posi) {
        int codigo = 0;
        int pos = posi;
        for (int i = pos; i < dados.size(); i += 2) {
            codigo = Integer.parseInt(dados.get(i));
            if (codigos.contains(codigo)) {
                continue;
            }
            if (dados.get(i).equals("-1"))
                return i + 1;

            codigos.add(codigo);

            Autor a = grupo.pesquisaAutor(codigo);
            Livro l = biblioteca.pesquisaLivro(dados.get(i + 1));

            if (!a.adicionaLivro(l)) {
                // System.out.println("Livro" + "(" + l.getTituloLivro() + ")" + "já cadastrado
                // para o autor :" + a.getNome());
            } else {
                System.out.println("5;" + a.getCodigo() + ";" + a.getNome() + ";" + l.getisbn() + ";"
                        + l.getTituloLivro() + ";" + l.getAno());
            }
        }
        return -1;
    }

    private int livrosAutor(int posi) {
        int codigo = Integer.parseInt(dados.get(posi));
        ArrayList<Livro> livro2;
        Autor a = grupo.pesquisaAutor(codigo);
        livro2 = a.getListaLivro();
        if (livro2 == null)
            return posi + 1;
        for (Livro l : livro2) {
            System.out.println("6;" + a.getCodigo() + ";" + a.getNome() + ";" + l.getisbn() + ";" + l.getTituloLivro()
                    + ";" + l.getAno());

        }
        return posi + 1;
    }

    private int nomesAutores(int posi) {
        ArrayList<Autor> autor2;
        Livro l = biblioteca.pesquisaLivro(dados.get(posi));
        autor2 = l.getCadastroAutor();
        if (autor2 == null)
            return posi + 1;

        String aux = "7;" + l.getisbn() + ";";
        for (Autor a : autor2) {
            aux += a.getNome() + ";";
        }
        System.out.println(aux);
        return posi + 1;
    }

    private void livroMaisAutores() {
        ArrayList<Livro> livro2 = biblioteca.getListaLivro();
        for (Livro livro : livro2) {
            if (livro.numeroAutores() > 1) {
                System.out.println("8;" + livro.getisbn() + ";" + livro.getTituloLivro());
            }
        }
    }

    private void autoresMaisLivros() {
        ArrayList<Autor> autor2 = grupo.getGrupo();
        String aux = "";
        for (Autor autor : autor2) {
            if (autor.numeroLivros() > 1) {
                aux += "9;" + autor.getNome();
                ArrayList<Livro> livros = autor.getListaLivro();
                for (Livro l : livros) {
                    aux += ";" + l.getisbn();
                }
                aux += "\n";
            }
        }
        System.out.printf(aux);
    }

    private void livrosPorAno(int ano) {
        int aux = Integer.parseInt(dados.get(ano));
        ArrayList<Livro> livros = biblioteca.pesquisaLivro(aux);
        for (Livro livro : livros) {
            System.out.println("10;" + livro.getisbn() + ";" + livro.getTituloLivro() + ";" + livro.getAno());

        }

    }

    public ArrayList<Livro> mostraLivro() {
        return biblioteca.getListaLivro();
    }

    public ArrayList<Autor> mostraAutor() {
        return grupo.getGrupo();
    }

    public void cadastraLivro(Livro l){
        biblioteca.cadastraLivro(l);
    }

    public void cadastraAutor(Autor a){
        grupo.cadastraAutor(a);
    }
}
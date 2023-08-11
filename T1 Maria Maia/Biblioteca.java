import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro>cadastro;

    public Biblioteca () {
      cadastro = new ArrayList<Livro>();
    }

    public boolean cadastraLivro(Livro livro) {
        for (Livro livroSearch : cadastro) {
            if (livroSearch.getisbn().equals(livro.getisbn())) {
                return false;
            }
        }
        cadastro.add(livro);
        return true;
    }

    public Livro pesquisaLivro(String isbn) {
        for(Livro a : cadastro) {
            if(a.getisbn().equals(isbn)) {
                return a;
            }
        }
        return null;
    }

    public ArrayList<Livro> pesquisaLivro(int ano) {
        ArrayList<Livro> pesquisaTitulo;
        pesquisaTitulo = new ArrayList<Livro>();
        for(Livro a : cadastro) {
            if(a.getAno() == ano) {
                pesquisaTitulo.add(a);
            }
        }
        if(pesquisaTitulo.size() > 0) {
            return pesquisaTitulo;
        }
        else {
            return null;
        }
    }

    public ArrayList<Livro> getListaLivro() {
        return cadastro;
    }

    public int qtdLivrosCadastrados() {
        return cadastro.size();
    }

}
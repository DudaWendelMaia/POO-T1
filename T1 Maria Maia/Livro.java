import java.util.ArrayList;

public class Livro {
    private String isbn;
    private String titulo;
    private int ano;
    private ArrayList<Autor> cadastroAutor;

    public Livro (String isbn, String titulo, int ano) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.ano = ano;
        cadastroAutor = new ArrayList<Autor>();
    }

    public boolean adicionaAutor(Autor autor) {
        for (Autor autorSearch : cadastroAutor) {
            if (autorSearch == autor) {
                return false;
            }
        }
        cadastroAutor.add(autor);
        return true;
    }

    public ArrayList<Autor> getCadastroAutor () {
        return cadastroAutor;
    }

    public String getisbn() {
        return isbn;
    }

    public void setisbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTituloLivro() {
        return titulo;
    }

    public void setTituloLivro(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Livro [isbn=" + isbn + ", titulo=" + titulo + ", ano=" + ano + "]";
    }

    public Object getNome() {
        return null;
    }

    public int numeroAutores() {
        return cadastroAutor.size();
    }
}

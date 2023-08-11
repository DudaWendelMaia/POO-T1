import java.util.ArrayList;

public class Autor {
    private int codigo;
    private String nome;
    ArrayList<Livro> cadastroLivro;

    public Autor(int codigo, String nome, Livro livro) {
        this.codigo = codigo;
        this.nome = nome;
        cadastroLivro = new ArrayList<Livro>();
        cadastroLivro.add(livro);
        livro.adicionaAutor(this);
    }

    public boolean adicionaLivro(Livro livro) {
        for (Livro livroSearch : cadastroLivro) {
            if (livroSearch == livro) {
                return false;
            }
        }
        cadastroLivro.add(livro);
        livro.adicionaAutor(this);
        return true;
    }


    public ArrayList<Livro> pesquisaLivros() {
        ArrayList<Livro> pesquisaNome;
        pesquisaNome = new ArrayList<Livro>();
        for(Livro a: cadastroLivro) {
            if(a.getNome().equals(nome)) {
                pesquisaNome.add(a);
            }
            return pesquisaNome; 
        }
        if(pesquisaNome.size() > 0) {
            return pesquisaNome;
        }
        else {
            return null;
        }
    }
    

    public ArrayList<Livro> getListaLivro() {
        return cadastroLivro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setome(String nome) {
        this.nome = nome;
    }
    public int numeroLivros() {
        return cadastroLivro.size();
    }

    @Override
    public String toString() {
        return "Autor [codigo=" + codigo + ", nome=" + nome + "]";
    }
}

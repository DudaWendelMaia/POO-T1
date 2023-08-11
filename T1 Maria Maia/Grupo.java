import java.util.ArrayList;

public class Grupo {
    ArrayList<Autor> cadastroAutor;

    public Grupo() {
        cadastroAutor = new ArrayList<Autor>();
    }

    public boolean cadastraAutor(Autor autor) {
        for (Autor autorSearch : cadastroAutor) {
            if (autorSearch.getCodigo() == autor.getCodigo()) {
                return false;
            }
        }
        cadastroAutor.add(autor);
        return true;
    }
    
    public Autor pesquisaAutor(int codigo) {
        for(Autor autorSearch : cadastroAutor) {
            if(autorSearch.getCodigo() == codigo) {
                return autorSearch;
            }
        }
        return null;
    }


    public ArrayList<Autor> getGrupo() {
        return cadastroAutor;
    }

    public int qtdAutoresCadastrados() {
        return cadastroAutor.size();
    }
}

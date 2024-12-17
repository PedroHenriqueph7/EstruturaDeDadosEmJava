package desafios_list.pesquisa.op1;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    List<Livro> catalogoLivros;

    public CatalogoLivros(){
        catalogoLivros = new ArrayList<Livro>();
    }

    public void adicionarLivros(String titulo, String autor, int anoPublicacao){
        Livro livro = new Livro(titulo, autor, anoPublicacao);
        catalogoLivros.add(livro);
    }

    public List<Livro> pesquisaPorAutor(String autor) throws Exception{
        List<Livro> pesquisadosPorAutor = new ArrayList<Livro>();
        
        if (!catalogoLivros.isEmpty()){
            int quantidadeLivrosEncontrados = 0;
            for (Livro interador : catalogoLivros) {
                if (interador.getAutor().equalsIgnoreCase(autor)){
                    pesquisadosPorAutor.add(interador);
                    quantidadeLivrosEncontrados++;
                }
                
            }
            if (quantidadeLivrosEncontrados == 0){
                System.out.println("Nenhum Livro foi encontrado do autor "+ autor);
            } 
            
        } else {
            throw new Exception("Catalogo de Livros está vazio");
        }
        return pesquisadosPorAutor;
        
    }

    public List<Livro> pesquisaPorIntervaloAnos(int anoInical, int anoFinal) throws Exception{
        
        List<Livro> pesquisadosPorPeriodo = new ArrayList<Livro>();
       
        if (!catalogoLivros.isEmpty()){
            int quantidadeLivrosAdicionados = 0;
            for (Livro livro : catalogoLivros) {
                if(livro.getAnoPublicacao() >= anoInical && livro.getAnoPublicacao() <= anoFinal){
                   pesquisadosPorPeriodo.add(livro);
                   quantidadeLivrosAdicionados++;
                }
                
            }
            if (quantidadeLivrosAdicionados == 0){
                System.out.println("Não foi encontrado nenhum livro, dentro deste periodo");
            }

        } else {
            throw new Exception("Catalogo de livros está vazio");
        }

        return pesquisadosPorPeriodo;
    }

    public void pesquisaPorTitulo(String titulo) throws Exception{
        int quantidadeLivrosEncontrados = 0;
        if (!catalogoLivros.isEmpty()){
            for (Livro livro : catalogoLivros) {
                if (livro.getTitulo().equalsIgnoreCase(titulo)){
                    System.out.println(livro);
                    quantidadeLivrosEncontrados++;
                    break;
                }
                
            }  
            if (quantidadeLivrosEncontrados == 0){
                System.out.println("Não foi encontrado nenhum Livro com este Titulo");
            }     
        } else {
            throw new Exception("Catalogo de livros está vazio");
        }
    }
    

    public static void main(String[] args) throws Exception {
        
        
        CatalogoLivros catalogoLivros = new CatalogoLivros();
        try {
            catalogoLivros.adicionarLivros("Mil pensamentos", "Autor", 2001);
            catalogoLivros.adicionarLivros("Planeta", "Autor2", 2000);
            catalogoLivros.adicionarLivros("Oceano", "Autor3", 2010);
            catalogoLivros.adicionarLivros("Tubarao", "Autor4", 2006);
            catalogoLivros.adicionarLivros("Auto conhecimento", "Autor5", 1998);

        System.out.println(catalogoLivros.pesquisaPorAutor("Autor"));
        System.out.println(catalogoLivros.pesquisaPorAutor("autor1"));

        catalogoLivros.pesquisaPorTitulo("oceano");
        System.out.println(catalogoLivros.pesquisaPorIntervaloAnos(2000,2006));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
    }
}

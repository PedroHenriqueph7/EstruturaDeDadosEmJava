package desafios_set.ordenacao.op2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

public class CadastroAlunos {
    Set<Aluno> cadastroDeAlunos;

    public CadastroAlunos(){
        cadastroDeAlunos = new HashSet<>();
    }

    public void adicionarAlunos(String nome, Long matricula, char turma, double media) {
            Aluno aluno = new Aluno(nome, matricula, turma, media);
        cadastroDeAlunos.add(aluno);
    }

    public void removerAlunos(Long matricula) throws Exception {
        if (!cadastroDeAlunos.isEmpty()) {
            Set<Aluno> remocaoAluno = new LinkedHashSet<>();
            boolean alunoEncontrado = false;
            for (Aluno a : cadastroDeAlunos) {
                if (a.getMatricula() == matricula) {
                    remocaoAluno.add(a);
                    alunoEncontrado = true;
                }

                if (alunoEncontrado == false) {
                    throw new NoSuchElementException("Elemento não encontrado!");
                }
            }
        } else {
            throw new IllegalStateException("Cadastro de alunos vazio!;");
        }
    }

    public Set<Aluno> exibirAlunoPorNome() {
        Set<Aluno> ordenadosPorNome = new TreeSet<>(cadastroDeAlunos);
        return ordenadosPorNome;
    }

    public List<Aluno> exibirAlunoPorNota(){
        
        List<Aluno> ordenadosPorNota = new ArrayList<>(cadastroDeAlunos);
        NotaComparator comparator = new NotaComparator();
        Collections.sort(ordenadosPorNota, comparator.reversed());
        return ordenadosPorNota;

    }

    public void exibirAlunos() {
        System.out.println("CADASTRO DE ALUNOS: ");
        for (Aluno al : cadastroDeAlunos) {
            System.out.println(al);
        }
    }

    public static void main(String[] args) {
        CadastroAlunos cadastroAlunos = new CadastroAlunos();

        cadastroAlunos.adicionarAlunos("Ruan", 980009L, 'C', 9.78);
        cadastroAlunos.adicionarAlunos("Jadson", 982900L, 'B', 7.70);
        cadastroAlunos.adicionarAlunos("Laura", 982901L, 'C', 5.98);
        cadastroAlunos.adicionarAlunos("Levi", 982902L, 'A', 6.38);
        cadastroAlunos.adicionarAlunos("Luana", 982903L, 'A', 4.78);
        cadastroAlunos.adicionarAlunos("Rocha", 982904L, 'D', 8.15);
        cadastroAlunos.adicionarAlunos("Santos", 982905L, 'C', 9.50);
        cadastroAlunos.adicionarAlunos("Silva", 982906L, 'B', 9.10);
        cadastroAlunos.adicionarAlunos("Fernando", 982907L, 'D', 8.50);

        cadastroAlunos.exibirAlunos();
        System.out.println(cadastroAlunos.exibirAlunoPorNome());
        System.out.println();
        System.out.println(cadastroAlunos.exibirAlunoPorNota());
    }

}

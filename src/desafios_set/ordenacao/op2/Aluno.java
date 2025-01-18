package desafios_set.ordenacao.op2;

public class Aluno implements Comparable<Aluno>{
    private String nome;
    private Long matricula;
    private char turma;
    private double nota;
    
    public Aluno(String nome, Long matricula, char turma, double nota) {
        this.nome = nome;
        this.matricula = matricula;
        this.turma = turma;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public Long getMatricula() {
        return matricula;
    }

    public char getTurma() {
        return turma;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "Aluno [nome=" + nome + ", matricula=" + matricula + ", turma=" + turma + ", nota=" + nota + "]";
    }

    @Override
    public int compareTo(Aluno a) {
        return this.nome.compareToIgnoreCase(a.getNome());
    }

}

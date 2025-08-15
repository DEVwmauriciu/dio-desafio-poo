package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos;
    private Set<Conteudo> conteudosConcluidos;

    public Dev() {
        this.conteudosInscritos = new LinkedHashSet<>();
        this.conteudosConcluidos = new LinkedHashSet<>();
    }
    public Dev(String nome) {
        this.nome = nome;
        this.conteudosInscritos = new LinkedHashSet<>();
        this.conteudosConcluidos = new LinkedHashSet<>();
    }

    public void progredir() {
        if (!conteudosInscritos.isEmpty()) {
            Conteudo conteudo = conteudosInscritos.iterator().next();
            concluirConteudo(conteudo);
            System.out.println("Progrediu no conteúdo: " + conteudo.getTitulo());
        } else {
            System.err.println("Você não está inscrito em nenhum curso/mentoria.");
        }
    }

    public void  inscreverBootcamp(Bootcamp bootcamp) {
        if (bootcamp != null && bootcamp.getDevsInscritos() != null) {
            bootcamp.getDevsInscritos().add(this);
            this.conteudosInscritos.addAll(bootcamp.getConteudos());
            System.out.println("Inscrito no Bootcamp: " + bootcamp.getNome());
        } else {
            System.err.println("Bootcamp inválido ou sem conteúdos.");
        }
    }

    public void concluirConteudo(Conteudo conteudo) {
        if (this.conteudosInscritos.contains(conteudo)) {
            this.conteudosInscritos.remove(conteudo);
            this.conteudosConcluidos.add(conteudo);
        } else {
            System.out.println("Conteúdo não encontrado nos inscritos.");
        }
    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos.stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}

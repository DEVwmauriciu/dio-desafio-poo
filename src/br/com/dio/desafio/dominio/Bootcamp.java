package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {

    private String nome;
    private String descricao;
    private final LocalDate dataInicial;
    private final LocalDate dataFinal;
    private Set<Dev> devsInscritos;
    private Set<Conteudo> conteudos;

    public Bootcamp() {
        this.dataInicial = LocalDate.now();
        this.dataFinal = dataInicial.plusDays(45);
        this.devsInscritos = new HashSet<>();
        this.conteudos = new LinkedHashSet<>();
    }
    public Bootcamp(String nome, String descricao) {
        this();
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Set<Dev> getDevsInscritos() {
        return devsInscritos;
    }

    public void setDevsInscritos(Set<Dev> devsInscritos) {
        this.devsInscritos = devsInscritos;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    public void setConteudos(Set<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }

    @Override
    public String toString() {
        return "Bootcamp{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataInicial=" + dataInicial +
                ", dataFinal=" + dataFinal +
                ", devsInscritos=" + devsInscritos +
                ", conteudos=" + conteudos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return nome.equals(bootcamp.nome) && descricao.equals(bootcamp.descricao) &&
               dataInicial.equals(bootcamp.dataInicial) && dataFinal.equals(bootcamp.dataFinal) &&
               devsInscritos.equals(bootcamp.devsInscritos) && conteudos.equals(bootcamp.conteudos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicial, dataFinal, devsInscritos, conteudos);
    }

    public void inscreverDev(Dev dev) {
        this.devsInscritos.add(dev);
        dev.getConteudosInscritos().addAll(this.conteudos);
    }

    public void adicionarConteudo(Conteudo conteudo) {
        this.conteudos.add(conteudo);
        for (Dev dev : devsInscritos) {
            dev.getConteudosInscritos().add(conteudo);
        }
    }

}

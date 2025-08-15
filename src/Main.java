import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {
    public static void main(String[] args) {

        //System.out.println("Hello world!");

        Curso cursoJava = new Curso("Curso Java", "Aprenda Java do básico ao avançado", 8);
        Curso cursoJavascript = new Curso("Curso JavaScript", "Aprenda JavaScript do básico ao avançado", 6);

        Mentoria mentoriaJava = new Mentoria("Mentoria Java", "Tire suas dúvidas sobre Java", java.time.LocalDate.now());

        Bootcamp bootcampJava = new Bootcamp("Bootcamp Java", "Aprenda Java com o Bootcamp Java");
        bootcampJava.getConteudos().add(cursoJava);
        bootcampJava.getConteudos().add(cursoJavascript);
        bootcampJava.getConteudos().add(mentoriaJava);

        System.out.println(cursoJava);
        System.out.println(cursoJavascript);
        System.out.println(mentoriaJava);
        System.out.println("=====================================");

        Dev devWagner = new Dev("Wagner");
        devWagner.inscreverBootcamp(bootcampJava);
        System.out.println("Conteúdos Inscritos "+ devWagner.getNome() +": " + devWagner.getConteudosInscritos());
        devWagner.progredir();
        System.out.println("Conteúdos Inscritos após progresso "+ devWagner.getNome() +": "+ devWagner.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos "+ devWagner.getNome() +": "+ devWagner.getConteudosConcluidos());
        System.out.println("XP Total "+ devWagner.getNome() +": "+ devWagner.calcularTotalXp());
        System.out.println("=====================================");


        Dev devMauricio = new Dev("Mauricio");
        devMauricio.inscreverBootcamp(bootcampJava);
        System.out.println("Conteúdos Inscritos "+ devMauricio.getNome() +": " + devMauricio.getConteudosInscritos());
        devMauricio.progredir();
        devMauricio.progredir();
        devMauricio.progredir();
        System.out.println("Conteúdos Inscritos após progresso "+ devMauricio.getNome() +": "+ devMauricio.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos "+ devMauricio.getNome() +": "+ devMauricio.getConteudosConcluidos());
        System.out.println("XP Total "+ devMauricio.getNome() +": "+ devMauricio.calcularTotalXp());
        System.out.println("=====================================");

    }
}
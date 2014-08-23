
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {

        List<Pessoa> pessoas = Arrays.asList(new Pessoa("Rubens", 33), new Pessoa("Rodrigo", 15), new Pessoa("Gabriel", 3));

        //// filtrando com stream
        
        pessoas.stream()
                .filter(p -> p.getIdade() > 10)
                .forEach(System.out::println);
        
        //// obtendo a lista filtrada (menos funcional)
        
        List<Pessoa> maiores10 = new ArrayList();
        
        pessoas.stream()
                .filter(p -> p.getIdade() > 10)
                .forEach(maiores10::add);
        
        //// obtendo a lista filtrada usando collect
        
        maiores10 =  pessoas.stream()
                .filter(p -> p.getIdade() > 10)
                .collect(Collectors.toList());
        
        //// listando apenas o atributo pontos com map
        
        List<Integer> pontos = pessoas.stream()
                .map(Pessoa::getIdade)
                .collect(Collectors.toList());
        
        pontos.forEach(System.out::println);
        
        //// mapToInt para eviar autoboxing
        
        pessoas.stream()
                .mapToInt(Pessoa::getIdade)
                .boxed()
                .collect(Collectors.toList());
    }
}

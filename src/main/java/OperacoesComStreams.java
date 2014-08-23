
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class OperacoesComStreams {
    
    public static void main(String[] args) {
        
        List<Pessoa> pessoas = Arrays.asList(new Pessoa("Rubens", 33), new Pessoa("Rodrigo", 15), new Pessoa("Gabriel", 3));
        
        //// ordenando com stream
        
        List<Pessoa> pessoasOrdenadasEFiltradas = pessoas.stream()
                .filter(p -> p.getIdade() > 10)
                .sorted(Comparator.comparing(Pessoa::getNome))
                .collect(Collectors.toList());
        
        //// somando todos os pontos
        
        int total = pessoas.stream()
                .mapToInt(Pessoa::getIdade)
                .sum();
        
        //// somando utilizando reduce
        
        int total2 = pessoas.stream()
                .mapToInt(Pessoa::getIdade)
                .reduce(0, (n1, n2) -> n1 + n2);
        
        //// transformando um stream em um iterator
        
        Iterator<Pessoa> it = pessoas.stream()
                .filter(p -> p.getIdade() > 10)
                .iterator();
    }
}

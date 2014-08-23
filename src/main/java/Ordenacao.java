
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ordenacao {
    
    public static void main(String[] args) {
        
        // ordenacao java 7
        
        List<Pessoa> pessoas = Arrays.asList(new Pessoa("Rubens", 33), new Pessoa("Rodrigo", 15), new Pessoa("Gabriel", 3));
        
        Comparator<Pessoa> comparator = new Comparator<Pessoa>() {
            public int compare(Pessoa p1, Pessoa p2) {
                return p1.getNome().compareTo(p2.getNome());
            }
        };
        
        Collections.sort(pessoas, comparator);
        pessoas.forEach(p -> System.out.println(p));
        
        // ordenacao com lambda (ainda usando Collections.sort)
        
        Collections.sort(pessoas, (p1, p2) -> p1.getIdade().compareTo(p2.getIdade()));
        pessoas.forEach(p -> System.out.println(p));
        
        // novo metodo List.sort
        
        pessoas.sort((p1, p2) -> p1.getNome().compareTo(p2.getNome()));
        pessoas.forEach(p -> System.out.println(p));
        
        // metodos estaticos em interfaces - comparando wrapers
        
        List<String> nomes = Arrays.asList("Rubens", "Gabriel", "Rodrigo");
        nomes.sort(Comparator.naturalOrder());
        
    }
}

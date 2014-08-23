
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MethodReferences {
    
    public static void main(String[] args) {
        
        // method reference
        
        List<Pessoa> pessoas = Arrays.asList(new Pessoa("Rubens", 33), new Pessoa("Rodrigo", 15), new Pessoa("Gabriel", 3));
        
        Consumer<Pessoa> tornaModerador = Pessoa::showNome;
        pessoas.forEach(tornaModerador);
        
        pessoas.forEach(Pessoa::showNome);
        
        // method reference com comparators
        
        pessoas.forEach(p -> p.showNome());
        
        pessoas.forEach(Pessoa::showNome);
        
    }
}

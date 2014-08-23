
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MetodosInterfaceConsumer {

    public static void main(String[] args) {

        List<Pessoa> pessoas = Arrays.asList(new Pessoa("Rubens", 33), new Pessoa("Rodrigo", 15), new Pessoa("Gabriel", 3));
        
        //// metodo andThen da interface java.util.function.Consumer

        Consumer<Pessoa> c1 = p -> System.out.println(p.getNome());
        Consumer<Pessoa> c2 = p -> System.out.println(p.getIdade());

        pessoas.forEach(c1.andThen(c2));

        //// metodo removeIf com classe anonima
        
        List<Pessoa> pessoas_ = new ArrayList();   // lista mutável
        pessoas_.add(new Pessoa("Rubens", 100));
        pessoas_.add(new Pessoa("Rodrigo", 150));

        pessoas_.removeIf(new Predicate<Pessoa>() {
            public boolean test(Pessoa p) {
                return p.getIdade() < 10;
            }
        });

        //// metodo removeIf com lambda
        
        pessoas_.removeIf(p -> p.getIdade() < 10);
    }
}

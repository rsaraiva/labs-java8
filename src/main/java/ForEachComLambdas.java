
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEachComLambdas {

    public static void main(String[] args) {

        // criando lista com 3 pessoas
        List<Pessoa> pessoas = Arrays.asList(new Pessoa("Rubens", 33), new Pessoa("Rodrigo", 15), new Pessoa("Gabriel", 3));

        // loop java 7
        for (Pessoa p : pessoas) {
            System.out.println(p);
        }

        // novo metodo forEach das collections, criando um Consumidor (java.util.function.Consumer)
        pessoas.forEach(new Consumidor());

        // loop com classe anonima (bem verboso)
        pessoas.forEach(new Consumer<Pessoa>() {
            public void accept(Pessoa p) {
                System.out.println(p);
            }
        });

        // iniciando com lamda para implementar um consumer (ainda verboso)
        pessoas.forEach((Pessoa p) -> {
            System.out.println(p);
        });

        // por conta da inferência, nao ha necessidade do tipo nem do parenteses
        // com instrucoes de uma linha, nao sao necessarios chaves e ponto-virgula
        pessoas.forEach(p -> System.out.println(p));
    }
}

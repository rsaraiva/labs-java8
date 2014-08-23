
import java.util.function.Consumer;

public class Consumidor implements Consumer<Pessoa> {

    public void accept(Pessoa p) {
        System.out.println(p);
    }
}

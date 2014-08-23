

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArquivosComStream {

    public static void main(String[] args) throws IOException {

        //// exibindo o numero de linhas de cada arquivo
        
        List<Long> linesCounts = Files.list(Paths.get("/tmp"))
                .filter(f -> f.toString().endsWith(".html"))
                .map(f -> lines(f).count())
                .collect(Collectors.toList());

        //// retornando um map com o nome e o numero de linhas dos arquivos
        
        Map<Path, Long> mapFileLines = Files.list(Paths.get("/tmp"))
                .filter(f -> f.toString().endsWith(".html"))
                .collect(Collectors.toMap(
                        Function.identity(), f -> lines(f).count()));

    }

    static Stream<String> lines(Path p) {
        try {
            return Files.lines(p);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}

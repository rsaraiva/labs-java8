

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ManipulandoArquivos {
    
    public static void main(String[] args) {
        
        try {
        
            //// listando arquivos com stream
            
            Path tmp = Paths.get("/tmp");
            Stream<Path> stream = Files.list(tmp);
            
            
            //// filtrando arquivos .html
            
            Files.list(tmp)
                    .filter(f -> f.toString().endsWith(".html"))
                    .forEach(System.out::println);
            
            
            //// listar todo o conteudo dos arquivos filtrados (nao compila)
            //Files.list(tmp)
            //        .filter(f -> f.toString().endsWith(".html"))
            //        .map(f -> Files.lines(f))
            //        .forEach(System.out::println);
            
            
            //// listar todo o conteudo dos arquivos filtrados (com metodo estatico - compila)
            
            Files.list(tmp)
                    .filter(f -> f.toString().endsWith(".html"))
                    .map(f -> lines(f))
                    .forEach(System.out::println);
            
            // saída:
            
            // java.util.stream.ReferencePipeline$Head@30f39991
            // java.util.stream.ReferencePipeline$Head@452b3a41
            // java.util.stream.ReferencePipeline$Head@4a574795
            
            
            //// usando o flatMap para converter Stream de Stream em simplesmente Stream
            
            Files.list(tmp)
                    .filter(f -> f.toString().endsWith(".html"))
                    .flatMap(f -> lines(f))
                    .forEach(System.out::println);
            
            
        } catch (IOException ex) {ex.printStackTrace(); }
        
        
    }
    
    static Stream<String> lines(Path p) {
        try {
            return Files.lines(p);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}

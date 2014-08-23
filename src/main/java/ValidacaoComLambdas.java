

public class ValidacaoComLambdas {

    public static void main(String[] args) {
        
        {   //// com classe anonima
        
            Validador<String> validadorCep = new Validador<String>() {
                public boolean valida(String s) {
                    return s.matches("\\d{8}");
                }
            };
        
            System.out.println(validadorCep.valida("12345126"));
        }
        
        {   //// com lambda
        
            Validador<String> validadorCep = cep -> cep.matches("\\d{8}");

            System.out.println(validadorCep.valida("12345126"));
        }
        
        
    }
}

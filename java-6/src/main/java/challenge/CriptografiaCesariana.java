package challenge;

public class CriptografiaCesariana implements Criptografia {
    
    private byte chaveCripto = 3;
    private byte chaveDescripto = -3;

    public String alterarTexto(String texto, byte chave) {
        String textoMinus = texto.toLowerCase();
        String novoTexto = "";
        for (int i = 0; i < textoMinus.length(); i++) {
        //Sobre o isDigit e isWhiteSpace https://docs.oracle.com/javase/6/docs/api/java/lang/Character.html#isDigit%28char%29
            if (!Character.isDigit(textoMinus.charAt(i)) && !Character.isWhitespace(textoMinus.charAt(i))) {
                novoTexto += (char) (textoMinus.charAt(i) + chave);
            } else {
                novoTexto += textoMinus.charAt(i);
            }
        }
        return novoTexto;
    }

    //Método para verificação do texto inserido seguindo a sugestão de Luiz Fernandes de Oliveira
    public void verificarTexto(String texto) {
        if (texto.isEmpty()) throw new IllegalArgumentException("O campo de texto está vazio.");
        if (texto == null) throw new NullPointerException("O texto inserido é inválido.");
    }

    @Override
    public String criptografar(String texto) {
        this.verificarTexto(texto);
        return this.alterarTexto(texto, chaveCripto);
    }

    @Override
    public String descriptografar(String texto) {
        this.verificarTexto(texto);
        return this.alterarTexto(texto, chaveDescripto);
    }
}

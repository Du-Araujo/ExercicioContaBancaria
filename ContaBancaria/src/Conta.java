public class Conta {

    private int nConta;
    private  String nome;

    private String cidade;


    private double valor;

    // get - set


    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getnConta() {
        return nConta;
    }

    public void setnConta(int nConta) {
        this.nConta = nConta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {return valor; }

    public void setValor(double valor) {
        this.valor = valor;
    }

    // Metodos

    public boolean registrarDeposito(int vlrDeposito){
        if (vlrDeposito > 0){
            valor += vlrDeposito;
            return true;
        }
        return false;
    }

    public boolean registrarSaque(int vlrSaque){
        if(valor < vlrSaque){
            return false;
        }
        else if (valor <= valor){
            valor -= vlrSaque;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return  "============================ \n" +
                "DADOS DA CONTA \n" +
                "Numero da Conta: " + nConta + "\n"+
                "Cliente: " + nome + "\n" +
                "Cidade: " + cidade + "\n" +
                "Saldo R$: " + valor + "\n" +
                "============================ \n";
    }
}
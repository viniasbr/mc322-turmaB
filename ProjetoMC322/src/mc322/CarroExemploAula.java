package mc322;

public class CarroExemploAula {
    private String marca;
    private String cor;
    private String placa;
    private int velocidadeAtual;
    private char marchaAtual;
    private boolean freioDeMaoPuxado;
    private boolean chaveVirada; 
    private static int numCarros = 0;

    public CarroExemploAula (String aMarca, String aCor, String valorPlaca)
    {
        marca = aMarca;
        cor = aCor;
        placa = valorPlaca;
        ++numCarros;
    }

    public void ligarCarro(){
        if(chaveVirada == true){
            return;
        }
        chaveVirada = true;
        freioDeMaoPuxado = false;
        marchaAtual = 'N';
        velocidadeAtual = 0;
    }

    public void parar(){
        if(chaveVirada == false){
            return;
        }
        marchaAtual = 'N';
        freioDeMaoPuxado = true;
        velocidadeAtual = 0;
        chaveVirada = false;
    }

    public void acelerarAte(int novaVelocidade){
        if(novaVelocidade < 0){
            return;
        }
        velocidadeAtual = novaVelocidade;
        return;
    }

    public void mudarMarcha(char novaMarcha){
        if(novaMarcha != 'N' && novaMarcha != '1' && novaMarcha != '2' && novaMarcha != '3' && novaMarcha != '4' && novaMarcha != '5'&& novaMarcha != 'R'){
            return;
        }
        marchaAtual = novaMarcha;
        return;
    }

    public String toString(){
        String str;
        //Incompleto
        str = "Teste";
        return str;
    }

    public String getMarca() {
        return marca;
    }

    public String getCor() {
        return cor;
    }

    public String getPlaca() {
        return placa;
    }

    public int getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public char getMarchaAtual() {
        return marchaAtual;
    }

    public boolean isFreioDeMaoPuxado() {
        return freioDeMaoPuxado;
    }

    public boolean isChaveVirada() {
        return chaveVirada;
    }

    public static int getNumCarros() {
        return numCarros;
    }
    
}

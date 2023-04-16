package lab03;
import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String endereco;
    private ArrayList<Veiculo> listaVeiculos;

    public Cliente(String nome, String endereco, Veiculo veiculo) {
        this.nome = nome;
        this.endereco = endereco;
        listaVeiculos.add(veiculo);
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }
    public boolean addVeiculo(Veiculo veiculo) {
        boolean estaNaLista = false;
        for(Veiculo v: listaVeiculos)
        {
            if(v.getPlaca() == veiculo.getPlaca())
            {
                estaNaLista = true;
                return !estaNaLista;
            }
        }
        listaVeiculos.add(veiculo);
        return !estaNaLista;
    }
    public Veiculo getVeiculo(int i) {
        return listaVeiculos.get(i);
    }
    public String toString() {
        String saida = "Informações do Cliente:\n"
        +"\n    Nome: " + nome
        +"\n    Endereço: " + endereco
        +"\n    Veiculo(s): ";
        for(Veiculo v: listaVeiculos)
        {
            saida = saida + "         " + v.getMarca() +" "+ v.getModelo() + " " + v.getAnoFabricacao() + ", Placa: " + v.getPlaca() +"\n";
        }
        saida = saida + "\n";
        return saida;
    }
    public String tipoDeCliente()
    {
        return "N/A";
    }
}

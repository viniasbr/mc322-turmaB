package lab03;
import java.util.ArrayList;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Cliente> listaClientes;

    public Seguradora(String nome, String telefone, String email, String endereco) {
        this.listaClientes = new ArrayList<Cliente>();
        this.listaSinistros = new ArrayList<Sinistro>();
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }
    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
    public boolean cadastrarCliente(Cliente cliente){ //Retorna true se foi possivel cadastrar o cliente, retorna false se o cliente já estava cadastrado.
        boolean estaNaLista = false;
        for(Cliente c: listaClientes)
        {
            if(c.equals(cliente))
            {
                estaNaLista = true;
                return !estaNaLista;
            }
        }
        listaClientes.add(cliente);
        return !estaNaLista;
    }
    public boolean removerCliente(Cliente cliente){ //Retorna true se foi possivel remover o cliente, retorna false se o cliente não estava cadastrado.
        boolean estaNaLista = false;
        for(int i = 0; i < listaClientes.size(); i++)
        {
            if(listaClientes.get(i).equals(cliente))
            {
                estaNaLista = true;
                listaClientes.remove(i);
                break;
            }
        }
        return estaNaLista;
    }
    public String listarClientes(String tipoCliente) //Recebe "PF" ou "PJ"
    {
        String saida = "";
        for(Cliente c: listaClientes)
        {
            if(c.tipoDeCliente() == tipoCliente)
            {
                saida = saida + c.toString();
            }
        }
        return saida;
    }
    public boolean gerarSinistro(Sinistro sinistro){//Retorna true se foi possivel gerar o sinistro, retorna false se o sinistro já estava gerado.
        boolean estaNaLista = false;
        for(Sinistro s: listaSinistros)
        {
            if(s.getId() == sinistro.getId())//Compara identificador unico
            {
                estaNaLista = true;
                return !estaNaLista;
            }
        }
        listaSinistros.add(sinistro);
        return !estaNaLista;
    }
    public boolean visualizarSinistro(String cliente)//O enunciado especifica que esse método deve ter retorno booleano, assim, assume-se que ele confirma ou nega se o cliente possui sinistro
    {
        boolean estaNaLista = false;
        for(Cliente c: listaClientes)
        {
            if(c.getNome().equalsIgnoreCase(cliente))
            {
                estaNaLista = true;
                break;
            }
        }
        return estaNaLista;
    }
    public String listarSinistros()
    {
        String saida = "";
        for(Sinistro s: listaSinistros)
        {
            saida = saida + s.toString();
        }
        return saida;
    }
}

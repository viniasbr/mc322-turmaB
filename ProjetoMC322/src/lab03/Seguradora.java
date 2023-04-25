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
            if(cliente.tipoDeCliente().equals("PF") && c.tipoDeCliente().equals("PF"))//Caso o Cliente seja ClientePF, faz-se um typecast e compara os cpfs
            {
                ClientePF c1,c2;
                c1 = (ClientePF)c;
                c2 = (ClientePF)cliente;
                if(c1.getCpf().equals(c2.getCpf()))
                {
                    estaNaLista = true;
                    return !estaNaLista;
                }
            }
            else if(cliente.tipoDeCliente().equals("PJ") && c.tipoDeCliente().equals("PJ"))//Caso o Cliente seja ClientePJ, faz-se um typecast e compara os cnpjs
            {
                ClientePJ c1,c2;
                c1 = (ClientePJ)c;
                c2 = (ClientePJ)cliente;
                if(c1.getCnpj().equals(c2.getCnpj()))
                {
                    estaNaLista = true;
                    return !estaNaLista;
                }
            }
            else if(c.equals(cliente))//Caso Cliente não seja nem ClientePF nem ClientePJ (um caso que não é pra acontecer), apenas determina-se a igualdade dos objetos
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
            if(listaClientes.get(i).tipoDeCliente().equals("PF") && cliente.tipoDeCliente().equals("PF"))//Caso o Cliente seja ClientePF, faz-se um typecast e compara os cpfs
            {
                ClientePF c1,c2;
                c1 = (ClientePF)listaClientes.get(i);
                c2 = (ClientePF)cliente;
                if(c1.getCpf().equals(c2.getCpf()))
                {
                    estaNaLista = true;
                    listaClientes.remove(i);
                    break;
                }
            }
            if(listaClientes.get(i).tipoDeCliente().equals("PJ") && cliente.tipoDeCliente().equals("PJ"))//Caso o Cliente seja ClientePJ, faz-se um typecast e compara os cnpjs
            {
                ClientePJ c1,c2;
                c1 = (ClientePJ)listaClientes.get(i);
                c2 = (ClientePJ)cliente;
                if(c1.getCnpj().equals(c2.getCnpj()))
                {
                    estaNaLista = true;
                    listaClientes.remove(i);
                    break;
                }
            }
            else if(listaClientes.get(i).equals(cliente))//Caso Cliente não seja nem ClientePF nem ClientePJ (um caso que não é pra acontecer), apenas determina-se a igualdade dos objetos
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
            if(c.tipoDeCliente().equals(tipoCliente))
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
    @Override
    public String toString() {
        return "Informações da Seguradora:\n"
        +"\n    Nome: " +getNome()
        +"\n    Telefone: " +getTelefone()
        +"\n    Email: " +getEmail()
        +"\n    Endereço: " +getEndereco()
        +"\n    Clientes de Pessoa Física:\n    " +listarClientes("PF")
        +"\n    Clientes de Pessoa Jurídica:\n    " +listarClientes("PJ")
        +"\n    Sinistros:\n    " +listarSinistros()
        +"\n\n";
    }
    
}

package mc322;

public class Cliente {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private int idade;
    private String endereco;

    

    public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.endereco = endereco;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public boolean validarCPF(){
        String cpflimpo;
        cpflimpo = cpf.replaceAll("[^0123456789]","");
        if (cpflimpo.length() != 11)
        {
            return false;
        }
        if (cpflimpo.equals("00000000000") || cpflimpo.equals("11111111111") 
        || cpflimpo.equals("22222222222") || cpflimpo.equals("33333333333") 
        || cpflimpo.equals("44444444444") || cpflimpo.equals("55555555555")
        || cpflimpo.equals("66666666666") || cpflimpo.equals("77777777777")
        || cpflimpo.equals("88888888888") || cpflimpo.equals("99999999999"))
        {
            return false;
        }
        int [] digitos = {0,0,0,0,0,0,0,0,0,0,0};
        for(int i = 0; i < 11; i++)
        {
            digitos[i] = Character.getNumericValue(cpflimpo.charAt(i));
        }
        int [] temp = {0,0,0,0,0,0,0,0,0,0};
        for(int i = 0; i < 9; i++)
        {
            temp[i] = digitos[i]*(10-i);
        }
        int primeiroDividendo = 0;
        int primeiroDigito = -1; //dummy do primeiro digito
        for(int i = 0; i < 9; i++)
        {
            primeiroDividendo = primeiroDividendo + temp[i];
        }
        if(primeiroDividendo % 11 < 2)
        {
            primeiroDigito = 0;
        }
        else if(primeiroDividendo % 11 >= 2)
        {
            primeiroDigito = 11 - (primeiroDividendo % 11);
        }
        for(int i = 0; i < 9; i++)
        {
            temp[i] = digitos[i]*(11-i);
        }
        temp[9] = primeiroDigito*2;
        int segundoDividendo = 0;
        int segundoDigito = -1; //dummy do segundo digito
        for(int i = 0; i < 10; i++)
        {
            segundoDividendo = segundoDividendo + temp[i];
        }
        if(segundoDividendo % 11 < 2)
        {
            segundoDigito = 0;
        }
        else if(segundoDividendo % 11 >= 2)
        {
            segundoDigito = 11 - (segundoDividendo % 11);
        }
        if(digitos[9] == primeiroDigito && digitos[10] == segundoDigito)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public String toString() {
        String saida = "Informações do Cliente\n\n    Nome = " + nome + "\n    CPF = " + cpf + "\n    Data de Nascimento = " + dataNascimento + "\n    Idade = " + idade
                + "\n    Endereço = " + endereco;
        if(validarCPF())
        {
            return saida + "\n    Validez do CPF: Válido\n\n";
        }
        return saida + "\n    Validez do CPF: Inválido\n\n";
    }
    
}

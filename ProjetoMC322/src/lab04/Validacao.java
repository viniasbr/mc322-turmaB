package lab04;

public class Validacao {

    public static boolean validaCPF(String cpf)
    {
        String cpflimpo;
        cpflimpo = cpf.replaceAll("[^0123456789]","");//Remove caracteres especiais do CPF
        if (cpflimpo.length() != 11) //Confere numero de caracteres
        {
            return false;
        }
        if (cpflimpo.equals("00000000000") || cpflimpo.equals("11111111111") 
        || cpflimpo.equals("22222222222") || cpflimpo.equals("33333333333") 
        || cpflimpo.equals("44444444444") || cpflimpo.equals("55555555555")
        || cpflimpo.equals("66666666666") || cpflimpo.equals("77777777777")
        || cpflimpo.equals("88888888888") || cpflimpo.equals("99999999999")) //Confere se os caracteres são iguais
        {
            return false;
        }
        int [] digitos = new int[11];
        for(int i = 0; i < 11; i++) //Transforma o CPF em um vetor de int
        {
            digitos[i] = Character.getNumericValue(cpflimpo.charAt(i));
        }
        int [] temp = new int[10];
        for(int i = 0; i < 9; i++) //Multiplica cada digito pelos fatores 
        {
            temp[i] = digitos[i]*(10-i);
        }
        int primeiroDividendo = 0;
        int primeiroDigito = -1; //dummy do primeiro digito
        for(int i = 0; i < 9; i++) //Produz o dividendo do primeiro digito verificador
        {
            primeiroDividendo = primeiroDividendo + temp[i];
        }
        if(primeiroDividendo % 11 < 2) //Define o primeiro digito verificador
        {
            primeiroDigito = 0;
        }
        else if(primeiroDividendo % 11 >= 2)
        {
            primeiroDigito = 11 - (primeiroDividendo % 11);
        }
        for(int i = 0; i < 9; i++) //Preenche temp com os digitos multiplicados por fatores
        {
            temp[i] = digitos[i]*(11-i);
        }
        temp[9] = primeiroDigito*2; //Adiciona o primeiro digito de verificação ja multiplicado
        int segundoDividendo = 0;
        int segundoDigito = -1; //dummy do segundo digito
        for(int i = 0; i < 10; i++) //Produz o dividendo do segundo digito
        {
            segundoDividendo = segundoDividendo + temp[i];
        }
        if(segundoDividendo % 11 < 2) //Define o segundo digito verificador
        {
            segundoDigito = 0;
        }
        else if(segundoDividendo % 11 >= 2)
        {
            segundoDigito = 11 - (segundoDividendo % 11);
        }
        if(digitos[9] == primeiroDigito && digitos[10] == segundoDigito) //Compara os digitos produzidos com os digitos do CPF
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static boolean validaCNPJ(String cnpj)
    {
        String cnpjlimpo;
        cnpjlimpo = cnpj.replaceAll("[^0123456789]","");//Remove caracteres especiais do CNPJ
        if(cnpjlimpo.length() != 14)
        {
            return false;
        }
        if(cnpjlimpo.equals("00000000000000")|| //Confere se os digitos são iguais
        cnpjlimpo.equals("11111111111111")||
        cnpjlimpo.equals("22222222222222")||
        cnpjlimpo.equals("33333333333333")||
        cnpjlimpo.equals("44444444444444")||
        cnpjlimpo.equals("55555555555555")||
        cnpjlimpo.equals("66666666666666")||
        cnpjlimpo.equals("77777777777777")||
        cnpjlimpo.equals("88888888888888")||
        cnpjlimpo.equals("99999999999999"))
        {
            return false;
        }
        int[] digitos = new int[14];
        for(int i = 0; i < 14; i++) //Transforma o CNPJ em um vetor de int
        {
            digitos[i] = Character.getNumericValue(cnpjlimpo.charAt(i));
        }
        int[] temp = new int[13];
        int[] fatores1 = {5,4,3,2,9,8,7,6,5,4,3,2};
        for(int i = 0; i < 12; i++) //Multiplica cada digito pelos fatores 
        {
            temp[i] = digitos[i]*fatores1[i];
        }
        int primeiroDividendo = 0;
        int primeiroDigito = -1; //dummy do primeiro digito
        for(int i = 0; i < 12; i++) //Produz o dividendo do primeiro digito verificador
        {
            primeiroDividendo = primeiroDividendo + temp[i];
        }
        if(primeiroDividendo % 11 < 2) //Define o primeiro digito verificador
        {
            primeiroDigito = 0;
        }
        else if(primeiroDividendo % 11 >= 2)
        {
            primeiroDigito = 11 - (primeiroDividendo % 11);
        }
        int[] fatores2 = {6,5,4,3,2,9,8,7,6,5,4,3,2};
        for(int i = 0; i < 12; i++) //Preenche temp com os digitos multiplicados por fatores
        {
            temp[i] = digitos[i]*fatores2[i];
        }
        temp[12] = primeiroDigito*fatores2[12]; //Adiciona o primeiro digito de verificação ja multiplicado
        int segundoDividendo = 0;
        int segundoDigito = -1; //dummy do segundo digito
        for(int i = 0; i < 13; i++) //Produz o dividendo do segundo digito
        {
            segundoDividendo = segundoDividendo + temp[i];
        }
        if(segundoDividendo % 11 < 2) //Define o segundo digito verificador
        {
            segundoDigito = 0;
        }
        else if(segundoDividendo % 11 >= 2)
        {
            segundoDigito = 11 - (segundoDividendo % 11);
        }
        if(digitos[12] == primeiroDigito && digitos[13] == segundoDigito) //Compara os digitos produzidos com os digitos do CPF
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static boolean validaNome(String nome)
    {
        String complementarDoNome;
        complementarDoNome = nome.replaceAll("[a-z[A-Z][ ][À-ÿ]]", "");
        if(complementarDoNome.equals(""))
            return true;
        else
            return false;
    }
    public static boolean validaInt(String numero)
    {
        try {
            Integer.parseInt(numero);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}

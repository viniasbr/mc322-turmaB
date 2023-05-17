package lab04;

public class Intervalo { //Define um intervalo fechado-aberto a partir de dois inteiros
    private int min;
    private int max;

    public Intervalo()
    {
        min = 0;
        max = 0;
    }
    public Intervalo(int min, int max)
    {
        this.min = min;
        this.max = max;
    }
    public static Intervalo definidoPor(int min, int max)
    {
        Intervalo intervalo = new Intervalo(min, max);
        return intervalo;
    }
    public boolean contem(int i)
    {
        if( i >= min && i < max)
            return true;
        else
            return false;
    }
}

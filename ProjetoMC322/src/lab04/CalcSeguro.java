package lab04;

public enum CalcSeguro {
    VALOR_BASE ((float)100.0),
    FATOR_18_30 ((float)1.2),
    FATOR_30_60 ((float)1.0),
    FATOR_60_90 ((float)1.5);

    private final float fator;

    CalcSeguro(float fator)
    {
        this.fator = fator;
    }
    public float fator() {
        return fator;
    }
    
}

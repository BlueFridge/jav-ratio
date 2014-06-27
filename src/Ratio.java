public class Ratio
{
    private int numerator;
    private int denominator;
    
    //Constructor with separate args for n & d
    public Ratio(int n, int d)
    {
        this(String.valueOf(n)+"/"+String.valueOf(d));
    }
    
    //Constructor with ratio as string
    public Ratio(String rat)
    {
        String[] ratio = rat.split("/");
        numerator = Integer.parseInt(ratio[0]);
        denominator = Integer.parseInt(ratio[1]);
        
        //Simplify
        int hcf = getHCF(numerator, denominator);
        numerator /= hcf;
        denominator /= hcf;
    }
    
    //Return a ratio type of the string
    public static Ratio valueOf(String rat)
    {
        String[] ratio = rat.split("/");
        Ratio res = new Ratio(Integer.parseInt(ratio[0]), Integer.parseInt(ratio[1]));
        return res;
    }
    
    //Return a ratio type given two integers
    public static Ratio valueOf(int n, int d)
    {
        Ratio res = new Ratio(n, d);
        return res;
    }
    
    //Get the ratio as a string
    public String getRatio()
    {
        String num_asStr = String.valueOf(numerator);
        String den_asStr = String.valueOf(denominator);
        return num_asStr+"/"+den_asStr;
    }
    
    //Get the ratio as a decimal
    public double toDecimal()
    {
        return (numerator*1.0)/(denominator*1.0);
    }
    
    //Get the numerator
    public int getNumerator()
    {
        return numerator;
    }
    
    //Get the denominator
    public int getDenominator()
    {
        return denominator;
    }
    
    //Multiply two ratios
    public Ratio multiply(Ratio rat)
    {
        int new_num = numerator*rat.getNumerator();
        int new_den = denominator*rat.getDenominator();
        Ratio result = new Ratio(new_num, new_den);
        return result;
    }
    
    //Divide two ratios
    public Ratio divide(Ratio rat)
    {
        int new_num = numerator*rat.getDenominator();
        int new_den = denominator*rat.getNumerator();
        Ratio result = new Ratio(new_num, new_den);
        return result;
    }
    
    //Add two ratios
    public Ratio add(Ratio rat)
    {
        int new_den = denominator*rat.getDenominator();
        int a = ((new_den/denominator)*numerator);
        int b = ((new_den/rat.getDenominator())*rat.getNumerator());
        int new_num = a+b;
        Ratio result = new Ratio(new_num, new_den);
        return result;
    }
    
    //Subtract two ratios
    public Ratio subtract(Ratio rat)
    {
        int new_den = denominator*rat.getDenominator();
        int a = ((new_den/denominator)*numerator);
        int b = ((new_den/rat.getDenominator())*rat.getNumerator());
        int new_num = a-b;
        Ratio result = new Ratio(new_num, new_den);
        return result;
    }
    
    //Check greater than
    public boolean isGreaterThan(Ratio rat)
    {
        double self = (numerator*1.0)/(denominator*1.0);
        double rat_decimal = rat.toDecimal();
        return self > rat_decimal;
    }
    
    //Check is less than
    public boolean isLessThan(Ratio rat)
    {
        double self = (numerator*1.0)/(denominator*1.0);
        double rat_decimal = rat.toDecimal();
        return self < rat_decimal;
    }
    
    //Check equal to
    public boolean isEqualTo(Ratio rat)
    {
        double self = (numerator*1.0)/(denominator*1.0);
        double rat_decimal = rat.toDecimal();
        return self == rat_decimal;
    }
    
    //Gets the HCF of two integers
    private int getHCF(int a, int b)
    {
        int rem = -1;
        
        while(rem != 0)
        {
            rem = a%b;
            a = b;
            b = rem;
        }
        
        return a;
    }
}
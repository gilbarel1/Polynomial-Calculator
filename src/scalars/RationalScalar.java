package scalars;
public class RationalScalar extends Scalar {
    private int numerator;
    private int denominator;
    public RationalScalar(int N, int D){
        if (D == 0){
            throw new IllegalArgumentException("Can't divide by zero.");
        }
        this.denominator = D;
        this.numerator = N;
        if(D < 0){
            this.numerator = -1 * numerator;
            this.denominator = -1 * denominator;
        }
    }
    protected int getNumerator(){
        return numerator;
    }
    protected int getDenominator(){
        return denominator;
    }

    public Scalar add(Scalar s) {
        return s.addRational(this);
    }


    public Scalar addRational (RationalScalar r){
        int newNumerator = numerator * r.getDenominator() + r.getNumerator() * denominator;
        int newDenominator = denominator * r.getDenominator();
        RationalScalar ans = new RationalScalar(newNumerator, newDenominator);
        return ans.reduce();
    }

    protected Scalar addInteger(IntegerScalar i) {
        RationalScalar r = new RationalScalar(i.getNumber() * denominator,denominator);
        return this.addRational(r);
    }


    public Scalar mul(Scalar s){
        return s.mulRational(this);
    }
    public Scalar mulRational(RationalScalar r){
        int newNumerator = numerator * r.getNumerator();
        int newDenominator = denominator * r.getDenominator();
        RationalScalar ans = new RationalScalar(newNumerator, newDenominator);
        return ans.reduce();
    }
    protected Scalar mulInteger(IntegerScalar i) {
        int newNumerator = i.getNumber() * numerator;
        RationalScalar ans = new RationalScalar(newNumerator, denominator);
        return ans.reduce();
    }

    public Scalar neg() {
        int newNumerator = -1 *numerator;
        return new RationalScalar(newNumerator, denominator).reduce();
    }


    public Scalar power(int exponent) {
        int n = 1;
        int d = 1;
        for(int i = 0; i < Math.abs(exponent); i++){
            n = n * numerator;
            d = d * denominator;
        }
        RationalScalar r;
        if(exponent < 0)
            r = new RationalScalar(d,n);
        else
            r = new RationalScalar(n,d);
        return r.reduce();

    }
    public int sign() {
        if(numerator==0){
            return 0;
        }
        else if(numerator*denominator < 0){
            return -1;
        }
        else{
            return 1;
        }

    }

    public RationalScalar reduce(){
        if (numerator < 0 & denominator < 0){
            numerator *= -1;
            denominator *= -1;
        }
        int divisor = GCD(numerator,denominator);
        RationalScalar r = new RationalScalar(numerator/divisor, denominator/divisor);
        return r;
    }

    public int GCD(int k, int p){
        while (p != 0) {
            int temp = p;
            p = k % p;
            k = temp;
        }
        return Math.abs(k);
    }

    public String toString(){
        RationalScalar r = this.reduce();
        String ans = "";
        if(numerator == 0){
            return "0";
        }
        if (r.denominator == 1){
            ans += r.numerator;
            return ans;
        }
        else{
            ans = r.numerator + "/" + r.denominator;
            return ans;
        }
    }
}
package scalars;
public class IntegerScalar extends Scalar {
    private int number;
    public int getNumber(){
        return this.number;
    }
    public IntegerScalar(int n){
        this.number = n;
    }
    public Scalar add (Scalar s){
        return s.addInteger(this);
    }
    public Scalar addInteger(IntegerScalar s){
        return new IntegerScalar(this.number + s.number);
    }
    public Scalar mul (Scalar s){
        return s.mulInteger(this);
    }
    public Scalar mulInteger(IntegerScalar i){
        return new IntegerScalar(this.number * i.number);
    }

    public Scalar mulRational(RationalScalar r){
        return new RationalScalar(this.number * r.getNumerator(), r.getDenominator());
    }

    public Scalar addRational(RationalScalar r){
        return new RationalScalar(this.number*r.getDenominator() + r.getNumerator(), r.getDenominator());
    }

    public Scalar neg() {
        return new IntegerScalar(this.number * -1);
    }
    public Scalar power(int exponent) {
        int ans = 1;
        for (int n = 0; n < Math.abs(exponent); n = n + 1){
            ans *= this.number;
        }
        if(exponent >= 0) {
            Scalar res = new IntegerScalar(ans);
            return res;
        }
        else {
            Scalar res = new RationalScalar(1, ans);
            return new RationalScalar(1, ans).reduce();
        }
    }
    public int sign() {
        if(this.number > 0)
            return 1;
        else if (this.number < 0)
            return -1;
        else
            return 0;
    }

    public String toString(){
        String ans = "";
        return ans + this.number;
    }

}

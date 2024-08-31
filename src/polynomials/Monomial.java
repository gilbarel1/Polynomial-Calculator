package polynomials;
import scalars.IntegerScalar;
import scalars.Scalar;


public class Monomial {
    private int exponent;
    private Scalar coefficient;
    public Monomial(int exp, Scalar coe){
        if(exp < 0)
            throw new IllegalArgumentException("The exponent must be non-negative!");
        this.exponent = exp;
        this.coefficient = coe;
    }

    public Scalar getCoefficient(){
        return this.coefficient;
    }

    public int getExponent(){
        return this.exponent;
    }

    public Monomial add(Monomial m){
        Scalar zero = new IntegerScalar(0);
        Monomial newMonom;
        if(m.exponent != this.exponent & (!coefficient.equals(zero) & !m.coefficient.equals(zero)))
            return null;
        else if (coefficient.equals(zero)){
            newMonom = new Monomial(m.exponent, coefficient.add(m.getCoefficient()));
        }
        else if (m.coefficient.equals(zero)) {
            newMonom = new Monomial(exponent, coefficient.add(m.getCoefficient()));
        }
        else{
            newMonom = new Monomial(exponent, coefficient.add(m.getCoefficient()));
        }
        return newMonom;
    }
    public Monomial mul(Monomial m){
        Monomial ans = new Monomial(this.exponent + m.getExponent(), this.coefficient.mul(m.getCoefficient()));
        return ans;
    }
    public  Scalar evaluate(Scalar s){
        return s.power(exponent).mul(coefficient);
    }
    public Monomial derivative(){
        if(exponent == 0)
            return new Monomial(0, new IntegerScalar(0));
        Scalar exp = new IntegerScalar(exponent);
        Monomial derivative = new Monomial( exponent-1, coefficient.mul(exp));
        return derivative;
    }
    public int sign(){
        return coefficient.sign();
    }

    public boolean equals(Object o){
        return o.toString().equals(this.toString());
    }

    public String toString(){
        String ans;
        if (exponent == 0)
            ans = coefficient.toString();
        else if(coefficient.toString().equals("0"))
            ans = "0";
        else if(coefficient.toString().equals("1")) {
            if (exponent == 1)
                ans = "x";
            else
                ans = "x^" + exponent;
        }
        else if(exponent == 1)
            ans = coefficient.toString()+"x";
        else if(coefficient.toString().equals("-1"))
            ans = "-x^"+exponent;
        else
            ans = coefficient.toString()+"x^"+exponent;

        return ans;
    }
}

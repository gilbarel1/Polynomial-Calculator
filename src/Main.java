import polynomials.*;
import scalars.*;
import scalars.IntegerScalar;
import polynomials.Polynomial;

import javax.xml.transform.stream.StreamSource;

public class Main {
    public static void main(String[] args) {
        Scalar i0 = new IntegerScalar(0);
        Scalar one = new IntegerScalar(1);
        Scalar i2 = new IntegerScalar(2);
        Scalar iN2 = new IntegerScalar(-2);
        Scalar ri1 = new RationalScalar(-1,2);
        Scalar ri2 = new RationalScalar(2,3);
        Monomial m0 = new Monomial(2,i0);
        Monomial monomOne = new Monomial(0,one);
        Monomial m1 = new Monomial(0,i2);
        Monomial  m2 = new Monomial(3,ri1);
        Monomial  m3 = new Monomial(3,ri2);
        Monomial m4 = new Monomial(2,i2);
        Monomial m5 = new Monomial(3,ri2);
        Polynomial p1 = Polynomial.build("0  1 1/2 1/3   1/4   1/5");
        Polynomial p2 = Polynomial.build("3  0 0  0  0 0");
        Polynomial p3 = Polynomial.build("0  2  3/2");
        Polynomial p4 = Polynomial.build("0 0  0 2/3");

        System.out.println(p4.derivative());


    }
}
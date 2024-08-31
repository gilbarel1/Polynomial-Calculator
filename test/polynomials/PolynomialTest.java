package polynomials;

import org.junit.jupiter.api.Test;
import scalars.IntegerScalar;
import scalars.RationalScalar;
import scalars.Scalar;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {

    Polynomial p1 = Polynomial.build("0  1 1/2 1/3   1/4   1/5");
    Polynomial p2 = Polynomial.build("3  0 0  0  0 0");
    Polynomial p3 = Polynomial.build("0  2  3/2");
    Polynomial p4 = Polynomial.build("0 0  0 2/3");


    @Test
    void build() {
        assertEquals(p1.toString(),"x + 1/2x^2 + 1/3x^3 + 1/4x^4 + 1/5x^5");
        assertEquals(p2.toString(),"3");
        assertEquals(p3.toString(),"2x + 3/2x^2");
        assertEquals(p4.toString(),"2/3x^3");

    }

    @Test
    void add() {
        assertEquals(p1.add(p2).toString(),"3 + x + 1/2x^2 + 1/3x^3 + 1/4x^4 + 1/5x^5");
        assertEquals(p1.add(p3).toString(),"3x + 2x^2 + 1/3x^3 + 1/4x^4 + 1/5x^5" );
    }

    @Test
    void mul() {
        assertEquals(p3.mul(p4).toString(),"4/3x^4 + x^5");
        assertEquals(p2.mul(p1).toString(),"3x + 3/2x^2 + x^3 + 3/4x^4 + 3/5x^5");
    }

    @Test
    void evaluate() {
        assertEquals(p2.evaluate(new IntegerScalar(100)), 3);
        assertEquals(p1.evaluate(new IntegerScalar(2)),new RationalScalar(256,15).toString() );
    }

    @Test
    void derivative() {
        assertEquals(p1.derivative().toString(),"1 + x + x^2 + x^3 + x^4");
        assertEquals(p2.derivative().toString(),"0");
        assertEquals(p4.derivative().toString(),"2x^2");
    }

}
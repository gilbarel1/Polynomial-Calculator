package polynomials;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import scalars.IntegerScalar;
import scalars.RationalScalar;
import scalars.Scalar;

import static org.junit.jupiter.api.Assertions.*;

class MonomialTest {
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





    @Test
    void testMonomialBuilder() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Monomial m = new Monomial(-1, i2);
            }
        });

    }

    @Test
    void testGetCoefficient() {
        assertEquals(m1.getCoefficient(),i2);
        assertEquals(m2.getCoefficient(),ri1);
        assertEquals(m0.getCoefficient(),i0);
    }

    @Test
    void getExponent() {
        assertEquals(m1.getExponent(),0);
        assertEquals(m2.getExponent(),3);
        assertEquals(m0.getExponent(),2);
    }

    @Test
    void notTheSameExpoTestAdd() {
        assertNull(m1.add(m2));
    }
    @Test
    void TestAdd() {
        Monomial sum1 = m2.add(m3);
        Monomial sum2 = m0.add(m4);
        Monomial sum3 = m0.add(m1);
        Monomial sum4 = m3.add(m0);
        assertEquals(sum1.toString(),"1/6x^3");
        assertEquals(sum2.toString(),"2x^2");
        assertEquals(sum3.toString(),"2");
        assertEquals(sum4.toString(),"2/3x^3");
    }

    @Test
    void mul() {
        assertEquals(m0.mul(m3).toString(),"0");
        assertEquals(monomOne.mul(m4).toString(),"2x^2");
        assertEquals(m3.mul(m4).toString(),"4/3x^5");
        assertEquals(m2.mul(m3).toString(),"-1/3x^6");
    }


    @Test
    void evaluate() {
        Scalar ans3 = new RationalScalar(-16,3);
        assertEquals(m0.evaluate(ri1),0);
        assertEquals(m4.evaluate(i0),0);
        assertEquals(m3.evaluate(iN2),ans3);

    }

    @Test
    void derivative() {
        assertEquals(m0.derivative(),0);
        assertEquals(m1.derivative(),0);
        assertEquals(m4.derivative().toString(),"4x");
        assertEquals(m5.derivative().toString(),"2x^2");

    }

    @Test
    void sign() {
        assertEquals(m0.sign(),0);
        assertEquals(m2.sign(),-1);
        assertEquals(m3.sign(),1);
    }


}
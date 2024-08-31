package scalars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RationalScalarTest {

    RationalScalar rHalf = new RationalScalar(1,2);
    RationalScalar rHalf_sign = new RationalScalar(-1,-2);
    RationalScalar r0 = new RationalScalar(0,-2);
    RationalScalar r_eight = new RationalScalar(1,8);
    RationalScalar r1 = new RationalScalar(2,2);
    RationalScalar rHalf24 = new RationalScalar(2,4);
    RationalScalar r2 = new RationalScalar(4,2);
    RationalScalar rOneandHalf = new RationalScalar(3,2);
    RationalScalar r4_9 = new RationalScalar(4,9);
    RationalScalar rneg_third = new RationalScalar(1,-3);
    RationalScalar rneg_third1 = new RationalScalar(-1,3);
    RationalScalar r_ninth = new RationalScalar(1,9);
    RationalScalar rneg_2third = new RationalScalar(-2,3);
    RationalScalar r_neg_sixth = new RationalScalar(-1,6);
    RationalScalar r_third = new RationalScalar(1,3);
    RationalScalar r_neg_3 = new RationalScalar(-9,3);
    RationalScalar rneg3_copy = new RationalScalar(9, -3);
    IntegerScalar i1 = new IntegerScalar(1);
    IntegerScalar i2 = new IntegerScalar(2);
    IntegerScalar i9 = new IntegerScalar(9);
    IntegerScalar ineg2 = new IntegerScalar(-2);
    IntegerScalar ineg3 = new IntegerScalar(-3);

    @Test
    public void add() {
        assertEquals(r1, rHalf.add(rHalf24));
        assertEquals(rOneandHalf, i1.add(rHalf));
        assertEquals(rneg_2third, rneg_third.add(rneg_third1));
    }

    @Test
    public void mul() {
        assertEquals(i1, rHalf.mul(i2));
        assertEquals(i1, rHalf24.mul(i2));
        assertEquals(r_neg_sixth, rHalf.mul(rneg_third));
    }

    @Test
    public void neg() {
        assertEquals(rneg_third, r_third.neg());
        assertEquals(r_third, rneg_third1.neg());
        assertEquals(ineg2, r2.neg());

    }

    @Test
    public void power() {
        assertEquals(r_ninth, r_third.power(2));
        assertEquals(r_ninth, rneg_third1.power(2));
        assertEquals(i9, r_third.power(-2));
        assertEquals(r4_9, rOneandHalf.power(-2));
        assertEquals(r_eight, rHalf.power(3));
    }

    @Test
    public void sign() {
        assertEquals(1, rHalf_sign.sign());
        assertEquals(1, r_third.sign());
        assertEquals(0, r0.sign());
        assertEquals(-1, rneg_third1.sign());
        assertEquals(-1, rneg_third.sign());
    }

    @Test
    public void equals(){
        assertEquals(true, r2.equals(i2));
        assertEquals(false, rneg_third.equals(r_third));
        assertEquals(true, rHalf.equals(rHalf24));
        assertEquals(true,rHalf_sign.equals(rHalf));
        assertEquals(true, r_neg_3.equals(rneg3_copy));
    }
    @Test
    public void reduce() {
        assertEquals(rHalf, rHalf24.reduce());
        assertEquals(r_ninth, r_ninth.reduce());
        assertEquals(rHalf, rHalf_sign.reduce());
        assertEquals(ineg3,r_neg_3.reduce());
    }

    @Test
    public void testToString() {
        assertEquals("1/2",rHalf.toString());
        assertEquals("1/2",rHalf_sign.toString());
        assertEquals("1",r1.toString());
        assertEquals("1/2",rHalf24.toString());
        assertEquals("0",r0.toString());
    }
}
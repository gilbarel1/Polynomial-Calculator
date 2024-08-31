package scalars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerScalarTest {

    IntegerScalar i7 = new IntegerScalar(7);
    IntegerScalar i9 = new IntegerScalar(9);
    IntegerScalar i49 = new IntegerScalar(49);
    IntegerScalar ineg3 = new IntegerScalar(-3);
    IntegerScalar ineg27 = new IntegerScalar(-27);
    IntegerScalar i3 = new IntegerScalar(3);
    IntegerScalar i0 = new IntegerScalar(0);
    IntegerScalar i1 = new IntegerScalar(1);
    IntegerScalar i4 = new IntegerScalar(4);

    RationalScalar rhalf = new RationalScalar(1, 2);
    RationalScalar r0 = new RationalScalar(0, 3);
    RationalScalar rhalf1 = new RationalScalar(2, 4);
    RationalScalar rneg25 = new RationalScalar(-5, 2);
    RationalScalar r35 = new RationalScalar(7, 2);
    RationalScalar r127 = new RationalScalar(1, 27);
    RationalScalar r4 = new RationalScalar(4, 1);
    RationalScalar r9 = new RationalScalar(18, 2);
    @org.junit.jupiter.api.Test
    void getNumber() {
        assertEquals(7, i7.getNumber());
        assertEquals(-3, ineg3.getNumber());
        assertEquals(0, i0.getNumber());

    }
    @org.junit.jupiter.api.Test
    void add() {
        assertEquals(i4, i7.add(ineg3));
        assertEquals(i7, i7.add(i0));
        assertEquals(rneg25, ineg3.add(rhalf1));
        assertEquals(rhalf1, i0.add(rhalf1));
    }



    @org.junit.jupiter.api.Test
    void mul() {
        assertEquals(i0, i7.mul(i0));
        assertEquals(i4, i4.mul(i1));
        assertEquals(r35, i7.mul(rhalf));
        assertEquals(r35, i7.mul(rhalf1));
        assertEquals(i0, rneg25.mul(i0));
        assertEquals(i7, i7.mul(i1));
    }


    @org.junit.jupiter.api.Test
    void neg() {
        assertEquals(ineg3, i3.neg());
        assertEquals(i3, ineg3.neg());
        assertEquals(i0, i0.neg());
    }

    @org.junit.jupiter.api.Test
    void power() {
        assertEquals(i49, i7.power(2));
        assertEquals(i9, ineg3.power(2));
        assertEquals(ineg27, ineg3.power(3));
        assertEquals(r127, i3.power(-3));
        assertEquals(r127.neg(), ineg3.power(-3));
    }

    @org.junit.jupiter.api.Test
    void sign() {
        assertEquals(1, i3.sign());
        assertEquals(-1, ineg3.sign());
        assertEquals(0, i0.sign());
    }
    @org.junit.jupiter.api.Test
    void equals(){
        assertEquals(true,r4.equals(i4));
        assertEquals(false, i9.equals(rhalf1));
        assertEquals(true, i9.equals(r9));
        assertEquals(true, i0.equals(r0));
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        assertEquals("4",i4.toString());
        assertEquals("-3",ineg3.toString());
        assertEquals("0", i0.toString());
    }
}
package scalars;
public abstract class Scalar {
    public abstract Scalar add(Scalar s); // summary
    protected abstract Scalar addInteger(IntegerScalar i);
    protected abstract Scalar addRational(RationalScalar r);
    public abstract Scalar mul(Scalar s); // multiplication
    protected abstract Scalar mulInteger(IntegerScalar i);
    protected abstract Scalar mulRational(RationalScalar r);
    public boolean equals(Object o){
        return o.toString().equals(this.toString());
    }
    public abstract Scalar neg();
    public abstract Scalar power(int exponent);
    public abstract int sign();
    public abstract String toString();

}

package polynomials;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import scalars.RationalScalar;
import scalars.Scalar;
import scalars.IntegerScalar;


public class Polynomial {
    private TreeMap<Integer,Monomial> monomials;

    public Polynomial(List<Monomial> monmList){
        this.monomials = new TreeMap<>();
        for(int i = 0; i < monmList.size(); i = i + 1){
            int exp = monmList.get(i).getExponent();
            if(this.monomials.containsKey(exp)){
                Monomial m = monomials.get(exp);
                monomials.replace(exp, m.add(monmList.get(i)));
            }
            else
                monomials.put(exp, monmList.get(i));
        }
    }

    private static Scalar[] fixStringtoList (String input) {
       ArrayList arr = new ArrayList();
       String[] numbers = input.trim().split("\\s+");
       String ans = "";
       for (String s : numbers) {
           ans = ans + s + " ";
       }
       String[] strArr = ans.trim().split(" ");
       Scalar[] coefs = new Scalar[strArr.length];
       for(int i = 0; i < strArr.length; i = i + 1) {
           String[] splitted = strArr[i].split("/");
           if (splitted != null && splitted.length == 2)
               coefs[i] = new RationalScalar(java.lang.Integer.parseInt(splitted[0]), java.lang.Integer.parseInt(splitted[1]));
           else
               coefs[i] = new IntegerScalar(java.lang.Integer.parseInt(splitted[0]));
        }
         return coefs;
       }

    public static Polynomial build(String input){
        Scalar[] coefs = fixStringtoList(input);
        List<Monomial> list = new ArrayList<>();
        for(int i = 0; i<coefs.length; i=i+1){
            list.add(new Monomial(i,coefs[i]));
        }
        return new Polynomial(list);
    }
    public Polynomial add(Polynomial p){

        List<Monomial> newMonom = new ArrayList<>();
        for(Monomial m : monomials.values())
            if(!p.monomials.containsKey(m.getExponent()))
                newMonom.add(m);

        Set<Integer> keys = p.monomials.keySet();
        for(Integer key : keys){
            if(monomials.containsKey(key)){
                newMonom.add(monomials.get(key).add(p.monomials.get(key)));
            }
            else {
                newMonom.add(p.monomials.get(key));
            }
        }
        return new Polynomial(newMonom);
    }
   public Polynomial mul(Polynomial p){
       List<Monomial> newMonom = new ArrayList<>();
       for (Monomial m1 : monomials.values())
           for(Monomial m2 : p.monomials.values()){
               newMonom.add(m1.mul(m2));
           }
       return new Polynomial(newMonom);
    }
    public Scalar evaluate(Scalar s){
        Scalar res = new RationalScalar(0,1);
        for(Monomial m : monomials.values()){
            res = res.add(m.evaluate(s));
        }
        return res;
    }
    public Polynomial derivative(){
        List<Monomial> der = new ArrayList<>();
        Set<Integer> keys = this.monomials.keySet();
        for(Integer key : keys){
            der.add(monomials.get(key).derivative());
        }
        return new Polynomial(der);
    }


    public String toString(){
        String ans = "";
        Boolean isZero = true;
        if(monomials.get(0).sign() == 0)
            ans += "";
        else {
            ans += monomials.get(0);
            isZero = false;
        }
        for (int i = 1; i < monomials.size(); i = i + 1){
            if(monomials.get(i).sign() >= 0)
                if(monomials.get(i).sign() == 0)
                    ans += "";
                else {
                    ans += " + " + monomials.get(i);
                    isZero = false;
                }
            else {
                ans += " " + monomials.get(i).toString().charAt(0) + " " + monomials.get(i).toString().substring(1);
                isZero = false;
            }
        }
        if(isZero){
            return "0";
        }
        else if(ans.length() > 1 && ans.charAt(1) == '+')
            return ans.substring(3);
        else
            return ans;

    }

}

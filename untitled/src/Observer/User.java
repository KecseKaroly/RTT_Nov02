package Observer;

public class User {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] szamok = new int[] { 5, 10, 15};
        FelsoSzintService alsoSzint = new AlsoSzint();
        FelsoSzint felsoSzint = new FelsoSzint();
        felsoSzint.setService(alsoSzint);
        felsoSzint.setArray(szamok);
        System.out.println(felsoSzint.getArrayGCD());
    }
}

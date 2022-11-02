package CallBack;

public class User {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] szamok = new int[] { 5, 10, 15};

        // több lehetőség: vagy amikor létrejön az alsó szint, megmondjuk, hogy mi a callback, ilyenkor az ún. klienskód rakja össze,
        // vagy minden egyes GCD hívásnál megadjuk a callback-et (ezt fogjuk most csinálni)

        FelsoSzintService alsoSzint = new AlsoSzint();
        FelsoSzint felsoSzint = new FelsoSzint();
        felsoSzint.setService(alsoSzint);
        felsoSzint.setArray(szamok);
        System.out.println(felsoSzint.getArrayGCD());
    }
}

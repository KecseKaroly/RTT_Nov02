package TryCatch;

import java.util.Random;

public class AlsoSzint implements FelsoSzintService {
    // ez a közös rész, amiben még nincsen hibakezelés
    /* Euklideszi-algoritmus
        function gcd(a, b)
            while b ≠ 0
                t := b
                b := a mod b
                a := t
            return a
         */
    @Override
    public int gcd(int a, int b) throws  HardverHiba{
        //ezzel sizmuláljuk a hardverben lévő hibát minden 20. ciklusban, azaz 5%-os hiba
        Random rnd = new Random();

        while(b != 0)
        {
            if(rnd.nextInt(100) < 90) {
                System.out.println("Hardver hiba történt!");
                throw new HardverHiba();
            }
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

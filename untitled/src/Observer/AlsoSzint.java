package Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AlsoSzint implements FelsoSzintService {
    List<HibaObserver> hibakezelok = new ArrayList<>();
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
    public int gcd(int a, int b) {
        //ezzel sizmuláljuk a hardverben lévő hibát minden 20. ciklusban, azaz 5%-os hiba
        Random rnd = new Random();

        while(b != 0)
        {
            if(rnd.nextInt(100) < 5) {
                System.out.println("Hardver hiba történt (Observeres változat)");
                notifyObservers();
                return 0;
            }
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public void Register(HibaObserver ho) {
        hibakezelok.add(ho);
    }
    public void notifyObservers() {
        for (HibaObserver ho:hibakezelok) {
            ho.HibaTortent();
        }
    }
}

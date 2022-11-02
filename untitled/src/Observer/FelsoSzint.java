package Observer;

public class FelsoSzint implements HibaObserver{
    private int[] szamok;
    private FelsoSzintService service;
    private boolean hibaFlag = false;

    public void setArray(int[] szamok) {
        this.szamok = szamok;
    }
    public void setService(FelsoSzintService service)
    {
        this.service = service;
        service.Register(this);
    }
    public int getArrayGCD() {
        if(service == null)
            return getArrayGCD_Default();
        if(szamok.length == 0)
            return 0;
        if(szamok.length == 1)
            return szamok[0];
        int gcd = service.gcd(szamok[0], szamok[1]);
        if(hibaFlag) {
            hibaFlag = false;
            return getArrayGCD_Default();
        }
        for(int i = 2; i < szamok.length; i++) {
            gcd = service.gcd(gcd, szamok[i]);
            if(hibaFlag) {
                hibaFlag = false;
                return getArrayGCD_Default();
            }
        }
        return gcd;
    }
    private int getArrayGCD_Default() {
        if(szamok.length == 0)
            return 0;
        if(szamok.length == 1)
            return szamok[0];
        int gcd = gcd_default(szamok[0], szamok[1]);
        for(int i = 2; i < szamok.length; i++) {
            gcd = gcd_default(gcd, szamok[i]);
        }
        return gcd;
    }
    private int gcd_default(int szam1, int szam2) {
        // Nagyobból vonom ki a kisebbet addíg, amig egyenlőek nem lesznek
        while(szam1 != szam2) {
            if(szam1 > szam2)
                szam1 = szam1 - szam2;
            else
                szam2 = szam2 - szam1;
        }
        return szam1;
    }

    @Override
    public void HibaTortent() {
        hibaFlag = true;
    }
}

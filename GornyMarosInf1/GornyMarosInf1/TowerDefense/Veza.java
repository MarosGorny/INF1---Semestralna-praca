
/**
 * Write a description of class Veza here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Veza {
    private Kruh veza;
    private Mapa mapa;
    private Priserka priserka;

    private boolean zasiahnutaPriserka;

    private int poziciaX; 
    private int poziciaY;

    private int peniaze;
    private int dosah;
    private int sila;

    private Kruh[][] miestoVezicky;
    /**
     * Konštruktor triedy Veza
     * Peniaze nastaví na 40
     * Dosah vežičky nastaví na 1
     * Silu vežičky nastaví na 1
     * Vytvorí maticu miestoVezicky s Kruhom
     */
    public Veza() {
        this.mapa = new Mapa();

        this.zasiahnutaPriserka = false;

        this.peniaze = 40;
        this.dosah = 1;
        this.sila = 1;

        this.miestoVezicky = new Kruh[9][9];
        
    }
    /**
     * Vytvorí vežičku na pozícií X , Y
     * Ak má aspoň 10 peňazí
     * Ak sa nenachádza na ceste
     * Ak na danej pozícií nie je iná veža
     */
    public void vytvorVezicku(int pozX, int pozY) {
        if (this.peniaze >= 10) {
            if (!this.mapa.getCesta(pozX , pozY) ) {
                if (this.miestoVezicky[pozX][pozY] == null) {
                    this.poziciaX = pozX;
                    this.poziciaY = pozY;

                    this.veza = new Kruh(pozX * 50 , pozY * 50 , 50 );
                    this.veza.zobraz();
                    this.peniaze = this.peniaze - 10;

                    this.miestoVezicky[pozX][pozY] = this.veza;
                }   else {
                    System.out.println("Tu už veža je");
                }

            }   else {
                System.out.println("Vežu nemôžeš pridať na cestu");
            }
        } else {
            System.out.println("Nemáš dostatok peňazí");
        }

    }

    /**
     * Skúsi zničiť príšerku
     * Ak sa nachádza v dosahu vežičky
     *      Ak má príšerka väčší život, ako veža silu, tak veža odoberie život
     *      Ak má príšerka menší alebo rovný život, ako veža silu, tak príšerku skryje a pridá 5 peňazí
     * Nastaví príšerku ako na zasiahnutú
     */        
    public void skusZnicitPriserku(Priserka priserka) {

        if (priserka.getSuradniceX() <= (this.poziciaX + this.dosah) && priserka.getSuradniceX() >= (this.poziciaX - this.dosah)) {

            if (priserka.getSuradniceY() <= (this.poziciaY + this.dosah) && priserka.getSuradniceY() >= (this.poziciaY - this.dosah)) {
                if (priserka.getZivot() > this.sila) {
                    priserka.setZivot(priserka.getZivot() - this.sila) ;
                } else {
                    priserka.skryPriserku();
                    this.peniaze = this.peniaze + 5;

                }
                //System.out.println("vystrel");  
                this.zasiahnutaPriserka = true;
            }

        }

    }    

    // /**
    // * Zväčší dosah 
    // */
    // public void zvacsiDosah(int oKolko) {
    // if (this.peniaze >= 10) {
    // this.peniaze = this.peniaze - (10 * oKolko);
    // this.dosah = this.dosah + oKolko;
    // } else {
    // System.out.println("Nemas dostatok penazi");
    // }

    // }

    public boolean getZasiahnutaPriserka() {
        return this.zasiahnutaPriserka;
    }

    public void setZasiahnutaPriserka(boolean zasiahnutaPriserka ) {
        this.zasiahnutaPriserka = !zasiahnutaPriserka;
    }
}

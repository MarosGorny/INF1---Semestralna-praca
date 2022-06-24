
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main {
        
    /**
     * Constructor for objects of class Main
     */
    public static void main(String[] args) {
        Mapa mapa = new Mapa();
        mapa.zobrazMapu();
        Priserka priserka = new Priserka();
        Hra hra = new Hra();
        Manazer manazer = new Manazer();
        manazer.spravujObjekt(hra);
    }
}

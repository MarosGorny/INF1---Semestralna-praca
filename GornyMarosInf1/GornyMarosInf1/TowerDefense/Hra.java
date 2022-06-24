import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 * Write a description of class Hra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hra {
    private Veza veza;

    private ArrayList<Priserka> priserky;

    private Veza[][] miestoVeziciek;

    
    /**
     * Konštruktor triedy Hra
     * Nainicializuje pole miestoVeziciek s vezami
     * Vytvorí ArrayList s príšerkami
     * Vytvorí 10 príšeriek
     */
    public Hra() {
        this.miestoVeziciek = new Veza [9][9];
        this.priserky = new ArrayList<Priserka>();
             
        for (int p = 0;p < 5; p++) {
            Priserka priserkyy = new Priserka();
            priserkyy.vytvorPriserku();
            priserkyy.posunPriserkuVertikalne(p * 50);

            this.priserky.add(priserkyy);
        }

    }

    /**
     * Vytvorí novú vežu na pozícií X,Y
     */
    public void vyberSuradnice(int x, int y) {
        this.veza = new Veza();
        this.veza.vytvorVezicku(x , y);
        
        // if (this.miestoVeziciek[x][y] == null) {
            // this.miestoVeziciek[x][y] = new Veza();
        // }

    }

    /**
     * Každú príšerku posunie po ceste o jeden štvorec
     *      Ak sa príšerka dostane za koniec cesty, hru vypne
     * Veža skúsi zničiť každú príšerku
     *      Ak príšerka ešte nebola zasiahnutá, tak 
     *          Skúsi zničiť príšerku
     *      Ak príšerka bola zasiahnutá, tak 
     *          Sa skončí cyklus
     */
    public void tik() {
        for (Priserka priserka : this.priserky ) {
            priserka.pohybPriserky();
            if (!priserka.getSkrytaPriserka() ) {
                if (priserka.getSuradniceY() < 0) {
                    JOptionPane.showMessageDialog(null, "Prehral si");
                    System.exit(0);
                }
            }

        }
        for (Priserka priserka : this.priserky ) {

            if (!this.veza.getZasiahnutaPriserka() ) {
                this.veza.skusZnicitPriserku(priserka);
            }   else {
                this.veza.setZasiahnutaPriserka(this.veza.getZasiahnutaPriserka());
                break;
            }


            //System.out.println("je v Cykle");

        }

    }
}
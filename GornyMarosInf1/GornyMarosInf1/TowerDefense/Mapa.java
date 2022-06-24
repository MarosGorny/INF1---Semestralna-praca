import java.util.ArrayList;
/**
 * Write a description of class Mapa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mapa {
            
    private ArrayList<Stvorec> mapa;
    private int[][] cesta;
    
    /**
     * Konštruktor triedy Mapa
     * Nakreslí mapu cez štvorce, zo zelenej a červenej farby
     * 
     * Ak je štvorec červený, do pola priradí "0"
     * Ak je štvorec zelený, do pola priradí "1"
     * 
     * Každý štvorec pridá do ArrayListu
     */
    public Mapa() {
        this.mapa = new ArrayList<Stvorec>();
        this.cesta = new int[9][9];
        
        for (int j = 0;j < 9; j++) { 
            for (int i = 0;i < 9;i++) {
                Stvorec mapaa = new Stvorec(i * 50, j * 50);
                                
                if (i == 0 || i == 8) {
                    mapaa.zmenFarbu("red");                    
                } else {
                    mapaa.zmenFarbu("green");                    
                }
                if (i == 1 && j == 0) {
                    mapaa.zmenFarbu("red");
                }                    
                if (i == 2 && j != 1 ) {
                    mapaa.zmenFarbu("red");
                }   
                if (i == 3 && (j == 0 || j == 8)) {
                    mapaa.zmenFarbu("red");
                }   
                if (i == 4 && j != 7) {
                    mapaa.zmenFarbu("red");
                }   
                if (i == 5 && j != 7) {
                    mapaa.zmenFarbu("red");
                }   
                if (i == 6 && j != 7) {
                    mapaa.zmenFarbu("red");
                }   
                if (i == 7 && j == 8) {
                    mapaa.zmenFarbu("red");
                }  
                             
                if (mapaa.getFarba().equals("red")) {
                    this.cesta[j][i] = (0);
                    
                } 
                if (mapaa.getFarba().equals("green")) {
                    this.cesta[j][i] = (1);
                
                }
                                
                this.mapa.add(mapaa);
            }
            
        }
        
    }
            
    public  boolean getCesta(int x, int y) {
        
        return this.cesta[y][x] != 0;
        
        
        // if (this.cesta[y][x] == 0) {
            // return false;            
        // } else {
            // return true;
        // }
                
    }
    
    /**
     Zobrazí sa každý štvorec z ArrayListu mapa
     */ 
    public void zobrazMapu() {
        for (Stvorec o : this.mapa) {
            o.zobraz();
        }
        
    }
}

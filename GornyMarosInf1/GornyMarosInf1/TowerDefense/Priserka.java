
/**
 * Write a description of class Priserka here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Priserka {
    private Kruh hlava;
    private Obdlznik telo;
    private Obdlznik rRuka;
    private Obdlznik lRuka;
    private Obdlznik rNoha;
    private Obdlznik lNoha;
       
    private int zivot;
    
    private boolean skrytaPriserka;
    
    /**
     * Konštruktor triedy Priserka
     * 
     */
    public Priserka() {
        this.zivot = 1;
        this.skrytaPriserka = false;
          
    }
    
    
    /**
     * Vytvorí časti tela príšerky X,Y priemier/ strana A, strana B
     * Zobrazí príšerku 
     */
    public void vytvorPriserku() {
        this.hlava = new Kruh(69 , 401, 12);      
        this.telo = new Obdlznik(14, 14, 68, 413);
        this.lRuka = new Obdlznik(5 , 1 , 63 , 418);
        this.rRuka = new Obdlznik(5 , 1 , 82 , 418);
        this.lNoha = new Obdlznik(1, 22, 72, 427);
        this.rNoha = new Obdlznik(1, 22, 78, 427);
     
        this.zobrazPriserku();
        
    }
    
    /**
     * Pohyb príšerky cez mapu o 1 štvorec
     */
    public void pohybPriserky() {
        if ((this.getSuradniceX() == 1) && (this.getSuradniceY() > 1)) {
            this.posunPriserkuVertikalne(-50);                
        } else if ((this.getSuradniceX() <= 2) && this.getSuradniceY() == 1) {
            this.posunPriserkuHorizontalne(50);
        } else if ((this.getSuradniceX() == 3) && this.getSuradniceY() <= 6) {
            this.posunPriserkuVertikalne(50);
        } else if ((this.getSuradniceX() <= 6) && this.getSuradniceY() == 7) {
            this.posunPriserkuHorizontalne(50);
        } else if ((this.getSuradniceX() == 7) && this.getSuradniceY() >= 0) {
            this.posunPriserkuVertikalne(-50);
        }
    }
    
    /**
     * Zobrazí príšerku
     * Atribút skrytaPriserka nastaví na nepravdivý
     */
    public void zobrazPriserku() {
        this.rNoha.zobraz();
        this.lNoha.zobraz();
        this.rRuka.zobraz();
        this.lRuka.zobraz();
        this.telo.zobraz();
        this.hlava.zobraz();
        
        this.skrytaPriserka = false;
    }
    
    /**
     * Skryje príšerku
     * Atribút skrytaPriserka nastaví na pravdivý
     */
    public void skryPriserku() {
        this.rNoha.skry();
        this.lNoha.skry();
        this.rRuka.skry();
        this.lRuka.skry();
        this.telo.skry();
        this.hlava.skry();
        
        this.skrytaPriserka = true;
    }
    
    /**
     * Posunie príšerku horizontálne
     */
    public void posunPriserkuHorizontalne(int oKolko) {
        this.hlava.posunVodorovne(oKolko);
        this.telo.posunVodorovne(oKolko);
        this.lRuka.posunVodorovne(oKolko);
        this.rRuka.posunVodorovne(oKolko);
        this.lNoha.posunVodorovne(oKolko);
        this.rNoha.posunVodorovne(oKolko);
             
    }
   
    /**
     * Posunie príšerku vertikálne
     */
    public void posunPriserkuVertikalne(int oKolko) {
        this.hlava.posunZvisle(oKolko);
        this.telo.posunZvisle(oKolko);
        this.lRuka.posunZvisle(oKolko);
        this.rRuka.posunZvisle(oKolko);
        this.lNoha.posunZvisle(oKolko);
        this.rNoha.posunZvisle(oKolko);
        
    }
       

    public void setZivot(int zivot) {
        this.zivot = zivot;
    }
    
    public int getZivot() {
        return this.zivot;
    }
    
    public boolean getSkrytaPriserka() {
        return this.skrytaPriserka;
    }
    
    public int getSuradniceX() {
        return this.hlava.getXSuradniceKruhu() / 50;
    }
    
    public int getSuradniceY() {
        
        return this.hlava.getYSuradniceKruhu() / 50;
    }
}

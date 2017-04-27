/**
 * Created by santi on 02/04/2017.
 */
public class Lliurament{
    private int codi; //identificació
    private boolean examen;
    private double qualificacio;

    public Lliurament(int codi, boolean examen){
        this.codi=codi;
        this.examen=examen; this.qualificacio=0.0;
    }
    public Lliurament(int codi){
        this(codi,true);
    }
    public void setQualificacio(double nota){ this.qualificacio=nota;}
    public double getQualificacio(){ return qualificacio;}
    public int getCodi(){ return codi;}
    public boolean getExamen(){ return examen;}


    @Override
    public String toString() {
        String s = " Lliurament:";
        s += String.format("\tcodi: %s",codi) ;
        s += String.format("\texamen: %s",(examen?"SI":"NO")) ;
        s += String.format("\tqualificacio: %.2f",qualificacio) ;
        return s;
    }
}
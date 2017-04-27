/**
 * Created by santi on 02/04/2017.
 */
public class ProgramacioAvancada {

    private Acb matriculats[];
    public ProgramacioAvancada(){
        matriculats=new AcbEnll[2];
        matriculats[0]=new AcbEnll(); //UPC
        matriculats[1]=new AcbEnll(); //UPF
    }
    public void AfegirEstudiant(Estudiant e) throws Exception {
        /*Exercici 4*/
        if (e.getPla_UPF()) ((AcbEnll)matriculats[1]).Inserir(e);
        else ((AcbEnll)matriculats[0]).Inserir(e);
        //el metode inserir ja controla la repeticio.
        }
    public void EsborrarEstudiant(Estudiant e) throws Exception {
        /*Exercici 5*/
        if (e.getPla_UPF()) ((AcbEnll)matriculats[1]).Esborrar(e);
        else ((AcbEnll)matriculats[0]).Esborrar(e);
        //el metode esborrar ia, controla la no existencia
        }

    public int[] matriculatsDeCadaPla(){
        /*Exercici 6*/
        int q[]={0,0};
        q[0] = ((AcbEnll)matriculats[0]).quants();
        q[1] = ((AcbEnll)matriculats[1]).quants();
        return q;
    }
    public String toString(){
        /*Exercici 7*/
        //llistat alumnes UPF ordenats per dni amb la qualificacio final
        //llistat alumnes UPC ordenats per dni amb la qualificacio final
        return ((AcbEnll)matriculats[1]).toString() + ((AcbEnll)matriculats[0]).toString();
    }
    public double obtenirNotafinal(long dni) throws Exception{
        /*Exercici 8*/
        //localitzar arbre
        // cal tenir present que l arbre esta ordenat
        double nota;
        try {
            nota = ((AcbEnll)matriculats[0]).obtenirNotaFinal(dni);
        } catch (Exception e){
            try {
                nota = ((AcbEnll)matriculats[1]).obtenirNotaFinal(dni);
            } catch (Exception e2){
                throw new Exception("Alumne no matriculat");
            }
        }
        return nota;
    }
}

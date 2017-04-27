/**
 * Created by santi on 02/04/2017.
 */
public class Main {

    public static void main(String[] args){

        ProgramacioAvancada pa = new ProgramacioAvancada();
        Estudiant e1 = new Estudiant("Mireia", 123456789, "UPC");
        Estudiant e2 = new Estudiant("Santi", 433456789, "UPF");


        try {
            pa.AfegirEstudiant(e1);
            pa.AfegirEstudiant(e2);

            Lliurament ll1 = new Lliurament(1,true);
            ll1.setQualificacio(8.5);
            e2.addLliurament(ll1);

            Lliurament ll2 = new Lliurament(2,false);
            ll2.setQualificacio(10);
            e2.addLliurament(ll2);

            Lliurament ll3 = new Lliurament(3,false);
            ll3.setQualificacio(9.5);
            e1.addLliurament(ll3);

            Lliurament ll4 = new Lliurament(4,false);
            ll4.setQualificacio(5);
            e2.addLliurament(ll4);

            e2.remLliurament(ll2);


        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("UPC "+ pa.matriculatsDeCadaPla()[0]);
        System.out.println("UPF "+ pa.matriculatsDeCadaPla()[1]);

        try {
            System.out.println("Santi Notafinal = "+ pa.obtenirNotafinal(433456789));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

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


            Lliurament ll3 = new Lliurament(3,false);
            ll3.setQualificacio(9.5);
            e1.addLliurament(ll3);

            Lliurament e1_ex1 = new Lliurament(1,true);
            e1_ex1.setQualificacio(9.5);
            e1.addLliurament(e1_ex1);


            Lliurament e2_p1 = new Lliurament(1,true);
            e2_p1.setQualificacio(7.5);
            e2.addLliurament(e2_p1);

            Lliurament e2_p2 = new Lliurament(2,false);
            e2_p2.setQualificacio(10);
            e2.addLliurament(e2_p2);

            Lliurament e2_p3 = new Lliurament(4,false);
            e2_p3.setQualificacio(5);
            e2.addLliurament(e2_p3);

            Lliurament e2_ex1 = new Lliurament(1,true);
            e2_ex1.setQualificacio(8.5);
            e2.addLliurament(e2_ex1);


            e2.remLliurament(e2_p2);


        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nAlumnes\n");
        System.out.println(e1);
        System.out.println(e2);



    }
}

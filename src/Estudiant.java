public class Estudiant implements Comparable{

    private class Node{
        Lliurament ll; Node seg;
        public Node(Lliurament prova){this(prova,null);}
        public Node(Lliurament prova, Node seg){
            this.ll=prova;this.seg=seg; }
    }

    private String nom;
    private long dni; //identificador
    private Node qualificacions; //seqüència enllaçada lineal sense capçalera
    private boolean pla_UPF;
    public Estudiant(String nom, long dni, String pla){
        this.nom=nom;this.dni=dni;
        if (pla.equalsIgnoreCase("UPF")) pla_UPF=true;
        else pla_UPF=false;
        qualificacions=null; //creem la seqüència enllaçada sense node capçalera
    }

    public boolean getPla_UPF(){return pla_UPF;}
    public long getDni(){return dni;}
    public String getNom(){return nom;}

    public void addLliurament(Lliurament ll) {
        /* TODO Exercici 1*/
        // Si examen darrera sino davant
        // no cal mirar si ten -- sumem no hi es
        // cas buida
        if (qualificacions == null) qualificacions = new Node(ll);
        else {
            if (ll.getExamen()) {
                // inserim al darrera, fem recorregut
                Node aux = qualificacions;
                while (aux.seg != null) aux = aux.seg;
                aux.seg = new Node(ll);
            } else {
                // inserim davant
                qualificacions = new Node(ll, qualificacions);
            }
        }
    }

    public void remLliurament(Lliurament ll) throws Exception {

        if (qualificacions == null)
            throw new Exception("No hi es");

        if (ll.getCodi() == qualificacions.ll.getCodi()) {
            qualificacions = qualificacions.seg;
            return;
        }

        Node aux = qualificacions;
        boolean trobat = false;

        while (!trobat && aux.seg != null) {
            if (ll.getCodi() == aux.seg.ll.getCodi())
                trobat = true;
            else
                aux = aux.seg;
        }
        if (trobat)
            aux.seg = aux.seg.seg;
        else
            throw new Exception("No hi es");
    }


    public void modificaLLiurament(int codi, float qualificacio) throws Exception { /*Exercici 2*/

        // cerca
        Node aux = qualificacions;
        boolean trobat = false;
        while (!trobat && aux != null) {
            if (aux.ll.getCodi() == codi) trobat = true;
            else aux = aux.seg;
        }
        if (trobat) {
            aux.ll.setQualificacio(qualificacio);
        } else throw new Exception("Lliurament no existent");
    }

    public double calculaFinal() {
        /*Exercici 3*/
        // calcula la qualificació final de l’estudiant segons la normativa d’avaluació
        // Examens martin 70% i reste 30% no examens
        // Valoracio eficiencia nomes 1 recorregut
        float exam = 0.0F;
        float noExam = 0.0F;
        int quantsE = 0, quantsNoE = 0;
        // Recorregut
        Node aux = qualificacions;
        while (aux != null) {
            if (aux.ll.getExamen()) {
                quantsE++;
                exam += aux.ll.getQualificacio();
            } else {
                quantsNoE++;
                noExam += aux.ll.getQualificacio();
            }
            aux = aux.seg;
        }
        double value = (0.70 * (exam / quantsE) + 0.30 * (noExam / (quantsNoE==0?1:quantsNoE)));
        return  value;
    }

    public boolean MajorQue(Comparable c){
        return dni>((Estudiant)c).dni;}
    public boolean MenorQue(Comparable c){
        return dni<((Estudiant)c).dni;}



    public String toString() {
        String s = "Estudiant: "+ nom +"\n";
        s += String.format("Lliuraments:\n%s\n", llistar(qualificacions)) ;
        s += String.format("Final: %.2f", calculaFinal()) ;
        return  s ;
    }

    private static String llistar(Node qualificacions){
        String s = "";
        Node aux=qualificacions;
        while (aux!=null) {
            s += ((Lliurament)aux.ll).toString() +"\n";
            aux=aux.seg;
        }
        return s;
    }

} // fi classe
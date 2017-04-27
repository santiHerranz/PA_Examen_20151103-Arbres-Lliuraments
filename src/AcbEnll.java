import java.util.HashMap;

public class AcbEnll implements Acb{

    private NodeA arrel;
    public AcbEnll(){arrel=null;}

    private class NodeA{
        Estudiant inf; NodeA esq,dret;
        public NodeA(Estudiant m, NodeA e, NodeA d){inf=m;esq=e;dret=d;}

        public int quants() {
            //recorregut en preordre (es irrellevant quin) poer comptar nodes
            int cont = 1;
            if(esq!=null ) cont+=esq.quants();
            if(dret!=null ) cont+=dret.quants();
            return cont;
        }

        public String ToString (){
            String r= "";
            if(esq!= null) r+= esq.toString();
            r+= inf.getDni() + inf.getNom() + inf.calculaFinal()+"\n";
            if(dret!= null) r+= dret.toString();
            return r;
        }

        public double obtenirNotaFinal(long dni) throws Exception {
            if (inf.getDni() == dni) {
                //calcula la nota final
                double n = inf.calculaFinal();
                return n;
            } else {
                if (inf.getDni() < dni) {
                    //ha d estar a la dreta
                    if (dret == null) throw new Exception("No hi es");
                    return dret.obtenirNotaFinal(dni);
                } else {
                    // ha d estar a l esquerra
                    if (esq == null) throw new Exception("No hi es");
                    return esq.obtenirNotaFinal(dni);
                }
            }
        }

    } //fi classe privada


    public int quants() {
        if (arrel==null) return 0;
        return  arrel.quants();

    };

    public String ToString() {
        if (arrel==null) return "";
        return (arrel.toString());
    }


    public double obtenirNotaFinal(long dni) throws Exception {
        //buscar element de l arbre, llancar Excepcin si no hi es
        if (arrel==null) throw new Exception("No hi es");
        return arrel.obtenirNotaFinal(dni);
    }


/* implementació de totes les operacions de la interfície*/


    @Override
    public void Inserir(Comparable e) throws Exception {
        this.arrel = inserirRecursiu(this.arrel, e);
    }
    private NodeA inserirRecursiu(NodeA a, Comparable e) throws Exception {
        if(a == null) {
            a = new NodeA((Estudiant) e, null, null);
        } else {
            if (e.MenorQue(a.inf)) {
                a.esq = inserirRecursiu(a.esq, e);
            } else if (e.MajorQue(a.inf)) {
                a.dret = inserirRecursiu(a.dret, e);
            } else {
                throw new Exception("Repetit " + e);
            }
        }
        return a;
    }

    @Override
    public void Esborrar(Comparable e) throws Exception {
        if (this.arrel==null) throw new Exception("L arbre es buit");
        this.arrel=esborrarRecursiu(this.arrel,e);

    }
    private NodeA esborrarRecursiu( NodeA d, Comparable e) throws Exception {
        if (d==null) throw new Exception("l element no hi es");
        else if (((Comparable)(d.inf)).MajorQue(e))
            d.esq=esborrarRecursiu(d.esq,e);
        else if (((Comparable)d.inf).MenorQue(e))
            d.dret=esborrarRecursiu(d.dret,e);
        else /*l'hem trobat*/
            if (d.esq!=null && d.dret!=null)
            { //sabem segur que d no es null
                d.inf = (Estudiant)BuscarMinim(d.dret);
                d.dret = EsborrarMinim(d.dret);
            }
            else if (d.esq==null && d.dret==null) d=null;
            else if (d.esq==null) d=d.dret;
            else d=d.esq;
        return d;
    }
    private static Comparable BuscarMinim(NodeA d){
        //la d no es nul.la
        while (d.esq!=null)
            d=d.esq;
        return (Comparable)d.inf;
    }

    private static NodeA EsborrarMinim( NodeA d){
        if (d.esq==null) { d=d.dret; return d;}
        else {d.esq=EsborrarMinim(d.esq); return d;}
    }



    @Override
    public boolean Membre(Comparable e) {
        return false;
    }

    @Override
    public Comparable Arrel() throws Exception {
        return null;
    }

    @Override
    public Acb FillEsquerre() {
        return null;
    }

    @Override
    public Acb FillDret() {
        return null;
    }

    @Override
    public boolean ArbreBuit() {
        return false;
    }

    @Override
    public void Buidar() {

    } //no hereta de AbEnll
} // fi classe

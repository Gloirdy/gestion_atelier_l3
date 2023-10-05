package entities;

public class Unite extends AbstractEntities {
    
    private static int nbre;

    public Unite(){
        super();
    }

    public Unite(String libelle){
        super(++nbre,libelle);
    }
    
    @Override
    public String toString() {
        return  "Unite"+super.toString();
    }

    
    
    
}

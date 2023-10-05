package entities;

public class Categorie extends AbstractEntities{
    private static int nbre;

    public Categorie(){
        super();
    }

    public Categorie(String libelle){
        super(++nbre,libelle);
    }

    

    

    @Override
    public String toString() {
        return  "Categorie"+super.toString();
    }
    
  

    
    

    

    
}




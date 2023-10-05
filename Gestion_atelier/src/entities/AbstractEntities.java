package entities;

public abstract class AbstractEntities {
    
    protected int id;
    protected String libelle;

    
    public AbstractEntities(int id, String libelle) {
        this.id =id;
        this.libelle = libelle;
    }

    public AbstractEntities( String libelle) {
        this.libelle = libelle;
    }

    public AbstractEntities() {

    }
    
    public int getId() {
        return id;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return " [id=" + id + ", libelle=" + libelle + "]";
    }

}



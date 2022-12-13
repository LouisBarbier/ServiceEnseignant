
package champollion;


public abstract class Personne {
    protected final String nom;
    protected final String email;

    public Personne(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }
    
    
}

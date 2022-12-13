package champollion;

import java.util.Date;

public class Intervention {

    public UE ue;
    public Date debut;
    public int duree;
    private int heureDebut;
    public TypeIntervention type;
    public Salle salle;
    public String intervenant;
    public boolean annulee = false;

    public Intervention(UE ue,Date debut,int duree,int heureDebut,TypeIntervention type, Salle salle,String intervenant){
        this.ue=ue;
        this.debut=debut;
        this.duree=duree;
        this.heureDebut=heureDebut;
        this.type=type;
        this.salle=salle;
        this.intervenant=intervenant;
    }
    public Intervention(UE ue,Date debut,int duree,int heureDebut,TypeIntervention type,Salle salle,String intervenant,boolean annulee){
        this(ue,debut, duree, heureDebut, type,salle,intervenant);
        this.annulee=annulee;
    }

    public UE getUe() {
        return ue;
    }
    public Date getDebut() {
        return debut;
    }
    public int getDuree() {
        return duree;
    }
    public int getHeureDebut() {
        return heureDebut;
    }
    public TypeIntervention getType() {
        return type;
    }
    public Salle getSalle() {
        return salle;
    }
    public String getIntervenant() {
        return intervenant;
    }
    public boolean isAnnulee() {
        return annulee;
    }

    public void setAnnulee(boolean nannulee){
        annulee=nannulee;
    }
}

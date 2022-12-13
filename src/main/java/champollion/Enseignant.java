package champollion;

import java.util.ArrayList;
import java.util.Date;

public class Enseignant extends Personne {

    ArrayList<ServicePrevu> enseignements=new ArrayList<ServicePrevu>();
    ArrayList<Intervention> interventions=new ArrayList<Intervention>();

    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        double vTot=0;
        for( ServicePrevu s : enseignements) {
            vTot+=s.getVolumeCM()*1.5;
            vTot+=s.getVolumeTD();
            vTot+=s.getVolumeTP()*0.75;
        }
        int vTotInt=0;
        while (vTot>=0.5){
            vTotInt++;
            vTot-=1;
        }
        return vTotInt;
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        double vTot=0;
        for( ServicePrevu s : enseignements) {
            if (s.getUe()==ue) {
                vTot += s.getVolumeCM() * 1.5;
                vTot += s.getVolumeTD();
                vTot += s.getVolumeTP() * 0.75;
            }
        }
        int vTotInt=0;
        while (vTot>=0.5){
            vTotInt++;
            vTot-=1;
        }
        return vTotInt;
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        enseignements.add(new ServicePrevu(ue,nom,volumeCM,volumeTD,volumeTP));
    }

    public void ajouteIntervention (UE ue,Date debut,int duree,int heureDebut,TypeIntervention type, Salle salle){
        interventions.add(new Intervention(ue,debut,duree,heureDebut,type,salle,nom));
    }

    public int resteAPlanifier(UE ue,TypeIntervention type){
        int hPrevuUEType=0;
        for (ServicePrevu s : enseignements) {
            if (s.getUe()==ue) {
                if (type==TypeIntervention.CM){
                    hPrevuUEType+=s.getVolumeCM();
                }
                if (type==TypeIntervention.TD){
                    hPrevuUEType+=s.getVolumeTD();
                }
                if (type==TypeIntervention.TP){
                    hPrevuUEType+=s.getVolumeTP();
                }
            }
        }
        int hPlanifieUEType=0;
        for (Intervention i : interventions){
            if (i.getUe()==ue && i.getType()==type){
                hPlanifieUEType+=i.getDuree();
            }
        }
        return hPrevuUEType-hPlanifieUEType;
    }
}

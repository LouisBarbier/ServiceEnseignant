package champollion;

public class ServicePrevu {

    public int volumeCM;
    public int volumeTD;
    public int volumeTP;
    public UE ue;
    public String intervenant;

    public ServicePrevu (UE ue,String intervenant,int volumeCM,int volumeTD,int volumeTP){
        this.ue=ue;
        this.intervenant=intervenant;
        this.volumeCM=volumeCM;
        this.volumeTD=volumeTD;
        this.volumeTP=volumeTP;
    }

    public UE getUe() {
        return ue;
    }
    public String getIntervenant() {
        return intervenant;
    }
    public int getVolumeCM() {
        return volumeCM;
    }
    public int getVolumeTD() {
        return volumeTD;
    }
    public int getVolumeTP() {
        return volumeTP;
    }
}

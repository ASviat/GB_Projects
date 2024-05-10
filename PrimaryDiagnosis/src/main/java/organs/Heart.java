package organs;

import patient.Patient;

//Самое больное сердце пациента
public class Heart extends Patient {

    private boolean isTachycardia;
    private boolean isBradycardia;
    private boolean isHypertension;
    private boolean isHypotension;
    private boolean isIncreasedCardiacMarkers;
    private boolean isRaiseSt;
    private boolean isDepressionST;
    private boolean isPathologicalQ;



    /**
     * Constructor without age for further print only diseases without personal data
     */
    public Heart(boolean isTachycardia, boolean isBradycardia, boolean isHypertension, boolean isHypotension,
                 boolean isIncreasedCardiacMarkers, boolean isRaiseSt, boolean isDepressionST, boolean isPathologicalQ) {
        this.isTachycardia = isTachycardia;
        this.isBradycardia = isBradycardia;
        this.isHypertension = isHypertension;
        this.isHypotension = isHypotension;
        this.isIncreasedCardiacMarkers = isIncreasedCardiacMarkers;
        this.isRaiseSt = isRaiseSt;
        this.isDepressionST = isDepressionST;
        this.isPathologicalQ = isPathologicalQ;
    }

    public Heart() {
    }

    @Override
    public String toString() {
        return "Heart{" +
                "isTachycardia=" + isTachycardia +
                ", isBradycardia=" + isBradycardia +
                ", isHypertension=" + isHypertension +
                ", isHypotension=" + isHypotension +
                ", isIncreasedCardiacMarkers=" + isIncreasedCardiacMarkers +
                ", isRaiseSt=" + isRaiseSt +
                ", isDepressionST=" + isDepressionST +
                ", isPathologicalQ=" + isPathologicalQ +
                "} " + super.toString();
    }

    public String printDiseaseName(){
        return "";
    }
}

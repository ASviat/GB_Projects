package organs.heartDiseases;

import organs.Heart;

public class MyocardialInfarction extends Heart {

    private boolean isWeakness;
    private boolean isPainBehindChest;


    //    String painBehindTheChest; // жгучие, давящие боли не купирующиеся нитроглицерином
    // были ли инфаркты?


    public MyocardialInfarction(String patientsName, int patientsAge, boolean isTachycardia, boolean isBradycardia,
                                boolean isHypertension, boolean isHypotension, boolean isIncreasedCardiacMarkers,
                                boolean isRaiseSt, boolean isDepressionST, boolean isPathologicalQ,
                                boolean isWeakness, boolean isPainBehindChest) {
        super(isTachycardia, isBradycardia, isHypertension, isHypotension,
                isIncreasedCardiacMarkers, isRaiseSt, isDepressionST, isPathologicalQ);

        this.isWeakness = isWeakness;
        this.isPainBehindChest = isPainBehindChest;
    }

    public MyocardialInfarction(boolean isTachycardia, boolean isBradycardia, boolean isHypertension,
                                boolean isHypotension, boolean isIncreasedCardiacMarkers, boolean isRaiseSt,
                                boolean isDepressionST, boolean isPathologicalQ, boolean isWeakness,
                                boolean isPainBehindChest) {
        super(isTachycardia, isBradycardia, isHypertension, isHypotension, isIncreasedCardiacMarkers, isRaiseSt,
                isDepressionST, isPathologicalQ);
        this.isWeakness = isWeakness;
        this.isPainBehindChest = isPainBehindChest;
    }

    public MyocardialInfarction() {
        super();

    }

    @Override
    public String toString() {
        return "MyocardialInfarction{" +
                "isWeakness=" + isWeakness +
                ", isPainBehindChest=" + isPainBehindChest +
                "} " + super.toString();
    }

    @Override
    public String printDiseaseName() {
        return MyocardialInfarction.class.getSimpleName();
    }
}

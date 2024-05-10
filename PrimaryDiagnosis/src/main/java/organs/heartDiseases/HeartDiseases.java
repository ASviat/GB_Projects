package organs.heartDiseases;

import organs.Heart;

public class HeartDiseases {

    private static Heart[] heartDiseases = {new MyocardialInfarction()
    };

    public static void printHeartDiseases() {

        for (int i = 0; i < heartDiseases.length; i++) {
            System.out.println(i + 1 + ". " + heartDiseases[i].printDiseaseName());
        }
    }


}

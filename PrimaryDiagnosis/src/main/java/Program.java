import View.View;
import organs.heartDiseases.MyocardialInfarction;
import organs.Heart;

import static organs.heartDiseases.HeartDiseases.printHeartDiseases;

public class Program {

    /*
    Предварительный диагноз есть. Описан так: мол желудочно-кишечное кровотечение, отек легких, острый коронарный
    синдром с подъемом или без подъема сегмента ST, нестабильная прогрессирующая стенокардия, желудочковая тахикардия,
    острое нарушение мозгового кровообращ.
     */

    public static void main(String[] args) {
        // создать картину заболевания
        // просмотреть симптомы заболевания

        //  группировка -- какая?
        // состояния состояний органов -- зачем?

        // состояние органов (в том числе диагностические, мол подъем СТ)

        Heart[] diseases = {
                new MyocardialInfarction
                        (true, false, false,
                                true, true, true, false,
                                true, true, true),

        };


        View view = new View();
        view.printMainMenu();
        System.out.println("----------------------");

        printHeartDiseases();
    }
}

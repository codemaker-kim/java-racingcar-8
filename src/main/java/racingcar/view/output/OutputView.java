package racingcar.view.output;

import java.util.List;
import java.util.Set;
import racingcar.model.Car;

public class OutputView {
    private static final String DASH = "-";
    private static final String COLON = " : ";
    private static final String COMMA = ", ";
    private static final String WINNER_PREFIX = "최종 우승자 : ";

    public static void printResultPrompt() {
        System.out.println("실행 결과");
    }

    public static void printRoundResult(List<Car> cars) {
        cars.forEach(OutputView::printCarStatus);
        System.out.println();
    }

    private static void printCarStatus(Car car) {
        System.out.println(car.getName() + COLON + generateDashes(car.getPosition()));
    }

    private static String generateDashes(int position) {
        return DASH.repeat(position);
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .reduce((name1, name2) -> name1 + COMMA + name2)
                .orElse("");
        
        System.out.println(WINNER_PREFIX + winnerNames);
    }
}

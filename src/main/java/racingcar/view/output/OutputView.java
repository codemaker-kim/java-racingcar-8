package racingcar.view.output;

import static racingcar.global.Separator.COLON;
import static racingcar.global.Separator.COMMA;
import static racingcar.global.Separator.SPACE;

import racingcar.view.output.dto.CarInfo;
import racingcar.view.output.dto.CarInfoListDto;

public class OutputView {

    private static final String EMPTY_STRING = "";
    private static final String DASH = "-";
    private static final String WINNER_PREFIX = "최종 우승자";

    public static void printResultPrompt() {
        System.out.println("실행 결과");
    }

    public static void printRoundResult(CarInfoListDto dto) {
        dto.carInfoList()
                .forEach(OutputView::printCarStatus);

        System.out.println();
    }

    private static void printCarStatus(CarInfo carInfo) {
        String output = String.format("%s%s%s",
                carInfo.name(),
                getNamePositionSeparator(),
                generateDashes(carInfo.position())
        );

        System.out.println(output);
    }

    private static String generateDashes(int position) {
        return DASH.repeat(position);
    }

    public static void printWinners(CarInfoListDto winners) {
        String winnerNames = winners.carInfoList()
                .stream()
                .map(CarInfo::name)
                .reduce((name1, name2) -> name1 + getWinnerNameSeparator() + name2)
                .orElse(EMPTY_STRING);

        System.out.println(getWinnerPrefixFormat() + winnerNames);
    }

    private static String getNamePositionSeparator() {
        // " : " 를 반환.
        return String.join(
                COLON.getSign(),
                SPACE.getSign(),
                SPACE.getSign()
        );
    }

    private static String getWinnerNameSeparator() {
        // ", " 를 반환
        return String.join(
                EMPTY_STRING,
                COMMA.getSign(),
                SPACE.getSign()
        );
    }

    private static String getWinnerPrefixFormat() {
        // "최종 우승자 : " 를 반환
        return String.join(
                EMPTY_STRING,
                WINNER_PREFIX,
                getNamePositionSeparator()
        );
    }
}

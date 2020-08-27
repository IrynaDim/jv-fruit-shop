package core.basesyntax;

import core.basesyntax.exeptions.NotEnoughFruitsException;
import core.basesyntax.interfaces.BuyInterface;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Buy implements BuyInterface<String> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("uuuu-MM-dd");

    @Override
    public List<String> buying(List<String> fruitsAvailable, String fruitToByu)
            throws Exception {
        int c = 1;
        for (int j = 0; j < fruitsAvailable.size(); j++) {
            int amountBuying = Integer.parseInt(fruitToByu.split(",")[2]);
            if (fruitToByu.split(",")[1]
                    .equals(fruitsAvailable.get(j).split(",")[1])) {
                LocalDate dateOfAvailable = LocalDate.parse(fruitsAvailable.get(j)
                        .split(",")[3], FORMATTER);
                LocalDate dateOfBuying = LocalDate.parse(fruitToByu
                        .split(",")[3], FORMATTER);
                if (dateOfBuying.isEqual(dateOfAvailable)
                        || dateOfBuying.isBefore(dateOfAvailable)) {
                    if (Integer.parseInt(fruitsAvailable.get(j).split(",")[2]) >= amountBuying) {
                        int k = Integer.parseInt(fruitsAvailable.get(j)
                                .split(",")[2]) - amountBuying;
                        String newAmounrOfFruits = "" + k;
                        String[] splitAvailable = fruitsAvailable.get(j).split(",");
                        splitAvailable[2] = newAmounrOfFruits;
                        String newString = "";
                        for (String s : splitAvailable) {
                            newString = newString + s + ",";
                        }
                        fruitsAvailable.set(j, newString.substring(0, newString.length() - 1));
                        c = 0;
                        break;
                    } else {
                        if (amountBuying > Integer.parseInt(fruitsAvailable.get(j).split(",")[2])) {
                            String[] splitAvailable = fruitsAvailable.get(j).split(",");
                            splitAvailable[2] = "0";
                            String newString = "";
                            for (String s : splitAvailable) {
                                newString = newString + s + ",";
                            }
                            fruitsAvailable.set(j, newString.substring(0, newString.length() - 1));
                        }
                    }
                }
            }
        }
        if (c == 1) {
            throw new NotEnoughFruitsException("Not enough fruits to buy.");
        }
        return fruitsAvailable;
    }
}

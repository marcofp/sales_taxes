package org.marcofp.sales.boot;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.marcofp.sales.boot.config.ApplicationConfiguration;
import org.marcofp.sales.boot.config.ApplicationConfigurationImpl;
import org.marcofp.sales.dto.GoodDto;
import org.marcofp.sales.dto.ItemBasketDto;
import org.marcofp.sales.dto.ShoppingBasketDto;
import org.marcofp.sales.service.SalesApi;

/**
 * The main application.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public class Application {

    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {

        ApplicationConfiguration applicationConfiguration = new ApplicationConfigurationImpl();
        final SalesApi controller = applicationConfiguration.getSalesAPI();

        List<List<String>> data = null;
        try {
            data = readData(args[0]);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);

        }
        List<ItemBasketDto> items = new ArrayList<>();
        data.forEach(dataArray -> {
            if (dataArray.size() != 2) {
                System.err.println("The input file contains wrong data");
                System.exit(1);
            }
            final GoodDto goodById = controller.findGoodByName(dataArray.get(0).trim());
            if (goodById != null) {
                int quantity = 0;
                try {
                    quantity = Integer.parseInt(dataArray.get(1).trim());
                    if (quantity <= 0) {
                        System.err
                            .println("The provided quantity for good " + dataArray.get(0) + " must be an integer > 0");
                        System.exit(1);
                    }

                } catch (NumberFormatException e) {
                    System.err
                        .println("The provided quantity for good " + dataArray.get(0) + " must be an integer > 0");
                    System.exit(1);
                }
                items.add(new ItemBasketDto(goodById, quantity));
            } else {
                System.err.println("The provided good" + dataArray.get(0) + " does not exists");
                System.exit(1);
            }
        });
        final ShoppingBasketDto shoppingBasket = controller
            .calculateShoppingBasket(items);
        controller.printShoppingBasket(shoppingBasket);
    }

    private static List<List<String>> readData(String fileName) throws IOException {
        final URL resource = Application.class.getResource("/samples/" + fileName);
        if (resource == null) {
            System.err
                .println("The provided file " + fileName + " does not exists");
            System.exit(1);
        }
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(
            resource.getFile()))) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        }
        return records;
    }

    private static List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

}

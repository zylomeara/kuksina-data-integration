import beans.Constants;
import beans.CustomerCsvWriter;
import beans.CustomerGenerator;
import utils.ConfigurationUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var path = ConfigurationUtil.getConfigurationEntry(Constants.PATH_TO_DATA_DIR);
        System.out.println("Путь " + path);

        var list1 = CustomerGenerator.generateCustomer1(10);
        new CustomerCsvWriter(path).writeCustomer1(list1);

        var list2 = CustomerGenerator.generateCustomer2(10);
        new CustomerCsvWriter(path).writeCustomer2(list2);
    }
}

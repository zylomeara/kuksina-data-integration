package beans;

import utils.ConfigurationUtil;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

interface DateFunction {
    String apply(int day, int month, int year);
}

public class CustomerGenerator {
    public static  <T> T randomItem(T[] list) {
        var rnd = new Random();
        return list[rnd.nextInt(list.length)];
    }

    public static Integer[] rangeList (int start, int end) {
        return IntStream.range(start, end)
                .boxed()
                .collect(Collectors.toList())
                .toArray(new Integer[end - start]);
    }

    public static String generateDate(DateFunction fn) {
        var gc = new GregorianCalendar();

        var year = randomItem(rangeList(1900, 2020));

        gc.set(Calendar.YEAR, year);

        var dayOfYear = randomItem(rangeList(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR)));

        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);

        return fn.apply(gc.get(Calendar.DAY_OF_MONTH), gc.get(Calendar.MONTH) + 1, gc.get(Calendar.YEAR));
    }

    public static List<Customer1> generateCustomer1(int count) throws IOException {
        var nameList = ConfigurationUtil.getConfigurationEntry(Constants.CUSTOMER1_ACCOUNT_NAME_LIST).split(",");
        var trafficRange = ConfigurationUtil.getConfigurationEntry(Constants.CUSTOMER1_TRAFFIC_KB_RANGE).split("->");
        var cityRange = ConfigurationUtil.getConfigurationEntry(Constants.CUSTOMER1_CITY_NAME_RANGE).split("->");
        var streetNameRange = ConfigurationUtil.getConfigurationEntry(Constants.CUSTOMER1_STREET_NAME_RANGE).split("->");
        var streetRange = ConfigurationUtil.getConfigurationEntry(Constants.CUSTOMER1_STREET_NAME_RANGE).split("->");

        return Stream.iterate(1, i -> i + 1)
                .limit(count)
                .map((a) -> {
                    var accountName = randomItem(nameList);
                    var trafficKB = randomItem(rangeList(Integer.parseInt(trafficRange[0]), Integer.parseInt(trafficRange[1])));
                    var date = generateDate(((day, month, year) -> month + "-" + day + "-" + year));
                    var city = "City" + randomItem(rangeList(Integer.parseInt(cityRange[0]), Integer.parseInt(cityRange[1])));
                    var street = "Street" + randomItem(rangeList(Integer.parseInt(streetRange[0]), Integer.parseInt(streetRange[1])));
                    var streetNumber = randomItem(rangeList(Integer.parseInt(streetNameRange[0]), Integer.parseInt(streetNameRange[1])));
                    return new Customer1(accountName, trafficKB, date, city, street, streetNumber);
                })
                .collect(Collectors.toList());
    }

    public static List<Customer2> generateCustomer2(int count) throws IOException {
        var nameList = ConfigurationUtil.getConfigurationEntry(Constants.CUSTOMER2_ACCOUNT_NAME_LIST).split(",");
        var trafficRange = ConfigurationUtil.getConfigurationEntry(Constants.CUSTOMER2_TRAFFIC_KB_RANGE).split("->");
        var cityRange = ConfigurationUtil.getConfigurationEntry(Constants.CUSTOMER2_CITY_NAME_RANGE).split("->");
        var streetNameRange = ConfigurationUtil.getConfigurationEntry(Constants.CUSTOMER2_STREET_NAME_RANGE).split("->");
        var streetRange = ConfigurationUtil.getConfigurationEntry(Constants.CUSTOMER2_STREET_NAME_RANGE).split("->");

        return Stream.iterate(1, i -> i + 1)
                .limit(count)
                .map((a) -> {
                    var accountName = randomItem(nameList);
                    var trafficMB = randomItem(rangeList(Integer.parseInt(trafficRange[0]), Integer.parseInt(trafficRange[1])));
                    var date = generateDate(((day, month, year) -> day + "-" + month + "-" + year));
                    var city = "City" + randomItem(rangeList(Integer.parseInt(cityRange[0]), Integer.parseInt(cityRange[1])));
                    var street = "Street" + randomItem(rangeList(Integer.parseInt(streetRange[0]), Integer.parseInt(streetRange[1])));
                    var streetNumber = randomItem(rangeList(Integer.parseInt(streetNameRange[0]), Integer.parseInt(streetNameRange[1])));
                    return new Customer2(accountName, trafficMB, date, city + " " + street + " " + streetNumber);
                })
                .collect(Collectors.toList());
    }
}

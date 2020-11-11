package beans;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerCsvWriter {
    String pathToDir;

    public CustomerCsvWriter(String pathToDir) {
        this.pathToDir = pathToDir;
    }

    public void csvWriterOneByOne(List<String[]> rows, String path) throws IOException {
        var appendEnabled = true;
        var writer = new CSVWriter(new FileWriter(path, appendEnabled), CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER);
        rows.forEach(writer::writeNext);
        writer.close();
    }

    public void writeCustomer1(List<Customer1> customers1) throws IOException {
        var pathToCustomerDir = pathToDir + "/Customer1";
        var fileName = "data.csv";
        var rows = customers1.stream().map(customer1 -> new String[]{
                customer1.getAccountName(),
                String.valueOf(customer1.getTrafficKB()),
                customer1.getDate(),
                customer1.getCity(),
                String.valueOf(customer1.getStreet()),
                String.valueOf(customer1.getStreetNumber()),
        }).collect(Collectors.toList());
        csvWriterOneByOne(rows, pathToCustomerDir + "/" + fileName);
    }

    public void writeCustomer2(List<Customer2> customers2) throws IOException {
        var pathToCustomerDir = pathToDir + "/Customer2";
        customers2.forEach(customer2 -> {
            var fileName = customer2.getAccountName() + ".csv";
            List<String[]> rows = Collections.singletonList(new String[]{
                    String.valueOf(customer2.getTrafficMB()),
                    customer2.getDate(),
                    customer2.getFullAddressName()
            });
            try {
                csvWriterOneByOne(rows, pathToCustomerDir + "/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}

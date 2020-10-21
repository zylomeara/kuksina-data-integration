package beans;

public class Customer1 {
    String accountName;
    int trafficKB;
    String date;
    String city;
    String street;
    int streetNumber;

    public Customer1(String accountName, int trafficKB, String date, String city, String street, int streetNumber) {
        this.accountName = accountName;
        this.trafficKB = trafficKB;
        this.date = date;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public int getTrafficKB() {
        return trafficKB;
    }

    public String getDate() {
        return date;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }
}

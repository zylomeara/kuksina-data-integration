package beans;

public class Customer2 {
    String accountName;
    int trafficMB;
    String date;
    String fullAddressName;

    public String getAccountName() {
        return accountName;
    }

    public int getTrafficMB() {
        return trafficMB;
    }

    public String getDate() {
        return date;
    }

    public String getFullAddressName() {
        return fullAddressName;
    }

    public Customer2(String accountName, int trafficMB, String date, String fullAddressName) {
        this.accountName = accountName;
        this.trafficMB = trafficMB;
        this.date = date;
        this.fullAddressName = fullAddressName;
    }
}

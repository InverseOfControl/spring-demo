package data.bind;

public class Company {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "address='" + address + '\'' +
                '}';
    }
}

import java.util.Objects;

public class CustomerInquiries {

    private String name;
    private String inquiry;
    private int id;

    public CustomerInquiries(String name, String inquiry, int id) {
        this.name = name;
        this.inquiry = inquiry;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getInquiry() {
        return inquiry;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerInquiries that = (CustomerInquiries) o;
        return id == that.id && inquiry.equals(that.inquiry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inquiry, id);
    }

    @Override
    public String toString() {
        return "CustomerInquiries{" +
                "name='" + name + '\'' +
                ", inquiry='" + inquiry + '\'' +
                ", id=" + id +
                '}';
    }
}

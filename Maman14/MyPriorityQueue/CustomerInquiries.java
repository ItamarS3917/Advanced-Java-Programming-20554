import java.util.Objects;

public class CustomerInquiries {

    // Declare instance variables
    private String name;
    private String inquiry;
    private int id;

    /**
     * Constructor for the CustomerInquiries class
     * @param name the name of the customer
     * @param inquiry the inquiry made by the customer
     * @param id the id of the customer
     */
    public CustomerInquiries(String name, String inquiry, int id) {
        this.name = name;
        this.inquiry = inquiry;
        this.id = id;
    }

    /**
     * Getter for the id of the customer
     * @return the id of the customer
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for the inquiry made by the customer
     * @return the inquiry made by the customer
     */
    public String getInquiry() {
        return inquiry;
    }

    /**
     * Getter for the name of the customer
     * @return the name of the customer
     */
    public String getName() {
        return name;
    }

    /**
     * Overrides the equals method to compare two CustomerInquiries objects
     * @param o the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerInquiries that = (CustomerInquiries) o;
        return id == that.id && inquiry.equals(that.inquiry);
    }

    /**
     * Overrides the hashCode method
     * @return the hash code of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(inquiry, id);
    }

    /**
     * Overrides the toString method to return a string representation of the object
     */
    @Override
    public String toString() {
        return "CustomerInquiries{" +
                "name='" + name + '\'' +
                ", inquiry='" + inquiry + '\'' +
                ", id=" + id +
                '}';
    }
}

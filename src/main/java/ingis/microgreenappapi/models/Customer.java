package ingis.microgreenappapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Customer{


    //    @OneToMany
    @Id
    @GeneratedValue
    private int customerId;
    private static int nextId = 1;

    @Size(max = 50, message = "Name too long!")
    private String customerName;

    public Customer() {}

    public Customer(String customerName) {
        this.customerName = customerName;
        this.customerId = nextId;
        nextId++;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public int getId() {
        return customerId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }
}

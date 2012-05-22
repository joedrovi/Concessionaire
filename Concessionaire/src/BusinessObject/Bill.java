
package BusinessObject;

/**
 *
 * @author Jose Bernal
 */
public class Bill {
    Employee emp;
    Car car;
    Client client;
    String payType;
    String date;
    double cost;

    public Car getCar() {
        return car;
    }

    public Client getClient() {
        return client;
    }

    public double getCost() {
        return cost;
    }

    public String getDate() {
        return date;
    }

    public Employee getEmp() {
        return emp;
    }

    public String getPayType() {
        return payType;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }
    
}

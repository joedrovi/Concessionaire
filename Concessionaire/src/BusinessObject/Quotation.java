/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessObject;

/**
 *
 * @author Jose Bernal
 */
public class Quotation { 
    Employee emp;
    Car car;
    Client client;
    Fee[] fees;
    String payType;
    String date;
    double cost;

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

    public void setFees(Fee[] fees) {
        this.fees = fees;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

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

    public Fee[] getFees() {
        return fees;
    }

    public String getPayType() {
        return payType;
    }
}

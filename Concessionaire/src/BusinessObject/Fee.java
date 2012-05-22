
package BusinessObject;

/**
 *
 * @author Jose Bernal
 */
public class Fee {
    Bill bill;
    int id;
    String date;
    double deposit;
    double interest;

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public Bill getBill() {
        return bill;
    }

    public String getDate() {
        return date;
    }

    public double getDeposit() {
        return deposit;
    }

    public int getId() {
        return id;
    }

    public double getInterest() {
        return interest;
    }
    
}

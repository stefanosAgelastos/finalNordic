package databaseConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonia on 2017/05/25.
 */
public class Payments {

    private static Payments ourInstance = new Payments();
    private List<Payment> paymentList = new ArrayList<Payment>();

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public static Payments getInstance() {
        return ourInstance;
    }


    private Payments(){
        DBConnector db = new DBConnector();
        try {
            ResultSet result = db.makeQuery("select * from payments");
            while(result.next()){
                //Payment(int id, String cardType, int cardNumber, String cardHolder, int cardCVC, String cardExpiry)
                Payment toAdd= new Payment(result.getInt(("paymentid")), result.getString("cardtype"), result.getInt("cardnumber"),
                        result.getString("cardholder"), result.getInt("cardcvc") ,result.getString("cardexpiry"),
                        result.getDouble("amount"), result.getInt("bookingid"));
                paymentList.add(toAdd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.closeConnection();
        //TODO remove, this is just for debugging
        for(Payment p: paymentList){
            System.out.println(p);
        }}

    public void updatePayments(Payment toUpdate, String column, String newValue){
        DBConnector db = new DBConnector();
        try {
            db.makeUpdate("UPDATE payments SET "+column+"='"+newValue+"' WHERE id="+toUpdate.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int addPayment(Payments payments, String cardType, String cardNumber, String cardHolder, String cardCVC, String cardExpiry, double amount, int bookingid) {
        int res = 0;
        try {
            DBConnector db = new DBConnector();
            ResultSet getId=db.makeQuery("select max(paymentid) from payments");
            getId.next();
            int id=getId.getInt(1)+1;
            System.out.println(id);
            Payment newPayment= new Payment(id,cardType, cardNumber, cardHolder, cardCVC, cardExpiry, amount,bookingid);
            res = db.makeUpdate("INSERT INTO payments (paymentid,cardtype,cardnumber,cardcvc,cardholder,cardexpiry,amount,bookingid) VALUES" +
                    " ('"+id+"','"+cardType+"','"+cardNumber+"','"+cardCVC+"','"+cardHolder+"','"+cardExpiry+"','"+amount+"','"+bookingid+"')");
            List<Payment> paymentList = payments.getPaymentList();
            if(res==1) paymentList.add(newPayment);
            return id;
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return -1;
    }

    public Payment searchPayment(int paymentid) {

        for(Payment p : getPaymentList()) {
            if(p.getId() == paymentid) {
                return p;
            }
        }
        return null;
    }


}
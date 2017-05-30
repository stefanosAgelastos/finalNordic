package model;

/**
 * Created by ADMIN on 27/05/2017.
 */
public class Payment {

    private int id;
    private String cardType;
    private int cardNumber;
    private String cardHolder;
    private int cardCVC;
    private String cardExpiry;
    private int bookingId;



    private double amount;

    public Payment(int id,String cardType, String cardNumber, String cardHolder, String cardCVC, String cardExpiry, double amount,int bookingid) {
        this.id = id;
        this.cardType = cardType;
        this.cardNumber = Integer.parseInt(cardNumber);
        this.cardHolder = cardHolder;
        this.cardCVC = Integer.parseInt(cardCVC);
        this.cardExpiry = cardExpiry;
        this.amount = amount;
        this.bookingId = bookingid;

    }

    public Payment(int id, String cardType, int cardNumber, String cardHolder, int cardCVC, String cardExpiry, double amount,int bookingid) {
        this.id = id;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.cardCVC = cardCVC;
        this.cardExpiry = cardExpiry;
        this.amount = amount;
        this.bookingId = bookingid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public int getCardCVC() {
        return cardCVC;
    }

    public void setCardCVC(int cardCVC) {
        this.cardCVC = cardCVC;
    }

    public String getCardExpiry() {
        return cardExpiry;
    }

    public void setCardExpiry(String cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
}


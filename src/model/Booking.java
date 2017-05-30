package model;

import databaseConnection.Bookings;
import databaseConnection.Fleet;
import javafx.beans.property.*;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by ADMIN on 24-05-2017.
 */
public class Booking {

    private int id;



    private double amount;

    private StringProperty status = new SimpleStringProperty(this, "title", "unknown");
    private DoubleProperty distance1 = new SimpleDoubleProperty(this, "distance1", 0);
    private DoubleProperty distance2 = new SimpleDoubleProperty(this, "distance1", 0);
    private ObjectProperty<LocalDate> startDate = new SimpleObjectProperty<>(this, "startDate", null);
    private ObjectProperty<LocalDate> endDate = new SimpleObjectProperty<>(this, "endDate", null);
    private BooleanProperty extra1 = new SimpleBooleanProperty(this, "extra1", false);
    private BooleanProperty extra2 = new SimpleBooleanProperty(this, "extra2", false);
    private BooleanProperty extra3 = new SimpleBooleanProperty(this, "extra3", false);
    private BooleanProperty extra4 = new SimpleBooleanProperty(this, "extra4", false);
    private DoubleProperty price = new SimpleDoubleProperty(this,"price", 0.0);
    private int customerid;
    private int motorhomeid;
    private Motorhome bookedMotorhome = null;
    private ArrayList<Payment> paymentList = new ArrayList<>();


    public Booking(){

    }

    public Booking(int id, String status, Double distance1, Double distance2, String startDate, String endDate,
                   Boolean extra1, Boolean extra2, Boolean extra3, Boolean extra4, int motorhomeid, int customerid) {
        this.id = id;
        this.status.setValue(status);
        this.distance1.setValue(distance1);
        this.distance2.setValue(distance2);
        this.startDate.setValue(LocalDate.parse(startDate));
        this.endDate.setValue(LocalDate.parse(endDate));
        this.extra1.setValue(extra1);
        this.extra2.setValue(extra2);
        this.extra3.setValue(extra3);
        this.extra4.setValue(extra4);
        this.customerid = customerid;
        this.motorhomeid = motorhomeid;
    }


    public Booking(int id, String status, Double distance1, Double distance2, LocalDate startDate, LocalDate endDate,
                   Boolean extra1, Boolean extra2, Boolean extra3, Boolean extra4, int motorhomeid, int customerid) {
        this.id = id;
        this.status.setValue(status);
        this.distance1.setValue(distance1);
        this.distance2.setValue(distance2);
        this.startDate.setValue(startDate);
        this.startDate.setValue(endDate);
        this.extra1.setValue(extra1);
        this.extra2.setValue(extra2);
        this.extra3.setValue(extra3);
        this.extra4.setValue(extra4);
        this.customerid = customerid;
        this.motorhomeid = motorhomeid;
    }

    public void addPaymentToBoking(Payment p) {
        paymentList.add(p);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public double getDistance1() {
        return distance1.get();
    }

    public DoubleProperty distance1Property() {
        return distance1;
    }

    public void setDistance1(double distance1) {
        this.distance1.set(distance1);
    }

    public double getDistance2() {
        return distance2.get();
    }

    public DoubleProperty distance2Property() {
        return distance2;
    }

    public void setDistance2(double distance2) {
        this.distance2.set(distance2);
    }

    public LocalDate getStartDate() {
        return startDate.get();
    }

    public ObjectProperty<LocalDate> startDateProperty() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate.set(startDate);
    }

    public LocalDate getEndDate() {
        return endDate.get();
    }

    public ObjectProperty<LocalDate> endDateProperty() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate.set(endDate);
    }

    public boolean isExtra1() {
        return extra1.get();
    }

    public BooleanProperty extra1Property() {
        return extra1;
    }

    public void setExtra1(boolean extra1) {
        this.extra1.set(extra1);
    }

    public boolean isExtra2() {
        return extra2.get();
    }

    public BooleanProperty extra2Property() {
        return extra2;
    }

    public void setExtra2(boolean extra2) {
        this.extra2.set(extra2);
    }

    public boolean isExtra3() {
        return extra3.get();
    }

    public BooleanProperty extra3Property() {
        return extra3;
    }

    public void setExtra3(boolean extra3) {
        this.extra3.set(extra3);
    }

    public boolean isExtra4() {
        return extra4.get();
    }

    public BooleanProperty extra4Property() {
        return extra4;
    }

    public void setExtra4(boolean extra4) {
        this.extra4.set(extra4);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    boolean isWithinRange(LocalDate startDate, LocalDate endDate) {
        return (startDate.isBefore(getStartDate()) && endDate.isBefore(getStartDate())) ||
                (startDate.isAfter(getEndDate()) && endDate.isAfter(getEndDate()));
    }

    public double getPrice() {
        return price.get();
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public int getMotorhomeId() {
        return motorhomeid;
    }

    public boolean isBookedNow() {

        LocalDate today = LocalDate.now();
        return (today.isAfter((getStartDate())) || today.isEqual(getStartDate())) && (today.isBefore(getEndDate()) || today.isEqual(getEndDate()));

    }

    public void setMotorhomeId(int motorhomeId) {
        this.motorhomeid = motorhomeId;
    }

    private void setListeners() {

        status.addListener(
                (v, oldValue, newValue) -> {
                    Bookings.getInstance().updateBookings(this, "status", newValue);
                });
        distance1.addListener(
                (v, oldValue, newValue) -> {
                    Bookings.getInstance().updateBookings(this, "distance1", newValue.toString());
                    calculatePrice();
                });
        distance2.addListener(
                (v, oldValue, newValue) -> {
                    Bookings.getInstance().updateBookings(this, "distance2", newValue.toString());
                    calculatePrice();
                });
        startDate.addListener(
                (v, oldValue, newValue) -> {
                    Bookings.getInstance().updateBookings(this, "startDate", newValue.toString());
                    calculatePrice();
                });
        endDate.addListener(
                (v, oldValue, newValue) -> {
                    Bookings.getInstance().updateBookings(this, "endDate", newValue.toString());
                    calculatePrice();
                });

        extra1.addListener(
                (v, oldValue, newValue) -> {
                    Bookings.getInstance().updateBookings(this, "extra1", newValue.toString());
                    calculatePrice();
                });
        extra2.addListener(
                (v, oldValue, newValue) -> {
                    Bookings.getInstance().updateBookings(this, "extra2", newValue.toString());
                    calculatePrice();
                });
        extra3.addListener(
                (v, oldValue, newValue) -> {
                    Bookings.getInstance().updateBookings(this, "extra3", newValue.toString());
                    calculatePrice();
                });
        extra4.addListener(
                (v, oldValue, newValue) -> {
                    Bookings.getInstance().updateBookings(this, "extra4", newValue.toString());
                    calculatePrice();
                });
    }

    /**
     * this method is called by the Bookings singleton,
     * whenever we launch the app, all bookings are loaded from the DB
     * and constructed by the Bookings.
     * Payments singleton is already constructed,
     * so by iterating we get a list of all relevant for this Booking payments.
     *
     */
    public void setPaymentList(ArrayList<Payment> paymentsOfTheBooking) {
        this.paymentList=paymentsOfTheBooking;
    }

    /**
     * to be used later
     * @param newPayment latest payment to be added to the Booking's list of Payments.
     */
    public void addPayment(Payment newPayment){
        this.paymentList.add(newPayment);
    }

    public void calculatePrice(){
        double temp=0;
        //add the fee for drop off and collection of the motorhome
        temp+=(distance1.doubleValue()+distance2.doubleValue())*0.7;
        //price of all the extras per booking
        double extrasPrice =0.0;
        if(extra1.getValue())
            extrasPrice+=100;
        if(extra2.getValue())
            extrasPrice+=100;
        if(extra3.getValue())
            extrasPrice+=100;
        if(extra4.getValue())
            extrasPrice+=100;
        //add the extras to the price
        temp+=extrasPrice;
        //get the motorhome object
        Motorhome thisOne= Fleet.getInstance().searchById(motorhomeid);
        if(thisOne!=null){
            //if we found it, we get the low season price
            double pricePerDay= thisOne.getPrice();
            //we are using a cursor day, will add the price for that day and then move the cursor date one day forward
            LocalDate cursorDay=startDate.getValue();
            while(!cursorDay.equals(endDate.getValue())){
                int cursorMonth = cursorDay.getMonthValue();
                //high season price= lowseason + lowseason*0.3 + (lowseason + lowseason*0.3)*0,6= 2,08*lowseason
                if(cursorMonth==6||cursorMonth==7){
                    temp+=pricePerDay*2.08;
                }
                //medium season price = lowseason + lowseason*0,3 = 1,3*lowseason
                else if(cursorMonth==4||cursorMonth==5||cursorMonth==8||cursorMonth==9){
                    temp+=pricePerDay*1.3;
                }
                // low season price
                else{
                    temp+=pricePerDay;
                }
                cursorDay= cursorDay.plusDays(1);
            }
        }
        setAmount(temp);
    }

    public boolean dropOffToday()
    {
        LocalDate today = LocalDate.now();
        return(today.isEqual(getEndDate()));
    }
}





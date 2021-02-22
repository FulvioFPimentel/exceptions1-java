package model.entities;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

   private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    public Reservation(){
    }
    public Reservation( Integer roomNumber, Date checkIn, Date checkOut){
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public void setRoomNumber(Integer roomNumber){
        this.roomNumber = roomNumber;
    }

    public Integer getRoomNumber(){
        return roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duration(){
        long diff = checkOut.getTime() - checkIn.getTime();    // converter os valores checkIn e checkOut em mile segundo e calcula a diferenção
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);  // converter o valor de diff de mile segundo para dias
    }

    public void updateDates(Date checkIn, Date checkOut){
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString(){
        return "Room "
                + roomNumber
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out:"
                + sdf.format(checkOut)
                + ", "
                + duration()
                + " nights";

    }

}

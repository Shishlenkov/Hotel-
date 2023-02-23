package hotel;

public class Room {
    private int place;
    private int number;
    private boolean wc;
    private boolean condish;
    private boolean tv;
    private boolean reserved;

    public Room(int number, int place, boolean wc, boolean condish, boolean tv) {
        this.place = place;
        this.number = number;
        this.wc = wc;
        this.condish = condish;
        this.tv = tv;
        this.reserved = false;

    }

    public int getPlace() {
        return place;
    }

    public int getNumber() {
        return number;
    }

    public boolean isWc() {
        return wc;
    }

    public boolean isCondish() {
        return condish;
    }

    public boolean isTv() {
        return tv;
    }

    public boolean isReserved() {
        return reserved;
    }

    public boolean setReserved(boolean reserved) {

        this.reserved = reserved;
        return reserved;
    }



}

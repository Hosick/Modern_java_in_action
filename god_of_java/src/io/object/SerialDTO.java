package io.object;

import java.io.Serializable;

public class SerialDTO implements Serializable {
    private final long serialVersionUID = 1L;
    private String bookName;
    transient private int bookOrder;
    private boolean bestSeller;
    private long soldPerDay;
    private String bookType = "IT";

    public SerialDTO(String bookName, int bookOrder, boolean bestSellor, long soldPerDay) {
        super();
        this.bookName = bookName;
        this.bookOrder = bookOrder;
        this.bestSeller = bestSellor;
        this.soldPerDay = soldPerDay;
    }

    @Override
    public String toString() {
        return "SerialDTO [" +
                "bookName='" + bookName + ", bookOrder=" + bookOrder +
                ", bestSeller=" + bestSeller + ", soldPerDay=" + soldPerDay +
                ", bookType = " + bookType + "]";
    }
}

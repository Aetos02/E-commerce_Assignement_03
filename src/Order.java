import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    double totalPrice;
    private int itemCount;
    private List<OrderObserver> observers;

    private String shipping;

    public Order(int id) {
        this.id = id;
        this.totalPrice = 0.0;
        this.itemCount = 0;
        this.observers = new ArrayList<>();
        this.shipping=null;
    }

    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String setShipping(int items){

        if(items>5){
            this.shipping="no";
        }else{
            this.shipping="yes";
        }

        return null;
    }

    public void addItem(double price) {
        totalPrice += price;
        itemCount++;

    }

    public void proceedPayment(){
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public String toString() {
        return "Order #" + id + " | Total Price: $" + totalPrice + " | Item Count: " + itemCount + " | With shipping cost : "+ shipping;
    }
}

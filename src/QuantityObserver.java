public class QuantityObserver implements OrderObserver {
    @Override
    public void update(Order order) {
        if (order.getItemCount() > 5){
            order.setShipping(order.getItemCount());
        } else {
            order.totalPrice += 10;
            order.setShipping(order.getItemCount());
        }
    }
}

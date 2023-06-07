
// Main class for testing
public class ECommerceApp {
        public static void main(String[] args) {
            Order order = new Order(1);
            PriceObserver priceMonitor = new PriceObserver();
            QuantityObserver quantityMonitor = new QuantityObserver();

            order.attach(priceMonitor);
            order.attach(quantityMonitor);

            order.addItem(50);
            order.addItem(50);
            order.addItem(50);

            order.proceedPayment();

            System.out.println(order);
        }


}

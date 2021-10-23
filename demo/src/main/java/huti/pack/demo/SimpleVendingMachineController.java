package huti.pack.demo;


public class SimpleVendingMachineController implements VendingMachineController {

    private SimpleCalculator calculator = new SimpleCalculator();

    @Override
    public CoinBundle calculateChange(VendingMachineRequest request) {
        int total = calculator.calculateTotal(request.enteredCoins);
        int totalChange = total - request.product.getPrice();
        return calculator.calculateChange(totalChange);
    }
}

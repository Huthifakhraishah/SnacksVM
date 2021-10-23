package huti.pack.demo;


public class TextVendingMachineInterface implements VendingMachineInterface {

    private VendingMachineController controller = new SimpleVendingMachineController();
    private int selectedProduct;
    private CoinBundle change;


    @Override
    public void displayProducts() {
        System.out.println("              It's Snack Time                 ");
        System.out.println("-----------------------------------------------");
        System.out.println("              Choose A Snack                  ");
        System.out.println("                                              ");
        for(Product product: Product.values()){
            if(!Product.EMPTY.equals(product)) {
                System.out.println("     " + product.getSelectionNumber() + "  " + product.name() + " - Price: " + product.getPrice() + "   ");
            }
        }
        System.out.println("                                              ");
        System.out.println(" Please select your product: ");


    }

    @Override
    public void selectProduct(int product) {
        this.selectedProduct = product;
    }

    @Override
    public void displayEnterCoinsMessage() {
        System.out.println(" Enter coins : ");
        System.out.println(" 10 cents coins, 20 cents coins, 50 cents coins, 100 cents coins (one dollar $)  ");
        System.out.println("Way of insartion if you have only 10 cent coin type and price is 30 cents enter 3 coins(10 cents) as follows:");
        System.out.println("(# of 10cent),(# of 20cent),(# of 50cent),(# of 1$)            ");
        System.out.println("      3      ,      0      ,     0       ,   0 ");
        System.out.println("Plese enter coins:");

    }

    @Override
    public void enterCoins(int... coins) {
        VendingMachineRequest request = new VendingMachineRequest(selectedProduct, coins);
        change = controller.calculateChange(request);

    }

    @Override
    public void displayChangeMessage() {
        System.out.println("                                              ");
        System.out.println("Your change is :"+ change.getTotal()+"cents split as follows: ");
        if (change.number100CentsCoins>=0){
        System.out.println("   You owe "+  change.number100CentsCoins +" Dollar");}
        else{
        System.out.println("   You owe "+ -1 * change.number100CentsCoins +" Dollar");}
        if (change.number50CentsCoins>=0){
        System.out.println("    50 cents coins: "+ change.number50CentsCoins);}
        else{
        System.out.println("   You owe 50 cents coins: "+ -1 * change.number50CentsCoins);}
        if (change.number20CentsCoins>=0){
        System.out.println("    20 cents coins: "+ change.number20CentsCoins);}
        else{
        System.out.println("   You owe 20 cents coins: "+ -1 * change.number20CentsCoins);}
        if (change.number10CentsCoins>=0){
        System.out.println("    10 cents coins: "+ change.number10CentsCoins);}
        else{
        System.out.println("   You owe 10 cents coins: "+ -1 * change.number10CentsCoins);}

    }
}

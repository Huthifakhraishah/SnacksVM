package huti.pack.demo;
import java.util.Scanner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        VendingMachineInterface machineInterface = new TextVendingMachineInterface();

        machineInterface.displayProducts();

        String selectedProduct = scanner.nextLine();
        machineInterface.selectProduct(Integer.parseInt(selectedProduct));

        machineInterface.displayEnterCoinsMessage();

        String userEnteredCoins = scanner.nextLine();
        int[] enteredCoins = Coin.parseCoins(userEnteredCoins);
        machineInterface.enterCoins(enteredCoins);

        machineInterface.displayChangeMessage();

    }
}

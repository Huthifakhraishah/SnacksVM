package huti.pack.demo;


public enum Product {
    KitKats(1,100),Funions(2,60),Cheetos(3,100), WATER(4,30), SANDWICH(5,150), EMPTY(0,0);

    private int selectionNumber;
    private int price;

    Product(int selectionNumber, int price){
        this.selectionNumber = selectionNumber;
        this.price = price;
    }

    public int getSelectionNumber(){
        return selectionNumber;
    }

    public int getPrice(){
        return this.price;
    }

    public static Product valueOf(int numberSelection){
        for(Product product: Product.values()){
            if(numberSelection == product.getSelectionNumber()){
                return product;
            }
        }
        return EMPTY;
    }
}


import entity.*;
import exception.ItemNotFoundException;
import service.*;

public class ApplicationRunner {
    public static void main(String[] args) throws ItemNotFoundException {

        UserService userService = new UserServiceImplementation();
        ShoppingService shoppingService = new ShoppingService();
        Cart shoppingCart = new Cart();


        System.out.println("Alisveris yapabilmek icin kayit olusturmaniz gereklidir...");
        User currentUser = userService.addUser();

        System.out.println("Kayit oldugunuz icin tesekkur ederiz... Iyi alisverisler..");
        shoppingService.completePurchase(currentUser, shoppingCart);


    }
}

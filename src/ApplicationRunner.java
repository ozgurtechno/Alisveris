import database.Database;
import entity.*;
import enums.City;
import enums.Color;

import java.util.Scanner;

public class ApplicationRunner {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Database database = new Database();

        // Bu musteri ornek olarak olusturulmustur, asagida kullanicidan alinacak veriler ile musteri kaydi yapilacaktir.
        User musteri1 = new User("Ahmet",
                              "Basarir",
                              "Java",
                              "12345",
                                new Address("Asla vazgecmez Mah, Java yi sever Sk. No:99",
                                        City.ATLANTA,
                                        "10001" ));

        // Olusturulan user database e kayit edilecek...
        database.addUser(musteri1);

        // Bu urunler magazada satilan ve database de kayitli urunlerdir...
        Item item1 = new Item("Macbook", Color.BLACK,1500);
        Item item2 = new Item("IPhone",Color.GREEN,1200);
        Item item3 = new Item("Samsung",Color.RED,800);
        Item item4 = new Item("Mouse",Color.BLACK,100);
        database.addItem(item1);
        database.addItem(item2);
        database.addItem(item3);
        database.addItem(item4);

        //---------------------------- Yukarisi ornek data olup asil veriler kullanicidan alinacaktir -----------------

        // Yeni Musteri olusturalim...Musteri bilgilerini Scanner Class ile kullanicidan alalim...
        System.out.println("Uye olmak icin kayit olusturmaniz gereklidir...");
        System.out.println("Lutfen adinizi girin : ");
        String firstName = scan.nextLine();

        System.out.println("Lutfen soyadinizi girin : ");
        String lastName = scan.nextLine();

        System.out.println("Adresinizi giriniz..:");
        String address = scan.nextLine();

        System.out.println("Yasadiginiz sehiri seciniz..:");
        for (int i = 0; i < City.values().length; i++) {
            System.out.println(City.values()[i]+" icin "+i);
        }
        int chosenCity = scan.nextInt();

        System.out.println("Zipcode..: ");
        String zipCode = scan.next();

        System.out.println("Lutfen kullanici adinizi belirleyin : ");
        String userName = scan.next();

        System.out.println("Lutfen sifrenizi belirleyin :");
        String password = scan.next();

        User currentUser = new User(firstName, lastName, userName, password, new Address(address, City.values()[chosenCity], zipCode));
        database.addUser(currentUser);
        System.out.println("kayit oldugunuz icin tesekkur ederiz... Iyi alisverisler..");

        Cart shoppingCart = new Cart();
        while(true){

            // Kullaniciya hangi urunu almak istedigini soralim ve urunleri listeleyelim...
            System.out.println("Lutfen urun seciminizi yaparak SEPET'e ekleyiniz...");
            System.out.println("---------------------------------------------------");
            for (int i = 0; i < Database.items.size(); i++) {
                System.out.println(Database.items.get(i).getName()+" icin "+i+" yazip ENTER a basiniz");
            }
            int chosenItemIndex = scan.nextInt();

            // Secilen urunden kac adet almak istedigini soralim...
            System.out.println("Secilen urun "+Database.items.get(chosenItemIndex).getName()+"'den kac adet satin almak istiyorsunuz?");
            int chosenItemCount = scan.nextInt();

            // Kullanicinin girdigi bilgileri Alisveris Sepetine ekleyelim...
            CartItem cartItem = new CartItem(Database.items.get(chosenItemIndex),chosenItemCount);
            shoppingCart.addToCart(cartItem);

            // Sepenizdeki urunlerin toplam fiyati bu, ne yapmak istersiniz?
            System.out.println("Sepetinizde "+shoppingCart.getTotalCartCost()+" Euro degerinde urun bulunmaktadir...");
            System.out.println("Alisverisi tamamlamak  icin - 1 i tuslayin");
            System.out.println("Alisverise devam etmek icin - 2 i tuslayin");

            int userChoice = scan.nextInt();
            if (userChoice==1) {
                System.out.println("Odemeniz alinmistir...Bizi tercih ettiginiz icin tesekkur ederiz");
                System.out.println("Paketiniz '"+currentUser.getAddress().getDescription()+ "' adresine kargolanacaktir.");
                shoppingCart.emptyCart();
                break;
            } else if (userChoice==2) {
                continue;
            }
        }

    }
}

package org.example.presentation;

import org.example.databases.RestaurantDB;
import org.example.entities.Restaurant;
import org.example.entities.RestaurantStatus;

import java.util.List;
import java.util.Scanner;

public class RestaurantApp {

    static Scanner scanner = new Scanner(System.in);
    static RestaurantDB dbRestaurant = new RestaurantDB();


    public static void main(String[] args) {

        Menu();

    }
    public static void Menu(){
        int choose = -1;

        do {

            System.out.println();
            System.out.println("------------Restaurant Rezervasyon Sistemimize Hoşgeldiniz----------");
            System.out.println("1-Yönetici İşlemleri");
            System.out.println("0-Çıkış");
            System.out.print("Seçiminiz: ");


            try {
                choose = scanner.nextInt();

            }catch (Exception e){
                System.out.println("\nLutfen Geçerli Bir Değer Giriniz...\n");
                continue;
            }
            finally {
                scanner.nextLine();
                System.out.println();
            }

            switch (choose) {
                case 1: { //Yönetici İşlemleri
                    managerMenu();
                    break;
                }

                case 0: {
                    System.out.println("Restaurant'ımızı Tercih Ettiğiniz İçin Teşekkür Ederiz. İyi Günler...");
                    break;
                }
                default:{
                    System.out.println("Lütfen Geçerli Bir Değer Giriniz...");
                }
            }


        }while (choose != 0);
    }


    public static void managerMenu(){
        int choose = -1;

        do {

            System.out.println("-----------Yönetici İşlemleri----------");
            System.out.println("1-Restaurant İşlemleri");
            System.out.println("2-Müşteri İşlemleri");
            System.out.println("3-Rezervasyon İşlemleri");
            System.out.println("0-Çıkış");

            try {
                choose = scanner.nextInt();

            }catch (Exception e){
                System.out.println("\nLutfen Geçerli Bir Değer Giriniz...\n");
                continue;
            }
            finally {
                scanner.nextLine();
                System.out.println();
            }

            switch (choose) {

                case 1: {//restaurant işlemleri
                    restaurantMenuChoose();
                    break;
                }
                case 2: { //müşteri işlemleri
                    break;
                }
                case 3: { //Rezervasyon işlemleri
                    break;
                }
                case 0: {
                    System.out.println("Program Sonlandırılıyor...");
                    System.exit(0);
                }
            }

        }while (choose != 0);
    }



    public static void restaurantMenuChoose(){
        int choose = -1;
        do {

            System.out.println("------------Restaurant İşlemleri Menüsüne Hoşgeldiniz-----------");
            System.out.println("1-Restaurant Ekle");
            System.out.println("2-Restaurant Listele");
            System.out.println("3-Restaurant Ara");
            System.out.println("4-Restaurant Sil");
            System.out.println("5-Programdan Çık");
            System.out.println("0-Yönetici İşlemleri Menüsüne Dön");
            System.out.print("Seçiminiz: ");

            try {
                choose = scanner.nextInt();

            } catch (Exception e){
                System.out.println("\nLütfen Geçerli Bir Değer Giriniz...\n");
            }
            finally {
                scanner.nextLine();
            }

            switch (choose){
                case 1: { //Restaurant Ekle
                    createRestaurant(); //yeni bir restaurant ekleyeceğimi belirttim.Dönüş tipi restaurant nesnesi olacak.
                    break;
                }
                case 2: { //Restaurant Listele
                    getRestaurantList();
                    break;
                }
                case 3: { //Restaurant Ara
                    System.out.println(findByRestaurant());
                    break;
                }
                case 4: { //Restaurant Sil
                    //**************
                    break;
                }
                case 5: {
                    System.out.println("Programdan Çıkılıyor...");
                    System.exit(0);
                    break;
                }
                case 0: {
                    System.out.println("Ana Menüye Dönülüyor...");
                    break;
                }
            }

        } while (choose != 0);
    }
    // > --- Case 3 : Start  Restaurant Arama --- <
    private static Restaurant findByRestaurant() {
        System.out.print("\nLutfen Aramak İstediğiniz Restaurant'ın Adını Giriniz: ");
        String restaurantName = scanner.nextLine();
        Restaurant restaurant = dbRestaurant.findByRestaurantName(restaurantName);

        if (restaurant == null){
            System.out.println("Bu Restaurant Adına Ait Bilgi Bulunamamıştır.");
            return null;
        }
        return restaurant;
    }
    // > --- Case 3 : End  Restaurant Arama --- <



    // > --- Case 2 : Start  Restaurant Listeleme --- <
    public static List<Restaurant> getRestaurantList(){
        List<Restaurant> restaurantList = dbRestaurant.findAll();
        if(restaurantList.size() == 0){
            System.out.println("Restaurant Listesinin İçerisi Boş! Gösterilecek Bir Bilgi Yoktur...\n");
        }
        else {
           for (Restaurant item: restaurantList){
               System.out.println(item);
           }
        }
        return restaurantList;
    }
    // > --- Case 2 : End  Restaurant Listeleme --- <


    // > --- Case 1 : Start  Restaurant Ekleme --- <
    public static Restaurant createRestaurant(){
        Restaurant restaurant;
        String restaurantName = getRestaurantName(); //kullanıcıdan restaurant ismini metot üzerinden alıyorum.
        
        if(dbRestaurant.isRestaurantExist(restaurantName)){ //restaurant adı daha önce eklendiyse böyle bir isim daha önce kullanılmış desin.
            System.out.println("Bu Restaurant İsmi Daha Önce Kullanılmış. Başka Bir İsim Girmeyi Deneyiniz.");
        }
        else {

            restaurant = new Restaurant();
            restaurant.setName(restaurantName);
            restaurant.setAddress(getrestaurantAddress()); //kullanıcıdan adres bilgilerini aldım.
            restaurant.setPhoneNumber(getPhoneNumber()); //kullanıcıdan telefon numarası bilgisini aldım.
            restaurant.setRestaurantCapacity(getRestaurantCapacity()); //kullanıcıdan kapasite sayısını aldım.
            restaurant.setRestaurantStatus(RestaurantStatus.OPEN);
            dbRestaurant.crate(restaurant);
            System.out.println("Restaurant Ekleme İşlemi Başarılı Bir Şekilde Gerçekleştirilmiştir...");
            return restaurant;
        }
        return null;
    }

    public static int getRestaurantCapacity(){

        while (true){
            System.out.print("Lutfen Restaurant'ınızın Kapasite Sayısını Giriniz: ");
            int capacity = scanner.nextInt();

            if(capacity == 0){
                System.out.println("\nRestaurant Kapasite Sayınız 0 Olamaz. Lütfen Tekrar Deneyiniz...\n");
            }
            return capacity;
        }


    }

    public static String getPhoneNumber(){

       while (true) {
           System.out.print("Lütfen Telefon Numaranızı Giriniz: ");
           String phoneNumber = scanner.nextLine();

           if (phoneNumber.isEmpty()) {
               System.out.println("\nTelefon Numarası Alanı Boş Geçilemez...\n");
           } else if (!isNumeric(phoneNumber)) {
               System.out.println("\nTelefon Numaranız Sadece Sayısal Değer İçermelidir...\n");
           }
           else {
               return phoneNumber;
           }
       }
    }

    public static String getrestaurantAddress(){
        String address;
        while (true) {
            System.out.print("Lütfen Restaurantınızın Adresini Giriniz: ");
           address = scanner.nextLine();

            if (address.isEmpty()) {
                System.out.println("\nAdres Alanı Boş Geçilemez.\n");
            }
            else {
                return address;
            }
        }
    }

    public static String getRestaurantName(){
        String name;
        while (true) {
            System.out.print("Lutfen Bir Restaurant İsmi Giriniz: ");
            name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("\nRestaurant İsmi Boş Olamaz. Lütfen Tekrar Deneyiniz.\n");
            } else if (isNumeric(name)) {
                System.out.println("\nRestaurant Adı Numerik Değer İle Başlayamaz...\n");
            }
            else {
                return name;
            }
        }

    }

    private static boolean isNumeric(String value){
        for (int i = 0; i < value.length(); i++) {
            if(!Character.isDigit(value.charAt(i))) { //numerik değer değilse false döner.
                return false;
            }
        }
        return true;
    }
    // > --- Case 1 Restaurant Ekleme : End --- <
}

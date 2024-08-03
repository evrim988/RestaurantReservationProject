package org.example.entities;

public class Restaurant extends BaseEntity{

    private static final int RESTAURANT_CAPACITY = 300;

    private String name;
    private String address;
    private String phoneNumber;
    private int restaurantCapacity;
    RestaurantStatus restaurantStatus;


    public Restaurant() {
        super(); //id ve oluşturulma tarihi baseEntity constructordan geliyor
        setRestaurantCapacity(restaurantCapacity);
        this.restaurantStatus = RestaurantStatus.CLOSE;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRestaurantCapacity() {
        return restaurantCapacity;
    }

    public void setRestaurantCapacity(int restaurantCapacity) {
        if(restaurantCapacity < RESTAURANT_CAPACITY) {
            this.restaurantCapacity = restaurantCapacity;
        }
        else {
            System.out.println("Kapasitemiz Dolmuştur. Lütfen Uygun Bir Zamanda Tekrar Deneyiniz...");
        }
    }

    public RestaurantStatus getRestaurantStatus() {
        return restaurantStatus;
    }

    public void setRestaurantStatus(RestaurantStatus restaurantStatus) {
        this.restaurantStatus = restaurantStatus;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "RestaurantId='" + getId() + '\'' +
                "name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", restaurantCapacity=" + getRestaurantCapacity() +
                ", restaurantStatus=" + getRestaurantStatus() +
                '}';
    }
}

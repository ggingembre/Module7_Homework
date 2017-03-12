package Task1_2;
//import java.util.Currency;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Guillaume Gingembre on 11/03/2017.
 */
public class Main {

    public static void main(String[] args) {

        // В Main создайте 10 заказов с 10 пользователями и добавьте его в List.
        // public Order(long id, int price, Currency currency, String itemName, String shopIdentificator, User user)
        // public User(long id, String firstName, String lastName, String city, int balance)

        User guillaume = new User (111, "Guillaume", "Gingembre", "Paris", 1000);
        User elena = new User (112, "Elena", "Izotova", "Pologi", 500);
        User charles = new User (113, "Charles", "Galant", "Kiev", 900);
        User xsenia = new User (114, "Xsenia", "Galant", "Donetsk", 400);
        User jf = new User (115, "Jean François", "Drean","Lyon", 1200);
        User larissa = new User (116, "Larissa", "Drean", "Poltova", 500);
        User vassia = new User (117, "Vassia", "Kuznetsov", "Kiev", 1100);
        User natasha = new User (118, "Natasha", "Kuznetsova", "Donetsk", 1000);
        User franck = new User (119, "Franck", "Mgumbo", "Clichy", 300);
        User lisa = new User (120, "Lisa", "Izotova", "Pologi", 100);

        Order order1 = new Order (1, 1000, Currency.getInstance("EUR"), "Lenovo ThinkPad", "Lenovo.com", guillaume);
        Order order2 = new Order (2,500,Currency.getInstance("EUR"),"Lenovo IdeaPad", "Tsum", elena);
        Order order3 = new Order (3, 1500, Currency.getInstance("USD"),"Gaming Monster", "Rozetka", charles );
        Order order4 = new Order (4,300, Currency.getInstance("UAH"),"Honey", "Izotov", xsenia);
        Order order5 = new Order (5, 30000, Currency.getInstance("EUR"), "Subaru wrx", "La Centrale", jf);
        Order order6 = new Order (6,2000, Currency.getInstance("USD"), "Trip to Japan", "Oskar",larissa);
        Order order7 = new Order (7, 50,Currency.getInstance("USD"),"Single Malt Whisky", "Airport CDG", vassia);
        Order order8 = new Order (8, 450, Currency.getInstance("UAH"), "Honey", "Izotov", natasha);
        Order order9 = new Order (9, 5000, Currency.getInstance("USD"), "Kamaz", "AvtoRinok", franck);
        Order order10 = new Order (10, 2000, Currency.getInstance("UAH"), "Lego Friends", "Lego Lviv", lisa);

        // putting all orders in a list

        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        orderList.add(order4);
        orderList.add(order5);
        orderList.add(order6);
        orderList.add(order7);
        orderList.add(order8);
        orderList.add(order9);
        orderList.add(order10);

        // checking the list before sorting

        System.out.println(orderList); // this outputs something not very user friendly
        for (Order order : orderList){
            System.out.println(order);
        }

        // sorting by price

        System.out.println("Price sorting, descending order:");
        Collections.sort(orderList, Order.OrderPriceComparator);
        for (Order order : orderList){
            System.out.println(order);
        }

        // sorting by town
        System.out.println("Town sorting, ascending order:");
        Collections.sort(orderList, Order.OrderCityComparator);
        for (Order order : orderList){
            System.out.println(order);
        }

        // sorting by town and price
        System.out.println("Price sorting, descending order, then city sorting, ascending order:");
        Collections.sort(orderList, Order.OrderPriceCityComparator);
        for (Order order : orderList){
            System.out.println(order);
        }

        // sorting by itemName, id and city
        // using a "global sorting method"
        // for some reason, I cannot make my universal sort tool to work. Could you please help?

        System.out.println("\nitemName sorting, then ID, then city sorting, ascending order:");
        System.out.println("PLEASE HELP, I WOULD LIKE TO CREATE A UNIVERSAL SORTING TOOL, but it does not work");
        System.out.println("Comparator<Order> comp1 = new orderList.ById(new orderList.ByItemName(new orderList.ByCity(null)));");

        // Comparator<Order> comp1 = new orderList.ById(new orderList.ByItemName(new orderList.ByCity(null)));

        /*
        удалите дублированные данные со списка
        удалите объекты, где цена меньше 1500
        разделите список на 2 списка - заказы в долларах и в гривнах
        разделите список на столько списков, сколько уникальных городов в User
         */

        List <Order> orderListDuplicate = new ArrayList<>();
        orderListDuplicate.addAll(orderList);
        orderListDuplicate.addAll(orderList);
        System.out.println("\nWe see that all items are duplicated: ");
        for (Order order : orderListDuplicate){
            System.out.println(order);
        }

        List<Order> noduplicates = orderListDuplicate.stream().distinct().collect(Collectors.toList());

        System.out.println("\nThis is the duplicatelist cleaned from duplicates");
        for (Order order : noduplicates){
            System.out.println(order);
        }

        // delete objects where price below 1500

        for (Iterator<Order> iter = noduplicates.listIterator(); iter.hasNext(); ) {
            Order a = iter.next();
            if (a.getPrice() < 1500) {
                iter.remove();
            }
        }

        System.out.println("\nWe have erased from the list items whose price is below 1500");
        for (Order order : noduplicates){
            System.out.println(order);
        }

        // create two lists: one for orders in USD and one for orders in UAH

        List<Order> ordersUAH = new ArrayList<>();
        for (Iterator<Order> iter = orderList.listIterator(); iter.hasNext(); ) {
            Order a = iter.next();
            if (a.getCurrency() == Currency.getInstance("UAH")) {
                ordersUAH.add(a);
            }
        }

        System.out.println("\nHere are orders denominated in UAH: ");
        for (Order order : ordersUAH){
            System.out.println(order);
        }

        List<Order> ordersUSD = new ArrayList<>();
        for (Iterator<Order> iter = orderList.listIterator(); iter.hasNext(); ) {
            Order a = iter.next();
            if (a.getCurrency() == Currency.getInstance("USD")) {
                ordersUSD.add(a);
            }
        }

        System.out.println("\nHere are orders denominated in USD: ");
        for (Order order : ordersUSD){
            System.out.println(order);
        }


        // разделите список на столько списков, сколько уникальных городов в User

        // first, get a list of towns in the order list

        List<String> cityList = new ArrayList<>();

        for (Order order : orderList){
            if (!cityList.contains(order.getUser().getCity())){
                cityList.add(order.getUser().getCity());
            }
        }

        // then, for each city,

       // Map<String, Map<String, List<Order>>> orderbyCity
       //         = orderList.stream().collect(Collectors.groupingBy(Order::getUser().getCity())


    }
}

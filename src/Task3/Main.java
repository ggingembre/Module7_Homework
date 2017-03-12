package Task3;

import Task1_2.Order;
import Task1_2.User;

import java.util.*;

/**
 * Created by Guillaume Gingembre on 12/03/2017.
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
    Order order9 = new Order (10, 2000, Currency.getInstance("UAH"), "Lego Friends", "Lego Lviv", lisa);
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

        TreeSet<Order> orderts = new TreeSet<Order>(orderList);

        // Displaying the Tree set data

        Iterator<Order> iterator = orderts.iterator();

       System.out.print("Tree set data: \n");
       while (iterator.hasNext()) {
           System.out.println(iterator.next() + " ");
       }

        System.out.println("\nWe see that order 9 was not included in the set, as it is redundant.\n");

       // check whether we find last name
        Iterator<Order> iterator2 = orderts.iterator();

        Order petrovOrder;
        boolean petrovOrderFound = false;
        System.out.println("Orders from user whose last name is Petrov:");
        while (iterator2.hasNext()) {
            petrovOrder = iterator2.next();
            if (petrovOrder.getUser().getLastName() == "Petrov") {
                System.out.println(petrovOrder);
                petrovOrderFound = true;
            }
        }
        if (!petrovOrderFound) System.out.println("No such order\n");

        // look for orders in my list, last name = izotova

        Order izotovaOrder;
        Iterator<Order> iterator3 = orderts.iterator();
        boolean izotovaOrderFound = false;
        System.out.println("Orders from user whose last name is Izotova:");
        while (iterator3.hasNext()) {
            izotovaOrder = iterator3.next();
            if (izotovaOrder.getUser().getLastName() == "Izotova") {
                System.out.println(izotovaOrder);
                izotovaOrderFound = true;
            }
        }
        if (!izotovaOrderFound) System.out.println("No such order\n");

        // this is heavy and not elegant, is there a way to write for instance:
        // orderts.contains(o.user(get).lastName() == "Petrov")? One line would look much better...

        //-выведите заказ с наибольшей ценой, исспользуя только один сет-метод - get
        //Collections.sort(orderList, Order.OrderPriceComparator);
        TreeSet<Order> highPriceSet = new TreeSet(Order.OrderPriceComparator);
        highPriceSet.addAll(orderts);
        System.out.println("\nThe order with highest price in the set is:\n"+highPriceSet.first());

        //удалите заказы, где валюта доллар, используя Iterator
        Iterator<Order> iterator4 = orderts.iterator();
        Order USDOrder;
        while (iterator4.hasNext()) {
            USDOrder = iterator4.next();
            if (USDOrder.getCurrency().getCurrencyCode() == "USD") {
                iterator4.remove();
            }
        }

        // printing results
        Iterator<Order> iterator5 = orderts.iterator();
        System.out.print("\nTree set data after deleting USD orders: \n");
        while (iterator5.hasNext()) {
            System.out.println(iterator5.next() + " ");
        }
    }
}
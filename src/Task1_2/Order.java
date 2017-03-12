package Task1_2;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by Guillaume Gingembre on 11/03/2017.
 */
public class Order implements Comparable<Order>{

    private long id;
    private int price;
    private Currency currency;
    private String itemName;
    private String shopIdentificator;
    private User user;

    // constructor with all fields

    public Order(long id, int price, Currency currency, String itemName, String shopIdentificator, User user) {
        this.id = id;
        this.price = price;
        this.currency = currency;
        this.itemName = itemName;
        this.shopIdentificator = shopIdentificator;
        this.user = user;
    }

    @Override
    public int compareTo(Order o) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        //in case it is the same object
        if (this == o) return EQUAL;

        //number comparisons
        if (this.id < o.id) return BEFORE;
        if (this.id > o.id) return AFTER;

        if (this.price < o.price) return BEFORE;
        if (this.price > o.price) return AFTER;

        //objects, including type-safe enums, follow this form
        //note that null objects will throw an exception here
        int comparison = this.itemName.compareTo(o.itemName);
        if (comparison != EQUAL) return comparison;

        comparison = this.shopIdentificator.compareTo(o.shopIdentificator);
        if (comparison != EQUAL) return comparison;

        comparison = this.user.getCity().compareTo(o.user.getCity());
        if (comparison != EQUAL) return comparison;

        comparison = this.user.getLastName().compareTo(o.user.getLastName());
        if (comparison != EQUAL) return comparison;

        comparison = this.user.getFirstName().compareTo(o.user.getFirstName());
        if (comparison != EQUAL) return comparison;

        if (this.user.getBalance() < o.user.getBalance()) return BEFORE;
        if (this.user.getBalance() > o.user.getBalance()) return AFTER;

        //all comparisons have yielded equality
        //verify that compareTo is consistent with equals (optional)
        assert this.equals(o) : "compareTo inconsistent with equals.";

        return EQUAL;
    }


    // Comparators

    // by price, descending order
    public static Comparator<Order> OrderPriceComparator = new Comparator<Order>() {

        @Override
        public int compare(Order o1, Order o2) {
            int o1Price = o1.getPrice();
            int o2Price = o2.getPrice();

            //ascending order
            //return o1Price-o2Price;

            //descending order
            return Integer.compare(o2Price, o1Price);// o2Price-o1Price;
        }};

    // by town name, ascending order

    public static Comparator<Order> OrderCityComparator = new Comparator<Order>() {

        public int compare(Order o1, Order o2) {
            String orderCity1 = o1.getUser().getCity().toUpperCase();
            String orderCity2 = o2.getUser().getCity().toUpperCase();

            //ascending order
            return orderCity1.compareTo(orderCity2);

            //descending order
            //return StudentName2.compareTo(StudentName1);
        }};


    // sort by price descending and then by town ascending:

    public static Comparator<Order> OrderPriceCityComparator = new Comparator<Order>() {
        public int compare(Order o1, Order o2)
        {
            // First by price - stop if this gives a result.
            Integer priceResult = Integer.compare(o2.getPrice(), o1.getPrice());
            if (priceResult != 0) return priceResult;

            // Next by city
            return o1.getUser().getCity().compareTo(o2.getUser().getCity());
        }};


    // universal sorting tool
    public abstract class AbstractComparator implements Comparator<Order> {
        private final AbstractComparator next;

        public AbstractComparator(AbstractComparator next) {
            this.next = next;
        }

        public int compare(Order order1, Order order2) {
            int result = doCompare(order1, order2);
            if (result != 0) {
                return result;
            } else {
                return next != null? next.compare(order1, order2) : 0;
            }
        }

        public abstract int doCompare(Order order1, Order order2);
    }

    public class ById extends AbstractComparator {
        public ById(AbstractComparator next) {
            super(next);
        }

        public int doCompare(Order order1, Order order2) {
            return (int) (order1.getId() - order2.getId());
        }
    }

    public class ByItemName extends AbstractComparator {
        public ByItemName(AbstractComparator next) {
            super(next);
        }

        public int doCompare(Order order1, Order order2) {
            return order1.getItemName().compareTo(order2.getItemName());
        }
    }

    public class ByCity extends AbstractComparator {
        public ByCity(AbstractComparator next) {
            super(next);
        }

        public int doCompare(Order order1, Order order2) {
            return order1.getUser().getCity().compareTo(order2.getUser().getCity());
        }
    }

    // Comparable



    // I could add one class per field, but this is out of the scope of this assignment. I have added only necessary fields per questions

    // universal sorting instrument

    //public static class OrderMultiComparator implements Comparator<Order> {
    //    protected List<Field> fields;
//
    //    public OrderMultiComparator(Field... orderedFields) {
    //        fields = new ArrayList<Field>();
    //        for (Field field : orderedFields) {
    //            fields.add(field);
    //        }
    //    }
//
    //    @Override
    //    public int compare(Order orderA, Order orderB) {
    //        Integer score = 0;
    //        Boolean continueComparison = true;
    //        Iterator itFields = fields.iterator();
//
    //        while (itFields.hasNext() && continueComparison) {
    //            Field field = (Field) itFields.next();
    //            Integer currentScore = 0;
    //            if (field.getName().equalsIgnoreCase("id")) {
    //                currentScore = Long.compare(orderA.getId(), orderB.getId());
    //            } else if (field.getName().equalsIgnoreCase("itemName")) {
    //                currentScore = orderA.getItemName().compareTo(orderB.getItemName());
    //            } else if (field.getName().equalsIgnoreCase("City")) {
    //                currentScore = orderA.getUser().getCity().compareTo(orderB.getUser().getCity());
    //            }
    //            if (currentScore != 0) {
    //                continueComparison = false;
    //            }
    //            score = currentScore;
    //        }
//
    //        return score;
    //    }
    //}

    // print method

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", currency=" + currency +
                ", itemName='" + itemName + '\'' +
                ", shopIdentificator='" + shopIdentificator + '\'' +
                ", user=" + user +
                '}';
    }

    // equals and hash method

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (price != order.price) return false;
        if (!currency.equals(order.currency)) return false;
        if (!itemName.equals(order.itemName)) return false;
        if (!shopIdentificator.equals(order.shopIdentificator)) return false;
        return user.equals(order.user);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + price;
        result = 31 * result + currency.hashCode();
        result = 31 * result + itemName.hashCode();
        result = 31 * result + shopIdentificator.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }


    // get and set methods

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getShopIdentificator() {
        return shopIdentificator;
    }

    public void setShopIdentificator(String shopIdentificator) {
        this.shopIdentificator = shopIdentificator;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

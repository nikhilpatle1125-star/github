import java.util.*;

abstract class LibraryItem {

    int itemId;
    String title;
    double price;
    boolean isBorrowed;

    LibraryItem(int itemId, String title, double price) {
        this.itemId = itemId;
        this.title = title;
        this.price = price;
        this.isBorrowed = false;
    }

    abstract String details();

    void borrow() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println(title + " borrowed successfully.");
        } else {
            System.out.println(title + " is already borrowed.");
        }
    }

    void returnItem() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println(title + " returned successfully.");
        } else {
            System.out.println(title + " was not borrowed.");
        }
    }

    String availability() {
        if (isBorrowed) {
            return "Borrowed";
        } else {
            return "Available";
        }
    }
}

class Book extends LibraryItem {

    Book(int itemId, String title, double price) {
        super(itemId, title, price);
    }

    String details() {
        return "Book ID: " + itemId +
                ", Title: " + title +
                ", Price: " + price +
                ", Status: " + availability();
    }
}

class Magazine extends LibraryItem {

    Magazine(int itemId, String title, double price) {
        super(itemId, title, price);
    }

    String details() {
        return "Magazine ID: " + itemId +
                ", Title: " + title +
                ", Price: " + price +
                ", Status: " + availability();
    }
}

public class Main {

    public static void main(String[] args) {

        ArrayList<LibraryItem> items = new ArrayList<LibraryItem>();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. Display Items");
            System.out.println("4. Borrow Item");
            System.out.println("5. Return Item");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Book ID: ");
                    int bId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String bTitle = sc.nextLine();

                    System.out.print("Enter Book Price: ");
                    double bPrice = sc.nextDouble();

                    items.add(new Book(bId, bTitle, bPrice));

                    System.out.println("Book Added.");
                    break;

                case 2:

                    System.out.print("Enter Magazine ID: ");
                    int mId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Magazine Title: ");
                    String mTitle = sc.nextLine();

                    System.out.print("Enter Magazine Price: ");
                    double mPrice = sc.nextDouble();

                    items.add(new Magazine(mId, mTitle, mPrice));

                    System.out.println("Magazine Added.");
                    break;

                case 3:

                    if (items.size() == 0) {
                        System.out.println("No items available.");
                    } else {

                        for (int i = 0; i < items.size(); i++) {
                            System.out.println(items.get(i).details());
                        }
                    }

                    break;

                case 4:

                    System.out.print("Enter Item ID to Borrow: ");
                    int borrowId = sc.nextInt();

                    boolean foundBorrow = false;

                    for (int i = 0; i < items.size(); i++) {

                        if (items.get(i).itemId == borrowId) {
                            items.get(i).borrow();
                            foundBorrow = true;
                        }
                    }

                    if (!foundBorrow) {
                        System.out.println("Item Not Found.");
                    }

                    break;

                case 5:

                    System.out.print("Enter Item ID to Return: ");
                    int returnId = sc.nextInt();

                    boolean foundReturn = false;

                    for (int i = 0; i < items.size(); i++) {

                        if (items.get(i).itemId == returnId) {
                            items.get(i).returnItem();
                            foundReturn = true;
                        }
                    }

                    if (!foundReturn) {
                        System.out.println("Item Not Found.");
                    }

                    break;

                case 0:

                    System.out.println("Program Ended.");
                    break;

                default:

                    System.out.println("Invalid Choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> myList = new ArrayList<>();

        ArrayList<String> MENU = new ArrayList<>();
        MENU.add("A - Add an item to the list");
        MENU.add("D – Delete an item from the list");
        MENU.add("P – Print (i.e. display) the list");
        MENU.add("Q – Quit the program");

        String MENU_HEADER = "---- List Maker Menu ----";
        String LIST_HEADER = "----- My To Do List -----";

        // Constantly loops until the user quits the program
        do {
            // Get menu choice from the user
            displayMenu(MENU, MENU_HEADER);
            String cmd = SafeInput.getRegExString(in,"Enter your menu choice","[AaDdPpQq]").toUpperCase();

            switch (cmd){
                // Add a list item
                case("A"):
                    // prompt user for list item
                    System.out.print("Enter the list item: ");
                    String listItem = in.nextLine();
                    // add list item to the list
                    myList.add(listItem);
                    // display list with added list item
                    displayArrayList(myList, LIST_HEADER);
                    break;
                // Delete a list item
                case("D"):
                    // cannot delete if there are no list items
                    if (!myList.isEmpty()){
                        // prompt user for list item index to delete
                        int delIndex = SafeInput.getRangedInt(in, "Enter the index of the list item to delete",1, myList.size()) - 1;
                        // remove list item
                        myList.remove(delIndex);
                        // display list without deleted list item
                        displayArrayList(myList, LIST_HEADER);
                    } else System.out.print("No items to delete\n\n");
                    break;
                // Print the list
                case("P"):
                    displayArrayList(myList, LIST_HEADER);
                    break;
                // Quit the program
                case("Q"):
                    // prompt user to confirm exit
                    boolean confirm = SafeInput.getYNConfirm(in,"Are you sure you want to exit?");
                    // if the user confirms the exit, exit
                    // else continue the application loop
                    if (confirm)
                        System.exit(0);
            }
        } while(true);
    }

    /**
     * prints out to console string menu items
     * @param MENU list of menu items, each menu item is one element in the ArrayList
     * @param MENU_HEADER the text header above the menu items
     */
    private static void displayMenu(ArrayList<String> MENU, String MENU_HEADER){
        System.out.println(MENU_HEADER);
        MENU.forEach(System.out::println);
        System.out.println();
    }

    /**
     * prints out to console a numbered list of ArrayList elements with a header
     * @param arrayList ArrayList of elements to be logged to the console
     * @param LIST_HEADER The text header above the numbered list of elements
     */
    private static void displayArrayList(ArrayList<String> arrayList, String LIST_HEADER){
        System.out.println();
        System.out.println(LIST_HEADER);
        for (int i = 0; i < arrayList.size(); i++){
            System.out.printf(" %2d. %s\n", i + 1, arrayList.get(i));
        }
        System.out.println();
    }
}
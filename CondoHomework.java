import java.util.Scanner;

public class CondoHomework{
    public static void main(String[] args) {
        System.out.println("--------------------- Setting Up the Condo ---------------------");
        int floor;
        int room = 0;
        int option;
        String[][] array;
        int desired_floor;
        int desired_room;
        String owner = null;
        int sell_floor;
        int sell_room;
        int search_room;
        int search_floor;

        Scanner src = new Scanner(System.in);

        do {
            System.out.print("Enter the number of the Floor: ");
            floor = src.nextInt();
            if (floor <= 0){
                System.out.println("The program allowed only number which greater than ZERO");
            }else{
                do {
                    System.out.print("Enter the number of the Room: ");
                    room = src.nextInt();
                    if (room < 0) {
                        System.out.println("The program allowed only number which greater than ZERO");
                    }

                }while (room < 0);
            }
        }while(floor <= 0);

        array = new String[floor][room];
        src.nextLine();
        System.out.println("You have successfully set up the condo!");
        System.out.println("==> Number of Floor: " + floor + " Floors");
        System.out.println("==> Number of Room: " + room + " Rooms");
        System.out.println("==> Total Condo: " + (floor * room) + " Condo");
        src.nextLine();
        do {
            System.out.println("==================== Welcome to PP Condo ====================");
            System.out.println("1. Buy Condo");
            System.out.println("2. Sell condo");
            System.out.println("3. Search information");
            System.out.println("4. Display information");
            System.out.println("5. Exit");

            System.out.println("-------------------------------------");
            System.out.print("-> Choose option from (1-5): ");
            option = src.nextInt();
            switch (option) {
                case 1-> {
                    System.out.println("-------------------- Buying Condo -----------------------");
                    System.out.print("Enter your desired floor (1 - " + floor + "):  ");
                    desired_floor = src.nextInt();
                    if (desired_floor < 0 || desired_floor > 4){
                        System.out.println("You should input must be (1 - " + floor + ")");

                    }else {
                        System.out.print("Enter your desired Room (1 - " + room + "): ");
                        desired_room = src.nextInt();
                        if (array[desired_floor - 1][desired_room - 1] == null) {
                            if (desired_room < 0 || desired_room > 4) {
                                System.out.println("You should input must be 1 - " + room + ")");

                            } else {
                                System.out.print("=> Enter name: ");
                                owner = src.next();
                                array[desired_floor - 1][desired_room - 1] = owner; // index start form 0
                                System.out.println(owner + " has bought the condo at floor " + desired_floor + " room " + desired_room);
                                src.nextLine();
                                System.out.println("Press Enter to continues!");
                                src.nextLine();
                            }
                        }else{
                            System.out.println("This place is not available, it has already had the owner!");
                            System.out.println("Try again letter!");
                        }
                    }
                }
                case 2 -> {
                    // Sell condo:
                    System.out.println("Enter floor: "); sell_floor = src.nextInt();
                    System.out.println("Enter room: "); sell_room = src.nextInt();

                    if (array[sell_floor - 1][sell_room - 1] != null){
                        System.out.print("Floor: " + sell_floor + " Room: " + sell_room);
                        System.out.println(" Belong to " + array[sell_floor-1][sell_room-1]);
                        System.out.println("Confirm 1 or cancel 0: "); int check = src.nextInt();
                        switch (check){
                            case 1->{
                                array[sell_floor-1][sell_room-1] = null;
                            }
                            case 0->{
                                System.out.println("Cancelled!");
                                src.nextLine();
                                System.out.println("Press Enter to continues!");
                                src.nextLine();
                                array[sell_floor-1][sell_room-1] = array[sell_floor-1][sell_room-1];
                            }
                        }
                    }
                }
                case 3 -> {
                    // search information:
                    // tonight.

                    System.out.println("Enter floor: "); search_floor = src.nextInt();
                    System.out.println("Enter room: "); search_room = src.nextInt();

                    if (array[search_floor-1][search_room-1] != null){
                        System.out.println("Floor: " + search_floor + " Room: " + search_room + "Named: " + array[search_floor-1][search_room-1]);
                    }else{
                        System.out.println("This place don't have the owner!");
                    }
                }
                case 4 -> {
                    System.out.println("-------------------------- Display Condo Information --------------------------");
                    for (int i=0; i<floor; i++) {
                        System.out.print("Floor [" + (i+1) + "] => \t");
                        for (int j=0; j<room; j++) {
                            System.out.print((array[i][j]) + "\t");
                        }
                        System.out.println("\n");
                    }
                }

                case 5 -> {
                    System.out.println("------------------------- Thanks --------------------------");
                    return;
                }
            }
        }while(option < 5 && option > 0);
    }
}

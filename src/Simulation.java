import java.util.Scanner;

public class Simulation {
    public static void  main(String[] args) {

        Scanner input = new Scanner(System.in);

        //** gives user a summarized idea of the simulation
        System.out.println("\nThis is a Human-Dog simulation. Pick a number of people to use in the simulation.");
        System.out.println("Give them each a name. Then choose how many dogs each person has, and name the dogs.\n");
        System.out.print("How many people would you like for your simulation?: ");

        int numHumans = 0;

        //** user validation to check input for correct data type
        //** no limits imposed on user
        while (input.hasNext()) {
            if (!input.hasNextInt()) {
                System.out.print("Hey now. That wasn't a number, try again: ");
                input.next();
            }
            else {
                numHumans = input.nextInt();
                break;  //**break here to end loop after accepting correct input
            }
        }

        Human[] humName = new Human[numHumans]; //**references human constructor

        //** sets up array of humans
        for (int i = 0; i < numHumans; i++) {
            humName[i] = new Human();
        }

        int choice = 0; //** person chosen
        int choice2 = 0;  //** used to end simulation

        do {
            //** prints menu for selecting which person
            System.out.println("\nWhich person would you like to use: ");
            for (int i = 0; i < humName.length; i++) {
                System.out.println((i + 1) + ". " + humName[i].name);
            }

            //** user validation to check for correct data type of input
            while (input.hasNext()) {
                if (!input.hasNextInt()) {
                    System.out.print("Nope. Not a number, try again: ");
                    input.next();
                } else {
                    choice = input.nextInt();
                    break;  //break here to end loop after accepting correct input
                }
            }

            System.out.println(" ");
            //** prints initial values of human chosen for simulation
            System.out.println(humName[choice - 1].toString());

            int answer = 0; //** user choice to pick another activity with same human

            do {
                System.out.println("What shall " + humName[choice - 1].name + " do?:");

                System.out.println("1. Go to work.");
                System.out.println("2. Walk the dogo(s).");
                System.out.println("3. Feed the grub monger(s).");
                System.out.println("4. Bathe the filthy animal(s).");
                System.out.println("5. Buy more grub for the pup(s). ");
                System.out.println("6. Do nothing. ");

                int activity = 0;

                //** user validation to check for correct data type of input
                while (input.hasNext()) {
                    if (!input.hasNextInt()) {
                        System.out.print("Ooop! Try again: ");
                        input.next();
                    } else {
                        activity = input.nextInt();
                        break;  //break here to end loop after accepting correct input
                    }
                }

                //**switch statement to perform activity chosen
                switch (activity) {

                    case 1:
                        humName[choice - 1].work();
                        System.out.println(humName[choice - 1].toString());
                        break;
                    case 2:
                        humName[choice - 1].walkDog();
                        System.out.println(humName[choice - 1].toString());
                        break;
                    case 3:
                        humName[choice - 1].feedDog();
                        System.out.println(humName[choice - 1].toString());
                        break;
                    case 4:
                        humName[choice - 1].batheDog();
                        System.out.println(humName[choice - 1].toString());
                        break;
                    case 5:
                        humName[choice - 1].buyDogFood();
                        System.out.println(humName[choice - 1].toString());
                    case 6:
                        humName[choice - 1].passTheTime();
                        System.out.println(humName[choice - 1].toString());
                        break;
                }

                System.out.println("Go again? 1. yes 2. no");

                while (input.hasNext()) {
                    if (!input.hasNextInt()) {
                        System.out.print("It only works if you enter a 1 or a 2: ");
                        input.next();
                    } else {
                        answer = input.nextInt();
                        break;  //break here to end loop after accepting correct input
                    }
                }

            } while (answer == 1);  //**comes out of inner (activity) do-while loop to switch people

            System.out.print("Switch person? 1. Yes  2. Quit playing");

            while (input.hasNext()) {
                if (!input.hasNextInt()) {
                    System.out.print("Yikes. Try a 1 or a 2: ");
                    input.next();
                }
                else {
                    choice2 = input.nextInt();
                    break;  //break here to end loop after accepting correct input
                }
            }

            if (choice2 == 2) {
                System.out.println("Thanks for playing!");
                System.out.println("We'll keep an eye on them while you are away.");
                System.exit(0);
            }
        } while (choice2 == 1);
    }
}
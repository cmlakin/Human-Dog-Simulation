import java.util.*;

public class Human {

    Scanner input = new Scanner(System.in);

    Dog[] dogName; //** allows access to dog constructor (??)

    private int numDogs,
                dogFood,
                count = 0;  //** initialized her instead of later
    private double money,
                   counter = 0; //** initialized her instead of later

    public String name;

    //**constructor for individual humans created
    public Human() {

        //** each human will start with these initial values
        money = 500.00;
        dogFood = 60;

        System.out.print("Enter person's name: ");
        name = input.nextLine();

        System.out.print("How many dogs does " + name + " have?: ");

        //** user validation to check for correct data type
        //** no limits imposed on user
        while (input.hasNext()) {
            if (input.hasNextInt()) {
                numDogs = input.nextInt();
                break;  //**break here to end loop after accepting correct input
            }
            else {
                System.out.print("Pay attention! How many dogs?: ");
                input.next();
            }
        }

        dogName = new Dog[numDogs]; //**references the dog constructor

        //**loop sets names for each dog created in array per human in simulation
        for (int i = 0; i < numDogs; i++) {
            dogName[i] = new Dog();
        }
    }

    //** gives updated information everytime called, and calls toString for every dog belonging to human
    public String toString() {

        String tempHuman = "CURRENT DETAILS: \nName: " + name + ": \t\tMoney: $" + getMoney() + ", Number of dogs: " +
                            numDogs + ", Amount of dog food: " + getDogFood() + " pounds.\n";


        for (int i = 0; i < numDogs; i++) {
            tempHuman += dogName[i].toString();
        }

        return tempHuman;
    }

    public double getMoney() {
        return money;
    }

    public int getDogFood() {
        return dogFood;
    }

    public void walkDog() {

        System.out.println("\nTaking a stroll with the dogo(s)...\n");

        //** applies changes to every dog belonging to this human per activity chosen
        for (int i = 0; i < numDogs; i++) {
            dogName[i].setFun(dogName[i].getFun() + 20);
            dogName[i].setHunger(dogName[i].getHunger() + 20);
            dogName[i].setCleanliness(dogName[i].getCleanliness() - 20);
        }
    }

    public void batheDog() {

        System.out.println("\nWashing the filthy animal(s)...\n");

        //** applies changes to every dog belonging to this human per activity chosen
        for (int i = 0; i < numDogs; i++) {
            dogName[i].setCleanliness(dogName[i].getCleanliness() + 40);
            dogName[i].setHunger(dogName[i].getHunger() + 5);

            //** not all dogs like water. This will allow bathing dogs to
            //** increase fun on some and decrease fun on others
            if(i % 2 == 0){
                dogName[i].setFun(dogName[i].getFun() + 10);
            }
            else{
                dogName[i].setFun(dogName[i].getFun() - 10);
            }
        }
    }

    public void work() {

        System.out.println("\nMaking some money...\n");
        money += 30;

        //** applies changes to every dog belonging to this human per activity chosen
        for (int i = 0; i < numDogs; i++) {
            dogName[i].setFun(dogName[i].getFun() - 20);
            dogName[i].setHunger(dogName[i].getHunger() + 10);
            dogName[i].setCleanliness(dogName[i].getCleanliness() - 10);
        }
    }

    public void feedDog() {

        System.out.println("\nFeeding the grub monger(s)...\n");

        //** applies changes to every dog belonging to this human per activity chosen
        for (int i = 0; i < numDogs; i++) {
            dogName[i].setHunger(dogName[i].getHunger() - 40);
            dogName[i].setCleanliness(dogName[i].getCleanliness() - 10);
            count++;

            //** accounts for a change of 5 to be deducted from amount of dog food
            //** per dog. the more dogs the more food you will go through
            if (count > 0){
                dogFood -= count * 5;
            }
        }
    }

    //** method for when user chooses to do nothing for their activity
    public void passTheTime() {

        System.out.println("\nDoing nothing, absolutely nothing. Maybe catching up on some shows ...\n");

        //** applies changes to every dog belonging to this human per activity chosen
        for (int i = 0; i < numDogs; i++) {
            dogName[i].setFun(dogName[i].getFun() - 10);
            dogName[i].setHunger(dogName[i].getHunger() + 5);
            dogName[i].setCleanliness(dogName[i].getCleanliness() - 10);
        }
    }

    public void buyDogFood(){

        System.out.println("\nGetting some puppy chow...\n");

        //** accounts for user buying enough dog food based on amount of dogs owned
        //** counter keeps track of how many dogs per this human
        for (int i = 0; i < numDogs; i++){
            counter++;
        }
        money -= 30 * counter;
        dogFood += 20 * counter;
    }
}

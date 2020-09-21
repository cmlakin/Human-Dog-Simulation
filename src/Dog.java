
import java.util.*;

public class Dog {
    Scanner input = new Scanner(System.in);

    private int loyalty;

    private int hunger,
               fun,
               cleanliness;
    public String dName;


    //**constructor for individual dogs created and randomly sets attributes initial values.
    public Dog(){

        System.out.print("Enter dog's name: ");
        dName = input.nextLine();

        loyalty = (int)(1 + Math.random() * 100);
        hunger = (int)(1 + Math.random() * 100);
        fun = (int)(1 + Math.random() * 100);
        cleanliness = (int)(1 + Math.random() * 100);
        setLoyalty();
    }

    //** gives updated information every time this is called.
    public String toString(){

        String tempDog = "Dog name: " + dName + ": \tLoyalty: " + getLoyalty() + ", Hunger: " + getHunger() + ", Fun: "
                         + getFun() + ", Cleanliness: " + getCleanliness() + "\n";

        return tempDog;
    }

    public int getLoyalty(){
        setLoyalty();
        return loyalty;
    }

    //** note to self: set to private so only dog can change loyalty.
    private void setLoyalty(){

        this.loyalty = Math.max(getFun(), (100 - getHunger()));
    }

    public int getCleanliness(){

        return cleanliness;
    }

    //**Statements added to give warnings. To guide user on next actions.
    public void setCleanliness(int cleanliness){
        if ( cleanliness > 100 ){
            System.out.println("* " + dName + " is TOO clean! Skip bathing for a while! *");
        }
        if ( cleanliness < -10 ){
            System.out.println("** The neighbor has notified the authorities due to concerns");
            System.out.println("about " + dName + "'s health. Please take action now. **\n");
            this.cleanliness = cleanliness;
        }
        if (cleanliness < 0){
            System.out.println("***WARNING!! " + dName + "  HAS SORES AND IS LOSING HAIR. BATHE IMMEDIATELY!!***\n");
            this.cleanliness = cleanliness;
        }
        else if ( cleanliness < 20 ){
            System.out.println("***Heads up! " + dName + " is pretty stinky!! Might be time for a bath!!***\n");
            this.cleanliness = cleanliness;
        }
        else
            this.cleanliness = cleanliness;

    }

    public int getHunger(){

        return hunger;
    }

    //**Statements added to give warnings. To guide user on next actions.
    public void setHunger(int hunger){
        if ( hunger < 0 ){
            System.out.println("* " + dName + " is eating too much. Cut back a bit! *");
            this.hunger = hunger;
        }
        if ( hunger > 150 ){
            System.out.println("** The neighbor has notified the authorities due to concerns");
            System.out.println("about " + dName + "'s health. Please take action now. **");
            this.hunger = hunger;
        }
        if ( hunger >= 100){
            System.out.println("**** WARNING!!! WARNING!!! WARNING!!! WARNING!!! ****");
            System.out.println("** " + dName + " IS WITHERING AWAY. FEED IMMEDIATELY!! **");
            this.hunger = hunger;
        }
        else if ( hunger > 90 ){
            System.out.println("*** Heads up! " + dName + " is STARVING! FEED SOON!!! ***");
            this.hunger = hunger;
        }
        else
            this.hunger = hunger;

    }

    public int getFun(){

        return fun;
    }

    //**Statements added to give warnings. To guide user on next actions.
    public void setFun(int fun){
        if (fun < 10){
            System.out.println("** " + dName + " is chewing everything in site! Go for a walk!!");
            System.out.println("Buy some new dog toys! **");
            this.fun = fun;
        }
        else if (fun < 30){
            System.out.println("*** " + dName + " is bored. Take them for a walk before they start chewing on stuff!!");
            this.fun = fun;
        }
        else
            this.fun = fun;
    }


}
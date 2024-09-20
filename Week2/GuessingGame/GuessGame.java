import java.util.Scanner;
//import java.Math;

public class GuessGame{
    boolean p1isRight;
    boolean p2isRight;
    boolean p3isRight;

    public void startGame(){
        String p1n;
        String p2n;
        String p3n;
        int g1;
        int g2;
        int g3;
        boolean winner = false;

        Scanner ip = new Scanner(System.in); 
        System.out.println("Enter player one's name:");
        p1n = ip.nextLine();
        Player p1 = new Player();
        p1.name(p1n);

        System.out.println("Enter player two's name:");
        p2n = ip.nextLine();
        Player p2 = new Player();
        p2.name(p2n);

        System.out.println("Enter player threes's name:");
        p3n = ip.nextLine();
        Player p3 = new Player();
        p3.name(p3n);

        ip.close();

        System.out.println("Our players are "+ p1n + ", " + p2n + " and " + p3n);

        int num = (int)(9*Math.random());

        System.out.println("I am thinking of a number between 0 and 9...");

        while(winner == false){
            p1.guess();
            g1 = p1.num;
            System.out.println(p1n + " guessed:" + Integer.toString(g1));
            p2.guess();
            g2 = p2.num;
            System.out.println(p2n + " guessed:" + Integer.toString(g2));
            p3.guess();
            g3 = p3.num;
            System.out.println(p3n + " guessed:" + Integer.toString(g3));
            
            if(g1 == num){p1isRight = true;}
            if(g2 == num){p2isRight = true;}
            if(g3 == num){p3isRight = true;}
            if(p1isRight||p2isRight||p3isRight)
            {
                System.out.println("We have a winner!"); 
                System.out.println(p1n + ": " + Boolean.toString(p1isRight) + ", "  + p2n + ": " + Boolean.toString(p2isRight) + ", " + p3n + ": " + Boolean.toString(p3isRight));
                System.out.println("Game is over now :(");
                winner = true;
            }
            else
            {
                System.out.println("Let's try again.");
            }
        }
    }
}
import java.util.*;
public class Match {
    
    public static void main(String[] args) {
        playGame();
        
}
    public static void playGame(){
        Scanner inp = new Scanner(System.in);
        System.out.println("Welcome to the Cricket Game!");
        System.out.print("What is your call (heads or tails): ");
        String call = inp.nextLine();
        
        if (call.equalsIgnoreCase("head")) {
            call = "heads";
        } 
        else if (call.equalsIgnoreCase("tail")) {
            call = "tails";
        }
        
        Toss toss = new Toss();
        String resultMessage = toss.call(call);
        
        System.out.println(resultMessage);
        Match.decision(toss,inp,call);
        
       
     
    }
    
    public static void decision(Toss toss, Scanner inp, String call){
         if(toss.result.equalsIgnoreCase(call)){
            System.out.print("Bat or Bowl:: ");
            String desicion = inp.nextLine();
            if(desicion.equalsIgnoreCase("bat")){
                Bating bat = new Bating();
                bat.batingFirst();
            }
            else if(desicion.equalsIgnoreCase("bowl")){
                Bowling bowl = new Bowling();
                bowl.bowlingFirst();
            }
            else{
                System.out.println("Invalid decision. Choose again.");
                decision(toss,inp,call);
            }
        }
        else{
            if(toss.decision.equalsIgnoreCase("bat")){
                Bowling bowl = new Bowling();
                bowl.bowlingFirst();
            }
            else{
                Bating bat = new Bating();
                bat.batingFirst();
            }
            
        }
        
    }
    
}
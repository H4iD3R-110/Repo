
import java.util.*;

public class Bating {
    static int totalRuns = 0;
    static int Wickets = 0;
    Scanner inp = new Scanner(System.in);
    
    
    public  void batingFirst(){
        System.out.println(" -- Starting 5-Over Match --");
        System.out.println("\tRules: \n-Press 'G' for grounded shot. "
                            + "\n-Press 'L' for  Lofted shots. (More risk of getting Out)"
                            + "\n-You have 10 wickets and"
                            + "\n-5 Overs alotted");
        
        System.out.print("\nPress 'Enter' to start --> ");     
        String start = inp.nextLine();
        
        
        for(int i = 1;i<=5;i++){
            int thisOverWickets = Wickets;
            int thisOverRuns = totalRuns;

            int target = 100000;
            Overs(inp,target, i);
            
            thisOverWickets = Wickets - thisOverWickets;
            thisOverRuns = totalRuns - thisOverRuns;

            
            if(Wickets < 10){
                System.out.println("\nEnd of Over:"+i+"   This Over: " + thisOverRuns + " runs - " + thisOverWickets + " Wicket(s)");
            }
            
            System.out.println("    -------------------------");
            System.out.println("\t"+totalRuns+"-"+Wickets+" >>> "+i+" Over(s)");
            System.out.println("    -------------------------");
            
            if(i < 5 && Wickets < 10){
                System.out.println(" Over: "+(i+1));
            }
            else if(i == 5 || Wickets == 10){
                
                System.out.println("\t\tTarget: "+ (totalRuns+1));
                break;
            }
                      
        }
        Bowling bowling = new Bowling();
        bowling.bowlingSecond(totalRuns+1);
        
        
        
    }
    public void batingSecond(int Target){
        
        System.out.println("\n\tRules: \n-Press 'G' for grounded shot. "
                            + "\n-Press 'L' for  Lofted shots. (More risk of getting Out)"
                            + "\n-You have 10 wickets and"
                            + "\n-5 Overs alotted");
        System.out.print("\nPress 'Enter' to start Secong Innings--> "); 
        String start = inp.nextLine();
        
        System.out.println("\nOver: 1");
        
        for(int i = 1;i<=5;i++){
            int thisOverWickets = Wickets;
            int thisOverRuns = totalRuns;
            
            
            Overs(inp,Target, i);
            
            thisOverWickets = Wickets - thisOverWickets;
            thisOverRuns = totalRuns - thisOverRuns;

            
            if(totalRuns >= Target){
                System.out.println("\nThis Over: " + thisOverRuns + " runs - " + thisOverWickets + " Wicket(s)");
                System.out.println("\n    -------------------------");
                System.out.println("\t    "+totalRuns+"-"+Wickets);
                System.out.println("    -------------------------");
                System.out.println("\nMatch Over");
                System.out.println("Chased Successfully");
                System.out.println("CONGRATULATIONS! YOU WON THE MATCH");
                break;
            }else if(totalRuns == (Target - 1) && i == 5){
                System.out.println("\nEnd of Over:"+i+"   This Over: " + thisOverRuns + " runs - " + thisOverWickets + " Wicket(s)");
                System.out.println("    -------------------------");
                System.out.println("\t"+totalRuns+"-"+Wickets+" >>> "+i+" Over(s)");
                System.out.println("    -------------------------");
                System.out.println("\nMatch Over");
                System.out.println("Match Draw");
                break;
            }
  
            if(Wickets < 10){
                System.out.println("\nEnd of Over:"+i+"   This Over: " + thisOverRuns + " runs - " + thisOverWickets + " Wicket(s)");
            }
            int required = Target - totalRuns;
            int remainingBalls;
            if(i == 4 ){
                remainingBalls = 6;
            }
            else if(i == 5 ){
                remainingBalls = 0;
            }
            else{
                remainingBalls = (6*(5-i));
            }
                
            if (required > 0 && remainingBalls > 0 && Wickets < 10){
                
                System.out.println("    Required: "+ required + " off " +  remainingBalls +" balls");
            }
            
            System.out.println("    -------------------------");
            System.out.println("\t"+totalRuns+"-"+Wickets+" >>> "+i+" Over(s)");
            System.out.println("    -------------------------");
            
            if(i < 5 && Wickets < 10){
                System.out.println(" Over: "+(i+1));
            }
            else if(i == 5 || Wickets == 10){
                System.out.println("\nMatch Over");
                if(totalRuns < Target){
                    System.out.println("YOU LOSE THE MATCH");
                }   
                break;
            }
                      
        }
        System.out.print("\nWant to Play again?? (y/n):: ");
        String opt = inp.nextLine();
        
        if (opt.equalsIgnoreCase("y")){
            Wickets = 0;
            totalRuns = 0;
            new Match().playGame();
        }
        
    }
    
        
 
    
    
    public void Overs(Scanner inp, int target, int over){
        String[] GShots = {"bowled","dot","one","two","three","four","wide","lbw","noball","dot","one","two","three","four"};
        String[] LShots = {"four","caugth","six","lbw","wide","noball","four","caugth","six","four","bowled","six"};
        
        
        int ball = 0;
        while(ball < 6){
            System.out.print("\n(G/L):- ");
            String shot = inp.nextLine();
            
            if(shot.equalsIgnoreCase("g")){
                int gshot = (int)(Math.random() * 14);
                String shotScore = GShots[gshot];
                switch(shotScore){
                    case "dot":
                        System.out.println("No Run!   (0)");
                        totalRuns = totalRuns + 0;
                        ball++;
                        break;
                    case "one":
                        System.out.println("Just a Single   (1)");
                        totalRuns = totalRuns + 1;
                        ball++;
                        break;
                    case "two":
                        System.out.println("Got Two Runs    (2)");
                        totalRuns = totalRuns + 2;
                        ball++;
                        break;
                    case "three":
                        System.out.println("Quick running   (3)");
                        totalRuns = totalRuns + 3;
                        ball++;
                        break;
                    case "four":
                        System.out.println("Beautiful shot! four of it   (4)");
                        totalRuns = totalRuns + 4;
                        ball++;
                        break; 
                    case "bowled":
                        System.out.println("Beautifuly bowled rigth into stumps   (OUT)");
                        totalRuns = totalRuns + 0;
                        ball++;
                        Wickets++;
                        break;
                    case "lbw":
                        System.out.println("I think he`s gone.. yes! given   (OUT lbw)");
                        totalRuns = totalRuns + 0;
                        ball++;
                        Wickets++;
                        break;
                    case "caugth":
                        System.out.println("Edged, taken! easy catch for fielder    (OUT)");
                        totalRuns = totalRuns + 0;
                        ball++;
                        Wickets++;
                        break;
                    case "wide":
                        System.out.println("too wide    (extra)");
                        totalRuns = totalRuns + 1;                       
                        break;
                    case "noball":
                        System.out.println("No! it`s over the line need to re-bowl   (extra)");
                        totalRuns = totalRuns + 1;
                        break;
                    default:
                        break;
                        
                }
                System.out.println("Over: "+(over-1)+"."+ball);
                
            }
            else if (shot.equalsIgnoreCase("l")){
                int lshot = (int)(Math.random() * 12);
                String shotScore = LShots[lshot];
                switch(shotScore){
                    case "four":
                        System.out.println("Beautiful shot! four of it   (4)");
                        totalRuns = totalRuns + 4;
                        ball++;
                        break; 
                    case "six":
                        System.out.println("Powerfull hit! into the stands   (6)");
                        totalRuns = totalRuns + 6;
                        ball++;
                        break;
                    case "bowled":
                        System.out.println("Beautifuly bowled rigth into stumps   (OUT)");
                        totalRuns = totalRuns + 0;
                        ball++;
                        Wickets++;
                        break;
                    case "lbw":
                        System.out.println("I think he`s gone.. yes! given  (Out lbw)");
                        totalRuns = totalRuns + 0;
                        ball++;
                        Wickets++;
                        break;
                    case "caugth":
                        System.out.println("up in the Aiiir, taken! easy catch for fielder   (OUT)");
                        totalRuns = totalRuns + 0;
                        ball++;
                        Wickets++;
                        break;
                    case "wide":
                        System.out.println("too wide    (extra)");
                        totalRuns = totalRuns + 1;                       
                        break;
                    case "noball":
                        System.out.println("No! it`s over the line need to re-bowl   (extra)");
                        totalRuns = totalRuns + 0;
                        break;
                    default:
                        break;
                        
                }
                System.out.println("Over: "+(over-1)+"."+ball);
                
            }
            
            else{
                System.out.println("Wrong selection! TryAgain");
            }
            
            if(totalRuns >= target){
                break;
                
            }
     
            if(Wickets == 10){
                
                System.out.println("\n\tAll Out");
                
                break;   
            }           
    
        }
        
    }
        
    
    public static void main(String[] args) {
        
    }
}

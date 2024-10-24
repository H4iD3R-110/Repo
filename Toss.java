public class Toss{
    
    String result;
    String decision;
    
    public String call (String call){
              
        int toss = (int)(Math.random()*2);
        
        if (toss == 1) {
            result = "Heads";        
        }
        else{
            result = "Tails";
        }
        
        if(result.equalsIgnoreCase(call)){
            return result +" it is! What have you decided";
        }
        else{
            int num = (int)(Math.random()*2);
            if (num == 1){
                decision = "bat";
                return "it`s "+ result + "! Opposition has decided to "+ decision + " first";
            }
            else{
                decision = "bowl";
                return "it`s "+ result + "! Opposition has decided to "+ decision + " first";
            }
            
        }
    }
}
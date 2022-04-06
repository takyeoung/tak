import java.util.*;
class DiceGame{
    
    int diceFace;
    int userGuess;
    int life = 30;
    int x;
    int o;

    private void RollDice()
    {
        diceFace = (int)(Math.random()*6)+1;
        System.out.println("결과:"+diceFace);  
        System.out.println("맞은개수:"+o); 
        System.out.println("틀린개수:"+x);    
    }
    
    private int getUserInput(String prompt)
    {
        
        System.out.println(prompt);
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    private void checkUserGuess()
    {
        
          if(diceFace == userGuess){
           System.out.println("맞았습니다"); 
           life += diceFace;
           o++;
           System.out.println(life);
    }
          else
           System.out.println("틀렸습니다");   
           life -= diceFace;
           x++;
           System.out.println(life);
  }
    public void startPlaying()
    { 
        for(;;)
        {
            if(life<=0)
            break;
        userGuess = getUserInput("예상값을 입력하시오");
        RollDice();
        checkUserGuess();
        }
    }

}


public class DiceGameTest {
    public static void main(String[] args) {
        DiceGame game = new DiceGame();
        game.startPlaying();
    
    }
}

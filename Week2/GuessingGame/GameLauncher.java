
public class GameLauncher {
    //track if game is over
    boolean p1won;
    boolean p2won;
    boolean p3won;

    //So we can instantiate an object of type game launcher
    public GameLauncher(){}
    
    public void launch(){
        p1won = false;
        p2won = false;
        p3won = false;
        GuessGame game = new GuessGame();
        game.startGame();
        //clever way too avoid issues with public variables and stuff
        p1won = game.p1isRight;
		p2won = game.p2isRight;
		p3won = game.p3isRight;

    }
    public static void main(String[] args){
        GameLauncher launcher = new GameLauncher();
        launcher.launch();
    }
}
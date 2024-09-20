public class Player{
    public String name;
    public int num;

    void name(String n){
        name = n;
    }
    void guess(){
        num = (int)(9*Math.random());
    }
}
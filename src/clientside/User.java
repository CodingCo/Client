package clientside;

/**
 *
 * @author Christopher
 */
public class User {
    private String userName;
    
    public User(String userName){
        this.userName = userName;
    }
    
    @Override
    public String toString(){
        return userName;
    }
}

package main.java.com.responses;

/**
 * Created by Jocelyn on 13/01/2016.
 */
public class UserConnexionResponse {

    private int isConnect;
    private String token;

    public UserConnexionResponse(){

    }

    public int isConnect() {
        return isConnect;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setIsConnect(int isConnect) {
        this.isConnect = isConnect;
    }
}

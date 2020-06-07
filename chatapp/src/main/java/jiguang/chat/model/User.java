package jiguang.chat.model;


public class User {
    public String appkey;
    public String username;
    public String platform;

    public User(String appkey, String username, String platform) {
        this.appkey = appkey;
        this.username = username;
        this.platform = platform;
    }
}

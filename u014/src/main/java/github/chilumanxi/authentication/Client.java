package github.chilumanxi.authentication;

/**
 * client class
 *
 * @author zhanghaoran25
 * @date 2021/6/23 20:40
 */
public class Client {
    public static void main(String[] args){
        String req = "test";
        DefaultApiAuthenticatorImpl defaultApiAuthenticator = new DefaultApiAuthenticatorImpl();
        if(defaultApiAuthenticator.auth(req)){
            System.out.println("auth pass");
        }
    }
}

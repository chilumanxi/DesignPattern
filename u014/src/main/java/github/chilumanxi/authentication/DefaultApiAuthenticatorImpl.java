package github.chilumanxi.authentication;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * DefaultApiAuthenticatorImpl class
 *
 * @author zhanghaoran25
 * @date 2021/6/23 17:15
 */
public class DefaultApiAuthenticatorImpl {
    
    /**
     * credentialStorage
     */
    private CredentialStorage credentialStorage;

    /**
     * 构造函数
     */
    public DefaultApiAuthenticatorImpl(){
        this.credentialStorage = new CredentialStorage();
    }

    /**
     * 构造函数
     */
    public DefaultApiAuthenticatorImpl(CredentialStorage credentialStorage){
        this.credentialStorage = credentialStorage;
    }


    /**
     * auth验证
     *
     * @param url
     * @return java.lang.Boolean
     */
    public Boolean auth(String url){
        ApiRequest apiRequest = ApiRequest.genFakeReq(url);
        String appId = apiRequest.getAppId();
        String token = apiRequest.getToken();
        Long timeStamp = apiRequest.getTimeStamp();
        String originUrl = apiRequest.getOriginUrl();

        AuthToken clientAuthToken = new AuthToken(token, timeStamp);
        if(clientAuthToken.isExpired()){
            throw new RuntimeException("Token is expired");
        }

        String password = credentialStorage.getPassWordByAppId(appId);
        AuthToken serverAuthToken = AuthToken.generate(apiRequest, password);

        if(!serverAuthToken.isMatched(clientAuthToken)){
            throw new RuntimeException("Token is not matched");
        }

        return true;
    }

    
    
}

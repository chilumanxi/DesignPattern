package github.chilumanxi.authentication;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Optional;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * AuthToken class
 *
 * @author zhanghaoran25
 * @date 2021/6/23 17:50
 */
public class AuthToken {
    /**
     * 过期时间
     */
    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 10 * 60 * 1000;

    /**
     * toekn
     */
    private String token;

    /**
     * 创建时间
     */
    private long createTime;

    /**
     * 过期时间
     */
    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    /**
     * 构造函数
     */
    public AuthToken(String token, long createTime) {
        this.createTime = createTime;
        this.token = token;
    }

    /**
     * 构造函数
     */
    public AuthToken(String token, long createTime, long expiredTimeInterval) {
        this.createTime = createTime;
        this.token = token;
        this.expiredTimeInterval = expiredTimeInterval;
    }


    /**
     * 检查token是否过期
     *
     * @return boolean
     */
    public boolean isExpired() {
        if (this.createTime + this.expiredTimeInterval < System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

   /**
    * 检查token是否一致
    *
    * @param authToken
    * @return boolean
    */
    public boolean isMatched(AuthToken authToken){
        if(this.token.equals(authToken.token)) {
            return true;
        }
        else {
            return false;

        }
    }


    /**
     * 创建客户端校验用的token
     * 
     * @param apiRequest 
     * @param password
     * @return github.chilumanxi.authentication.AuthToken 
     */
    public static AuthToken generate(ApiRequest apiRequest, String password) {
        String str = apiRequest.getOriginUrl() + "?AppId=" + apiRequest.getAppId() + "&pwd=" + password + "&ts=" + apiRequest.getTimeStamp();
        String token = DigestUtils.sha1Hex(str);
        System.out.println(token);

        AuthToken authToken = new AuthToken(token, apiRequest.getTimeStamp());
        return authToken;
    }



}

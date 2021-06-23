package github.chilumanxi.authentication;

import java.util.Date;

/**
 * ApiRequest class
 *
 * @author zhanghaoran25
 * @date 2021/6/23 17:24
 */
public class ApiRequest {
    /**
     * app id
     */
    private String appId;

    /**
     * token
     */
    private String token;

    /**
     * 时间戳
     */
    private long timeStamp;

    /**
     * get origin url
     *
     * @return java.lang.String 
     */
    public String getOriginUrl() {
        return originUrl;
    }

    /**
     * 原始url
     */
    private String originUrl;

    /**
     * get app id
     * 
     * @return java.lang.String 
     */
    public String getAppId() {
        return appId;
    }

    /**
     * get token
     * 
     * @return java.lang.String 
     */
    public String getToken() {
        return token;
    }


    /**
     * get time stamp
     * 
     * @return java.lang.Long 
     */
    public Long getTimeStamp() {
        return timeStamp;
    }

    public ApiRequest(String originUrl, String appId, long timeStamp, String token){
        this.originUrl = originUrl;
        this.appId = appId;
        this.timeStamp = timeStamp;
        this.token = token;
    }


    public static ApiRequest genFakeReq(String fullUrl) {
        ApiRequest req = new ApiRequest("chilumanxi", "test", Long.valueOf("1624453433420"),
                "7fa70b5a2d48f02400f02fce88d88e0eec57eaaa");
        System.out.println(System.currentTimeMillis());
        return req;
    }

}

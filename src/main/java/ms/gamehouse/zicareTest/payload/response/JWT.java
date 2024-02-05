package ms.gamehouse.zicareTest.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;


public class JWT {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expired_in")
    private Long expiredIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpiredIn() {
        return expiredIn;
    }

    public void setExpiredIn(Long expiredIn) {
        this.expiredIn = expiredIn;
    }
}

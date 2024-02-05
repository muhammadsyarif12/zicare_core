package ms.gamehouse.zicareTest.payload.request;

import jakarta.validation.constraints.NotBlank;

public class LogoutRequest {
    @NotBlank
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

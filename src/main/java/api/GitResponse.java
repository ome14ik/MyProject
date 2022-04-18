package api;
    import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class GitResponse {
        @JsonProperty("access_token")
        public String accessToken;
        @JsonProperty("expires_in")
        public int expiresIn;
        @JsonProperty("refresh_expires_in")
        public int refreshExpiresIn;
        @JsonProperty("token_type")
        public String tokenType;
        @JsonProperty("before")
        public long policy;
        @JsonProperty("scope")
        public String scope;

        @Override
        public String toString() {
            return "TokenResponse{" +
                    "accessToken='" + accessToken + '\'' +
                    ", expiresIn=" + expiresIn +
                    ", refreshExpiresIn=" + refreshExpiresIn +
                    ", tokenType='" + tokenType + '\'' +
                    ", policy=" + policy +
                    ", scope='" + scope + '\'' +
                    '}';
        }
    }

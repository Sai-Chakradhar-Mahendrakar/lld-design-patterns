package com.vertex.builderdesign.response;

public class UserResponse {
    private Long id;
    private String message;

    private UserResponse(Builder builder) {
        this.id = builder.id;
        this.message = builder.message;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public static class Builder {
        private Long id;
        private String message;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public UserResponse build(){
            return new UserResponse(this);
        }
    }
}

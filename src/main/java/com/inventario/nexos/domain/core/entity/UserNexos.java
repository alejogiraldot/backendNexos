package com.inventario.nexos.domain.core.entity;

import java.time.LocalDate;
import java.util.Objects;

public class UserNexos extends BaseEntity<Integer>{
    private final String userName;
    private final String age;
    private LocalDate addmisionUserDate;
    private String userType;


    public UserNexos(String userName, String age, LocalDate addmisionUserDate, String userType) {
        this.userName = userName;
        this.age = age;
        this.addmisionUserDate = addmisionUserDate;
        this.userType = userType;
    }
    public static UserNexos.Builder builder() {
        return new UserNexos.Builder();
    }
    private UserNexos(Builder builder) {
        super.setId(builder.id);
        userName = builder.userName;
        age = builder.age;
        addmisionUserDate = builder.addmisionUserDate;
        userType = builder.userType;
    }

    public String getUserName() {
        return userName;
    }

    public String getAge() {
        return age;
    }

    public LocalDate getAddmisionUserDate() {
        return addmisionUserDate;
    }

    public void setAddmisionUserDate(LocalDate addmisionUserDate) {
        this.addmisionUserDate = addmisionUserDate;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public static final class Builder {
        private Integer id;
        private String userName;
        private String age;
        private LocalDate addmisionUserDate;
        private String userType;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(Integer val) {
            id = val;
            return this;
        }

        public Builder userName(String val) {
            userName = val;
            return this;
        }

        public Builder age(String val) {
            age = val;
            return this;
        }

        public Builder addmisionUserDate(LocalDate val) {
            addmisionUserDate = val;
            return this;
        }

        public Builder userType(String val) {
            userType = val;
            return this;
        }

        public UserNexos build() {
            return new UserNexos(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserNexos userNexos)) return false;
        return Objects.equals(getUserName(), userNexos.getUserName()) && Objects.equals(getAge(), userNexos.getAge()) && Objects.equals(getAddmisionUserDate(), userNexos.getAddmisionUserDate()) && Objects.equals(getUserType(), userNexos.getUserType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getAge(), getAddmisionUserDate(), getUserType());
    }
}

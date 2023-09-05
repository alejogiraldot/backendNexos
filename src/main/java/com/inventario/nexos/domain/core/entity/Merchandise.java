package com.inventario.nexos.domain.core.entity;



import java.time.LocalDate;
import java.util.Objects;


public class Merchandise extends BaseEntity<Integer> {
    private final String productName;
    private final int quantity;
    private LocalDate admissionDate;
    private UserNexos userWhoRegisters;

    public Merchandise(String productName, int quantity, LocalDate admissionDate, UserNexos userWhoRegisters) {

        this.productName = productName;
        this.quantity = quantity;
        this.admissionDate = admissionDate;
        this.userWhoRegisters = userWhoRegisters;
    }

    public static Merchandise.Builder builder() {
        return new Merchandise.Builder();
    }
    private Merchandise(Builder builder) {
        super.setId(builder.id);
        productName = builder.productName;
        quantity = builder.quantity;
        admissionDate = builder.admissionDate;
        userWhoRegisters = builder.userWhoRegisters;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public UserNexos getUserWhoRegisters() {
        return userWhoRegisters;
    }

    public void setUserWhoRegisters(UserNexos userWhoRegisters) {
        this.userWhoRegisters = userWhoRegisters;
    }

    public static final class Builder {
        private Integer id;
        private String productName;
        private int quantity;
        private LocalDate admissionDate;
        private UserNexos userWhoRegisters;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(Integer val) {
            id = val;
            return this;
        }

        public Builder productName(String val) {
            productName = val;
            return this;
        }

        public Builder quantity(int val) {
            quantity = val;
            return this;
        }

        public Builder admissionDate(LocalDate val) {
            admissionDate = val;
            return this;
        }

        public Builder userWhoRegisters(UserNexos val) {
            userWhoRegisters = val;
            return this;
        }

        public Merchandise build() {
            return new Merchandise(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Merchandise that)) return false;
        return getQuantity() == that.getQuantity() && Objects.equals(getProductName(), that.getProductName()) && Objects.equals(getAdmissionDate(), that.getAdmissionDate()) && Objects.equals(getUserWhoRegisters(), that.getUserWhoRegisters());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductName(), getQuantity(), getAdmissionDate(), getUserWhoRegisters());
    }
}





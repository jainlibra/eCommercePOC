package com.publicissapient.pojo;

import java.util.Objects;

public class CardDetail {


        private String cardNo;
        private String name;
        private String expMonth;
        private String expYear;
        private String cvv;

        public String getCardNo() {
            return cardNo;
        }

        public void setCardNo(String cardNo) {
            this.cardNo = cardNo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getExpMonth() {
            return expMonth;
        }

        public void setExpMonth(String expMonth) {
            this.expMonth = expMonth;
        }

        public String getExpYear() {
            return expYear;
        }

        public void setExpYear(String expYear) {
            this.expYear = expYear;
        }

        public String getCvv() {
            return cvv;
        }

        public void setCvv(String cvv) {
            this.cvv = cvv;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardDetail that = (CardDetail) o;
        return cardNo.equals(that.cardNo) &&
                name.equals(that.name) &&
                expMonth.equals(that.expMonth) &&
                expYear.equals(that.expYear) &&
                cvv.equals(that.cvv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNo, name, expMonth, expYear, cvv);
    }
}

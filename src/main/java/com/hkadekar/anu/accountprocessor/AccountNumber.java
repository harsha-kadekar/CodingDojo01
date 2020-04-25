package com.hkadekar.anu.accountprocessor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountNumber {
    String accountNumber;
    String errorCode;

    public AccountNumber(String accountNumber, String errorCode) {
        this.accountNumber = accountNumber;
        this.errorCode = errorCode;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(obj == null) {
            return false;
        }


        if( !(obj instanceof AccountNumber)){
            return false;
        }

        AccountNumber ac = (AccountNumber) obj;

        if(this.accountNumber == null && ac.accountNumber != null ) {
            return false;
        }

        if(this.accountNumber != null && ac.accountNumber == null) {
            return false;
        }

        if(!this.accountNumber.equals(ac.accountNumber)) {
            return false;
        }

        if(this.errorCode == null && ac.errorCode != null) {
            return false;
        }

        if(this.errorCode != null && ac.errorCode == null) {
            return false;
        }

        if(!this.errorCode.equals(ac.errorCode)){
            return false;
        }

        return true;

    }
}

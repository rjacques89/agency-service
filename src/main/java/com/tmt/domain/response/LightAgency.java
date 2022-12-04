package com.tmt.domain.response;


import java.util.Set;
import java.util.UUID;

public interface LightAgency {


    void setMainUuId(UUID mainUuId);
    void setCode(String code);
    void setName(String code);
    void setAddress(String code);
    void setEmails(Set<String> emails);
    void setPhones(Set<String> phones);


    UUID getMainUuId();
    String getCode();
    String getName();
    String getAddress();
    Set<String> getEmails();
    Set<String> getPhones();

}

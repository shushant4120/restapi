package com.users.restapi.userinfo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserInfoPOJO {

    private int id;
    private String companyName;
    private String lat;
    private String lng;

}

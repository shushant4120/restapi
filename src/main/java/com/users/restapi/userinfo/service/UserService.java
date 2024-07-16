package com.users.restapi.userinfo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.users.restapi.userinfo.model.UserInfoPOJO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private static final String API_URL = "https://jsonplaceholder.typicode.com/users";

    public List<UserInfoPOJO> getUserList() {
        RestTemplate restTemplate = new RestTemplate();
        User[] users = restTemplate.getForObject(API_URL, User[].class);

        return Arrays.stream(users)
                .map(user -> {
                    UserInfoPOJO userInfo = new UserInfoPOJO();
                    userInfo.setId(user.getId());
                    userInfo.setCompanyName(user.getCompany().getName());
                    userInfo.setLat(user.getAddress().getGeo().getLat());
                    userInfo.setLng(user.getAddress().getGeo().getLng());
                    return userInfo;
                })
                .collect(Collectors.toList());
    }

    static class User {
        private int id;
        private Address address;
        private Company company;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public Company getCompany() {
            return company;
        }

        public void setCompany(Company company) {
            this.company = company;
        }
    }

    static class Address {
        private Geo geo;

        public Geo getGeo() {
            return geo;
        }

        public void setGeo(Geo geo) {
            this.geo = geo;
        }
    }

    static class Geo {
        private String lat;
        private String lng;

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }
    }

    static class Company {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

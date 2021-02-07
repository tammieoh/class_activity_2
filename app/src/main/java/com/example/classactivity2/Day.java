package com.example.classactivity2;

public class Day {
//    private String city;
//    private String country;
    private String time_date;
    private String description;
    private String feels_like;

    public Day (String time_date, String description, String feels_like) {
//        this.city = city;
//        this.country = country;
        this.time_date = time_date;
        this.description = description;
        this.feels_like = feels_like;
    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }

    public String getTime_date() {
        return time_date;
    }

    public void setTime_date(String time_date) {
        this.time_date = time_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(String feels_like) {
        this.feels_like = feels_like;
    }
}

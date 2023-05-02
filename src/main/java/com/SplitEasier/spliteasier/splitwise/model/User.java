package com.SplitEasier.spliteasier.splitwise.model;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@JsonRootName("user")
public class User {
    @JsonAlias("id")
    private int id;
    @JsonAlias("first_name")
    private String firstName;

    @JsonAlias("force_refresh_at")
    private String forceRefeshAt;
    @JsonAlias("country_code")
    private String countryCode;

    @JsonAlias("date_format")
    private String dateFormat;
    @JsonAlias("last_name")
    private String lastName;
    @JsonAlias("email")
    private String email;

    @JsonAlias("custom_picture")
    private String customPicture;
    @JsonAlias("registration_status")
    private String registrationStatus;

    @JsonAlias("default_group_id")
    private String defaultGroupId;

    @JsonAlias("picture")
    private JsonNode picture;
    @JsonAlias("notifications_read")
    private String notificationRead;
    @JsonAlias("notifications_count")
    private String notificationsCount;
    @JsonAlias("notifications")
    private JsonNode notifications;
    @JsonAlias("default_currency")
    private String defaultCurrency;
    @JsonAlias("local")
    private String locale;

    public List<String> getArrayProp(JsonNode prop){
        Iterator<JsonNode> iterator = prop.iterator();
        List<String> valueAsString = new ArrayList<>();
        while(iterator.hasNext()){
           valueAsString.add(iterator.next().toString());
        }
        return valueAsString;
    }

    public String getCustomPicture() {
        return customPicture;
    }

    public void setCustomPicture(String customPicture) {
        this.customPicture = customPicture;
    }

    public String getDefaultGroupId() { return defaultGroupId;
    }

    public void setDefaultGroupId(String defaultGroupId) {
        this.defaultGroupId = defaultGroupId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public JsonNode getPicture() {
        return picture;
    }

    public void setPicture(JsonNode picture) { this.picture = picture;
    }
    public String getNotificationRead() {
        return notificationRead;
    }

    public void setNotificationRead(String notificationRead) {
        this.notificationRead = notificationRead;
    }

    public String getNotificationsCount() {
        return notificationsCount;
    }

    public void setNotificationsCount(String notificationsCount) {
        this.notificationsCount = notificationsCount;
    }

    public JsonNode getNotifications() {
        return notifications;
    }

    public void setNotifications(JsonNode notifications) {
        this.notifications = notifications;
    }

    public String getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getForceRefeshAt() {
        return forceRefeshAt;
    }

    public void setForceRefeshAt(String forceRefeshAt) {
        this.forceRefeshAt = forceRefeshAt;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", customPicture='" + customPicture + '\'' +
                ", registrationStatus='" + registrationStatus + '\'' +
                ", picture=" + picture.toString() +
                ", notificationRead='" + notificationRead + '\'' +
                ", notificationsCount='" + notificationsCount + '\'' +
                ", notifications=" + notifications.toString()+
                ", defaultCurrency='" + defaultCurrency + '\'' +
                ", locale='" + locale + '\'' +
                '}';
    }
}

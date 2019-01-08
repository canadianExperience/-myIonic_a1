package com.example.lena.volley;

public class Patient {
    private String mFirstName;
    private String mLastName;
    private String mDateOfBirth;
    private String mGender;
    private String mAddress;
    private String mCity;
    private String mProvince;
    private String mPostalCode;
    private String mDoctor;
    private String m_id;

    public Patient(String firstName, String lastName, String dateOfBirth, String gender, String address, String city, String province, String postalCode, String doctor, String _id) {
        this.mFirstName = firstName;
        this.mLastName = lastName;
        this.mDateOfBirth = dateOfBirth;
        this.mGender = gender;
        this.mAddress = address;
        this.mCity = city;
        this.mProvince = province;
        this.mPostalCode = postalCode;
        this.mDoctor = doctor;
        this.m_id = _id;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public String getDateOfBirth() {
        return mDateOfBirth;
    }

    public String getGender() {
        return mGender;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getCity() {
        return mCity;
    }

    public String getProvince() {
        return mProvince;
    }

    public String getDoctor() {
        return mDoctor;
    }

    public String getPostalCode() {
        return mPostalCode;
    }

    public String get_id() {
        return m_id;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public void setLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public void setDateOfBirth(String mDateOfBirth) {
        this.mDateOfBirth = mDateOfBirth;
    }

    public void setGender(String mGender) {
        this.mGender = mGender;
    }

    public void setAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public void setCity(String mCity) {
        this.mCity = mCity;
    }

    public void setDoctor(String mDoctor) {
        this.mDoctor = mDoctor;
    }

    public void setProvince(String mProvince) {
        this.mProvince = mProvince;
    }

    public void setPostalCode(String mPostalCode) {
        this.mPostalCode = mPostalCode;
    }

    public void set_id(String m_id) {
        this.m_id = m_id;
    }
}

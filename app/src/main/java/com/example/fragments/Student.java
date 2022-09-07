package com.example.fragments;

public class Student {

    int studentID;
    String nazwisko;
    String imie;
    String email;
    int przedID;

    public Student(int studentID, String nazwisko, String imie, String email, int przedID) {
        this.studentID = studentID;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.email = email;
        this.przedID = przedID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPrzedID() {
        return przedID;
    }

    public void setPrzedID(int przedID) {
        this.przedID = przedID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", nazwisko='" + nazwisko + '\'' +
                ", imie='" + imie + '\'' +
                ", email='" + email + '\'' +
                ", przedID=" + przedID +
                '}';
    }
}

package com.example.fragments;

public class Przedmiot implements Comparable<Przedmiot>{

    int przedmiotID;
    String nazwa;
    int rok;
    String tematZajec;
    int data;
    int sala;
    String rodzajZajec;

    public Przedmiot(int przedmiotID, String nazwa, int rok, String tematZajec, int data, int sala, String rodzajZajec) {
        this.przedmiotID = przedmiotID;
        this.nazwa = nazwa;
        this.rok = rok;
        this.tematZajec = tematZajec;
        this.data = data;
        this.sala = sala;
        this.rodzajZajec = rodzajZajec;
    }

    public int getPrzedmiotID() {
        return przedmiotID;
    }

    public void setPrzedmiotID(int przedmiotID) {
        this.przedmiotID = przedmiotID;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public String getTematZajec() {
        return tematZajec;
    }

    public void setTematZajec(String tematZajec) {
        this.tematZajec = tematZajec;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getRodzajZajec() {
        return rodzajZajec;
    }

    public void setRodzajZajec(String rodzajZajec) {
        this.rodzajZajec = rodzajZajec;
    }

    @Override
    public String toString() {
        return "Przedmiot{" +
                "przedmiotID=" + przedmiotID +
                ", nazwa='" + nazwa + '\'' +
                ", rok=" + rok +
                ", tematZajec='" + tematZajec + '\'' +
                ", data=" + data +
                ", sala=" + sala +
                ", rodzajZajec='" + rodzajZajec + '\'' +
                '}';
    }

    @Override
    public int compareTo(Przedmiot przedmiot){

        if (this.getData() > przedmiot.getData()){
            return 1;
        }
        else if (this.getData() < przedmiot.getData()){
            return -1;
        }
        else {
            return 0;
        }
    }


}

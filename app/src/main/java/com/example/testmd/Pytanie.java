package com.example.testmd;

public class Pytanie {
    private int idZdjecia;
    private String trescPytania;
    private boolean odpowiedz;
    //tak - true, nie - false
    private boolean poprawnaOdpowiedz;

    private String podpowiedz;
    private boolean wykoszystanoPodpowiedz;

    public Pytanie(int idZdjecia, String trescPytania, boolean odpowiedz, String podpowiedz) {
        this.idZdjecia = idZdjecia;
        this.trescPytania = trescPytania;
        this.odpowiedz = odpowiedz;
        this.podpowiedz = podpowiedz;
        poprawnaOdpowiedz = false;
        wykoszystanoPodpowiedz = false;
    }

    public Pytanie(int idZdjecia, String trescPytania, boolean odpowiedz) {
        this.idZdjecia = idZdjecia;
        this.trescPytania = trescPytania;
        this.odpowiedz = odpowiedz;
        poprawnaOdpowiedz = false;
        wykoszystanoPodpowiedz = false;
    }

    public int getIdZdjecia() {
        return idZdjecia;
    }

    public String getTrescPytania() {
        return trescPytania;
    }

    public boolean isOdpowiedz() {
        return odpowiedz;
    }

    public boolean isPoprawnaOdpowiedz() {
        return poprawnaOdpowiedz;
    }

    public void setCzyPoprawnaOdpowiedz(boolean czyPoprawnaOdpowiedz){
        this.poprawnaOdpowiedz = czyPoprawnaOdpowiedz;
    }

    public String getPodpowiedz() {
        return podpowiedz;
    }

    public void setPodpowiedz(String podpowiedz) {
        this.podpowiedz = podpowiedz;
    }

    public boolean isWykoszystanoPodpowiedz() {
        return wykoszystanoPodpowiedz;
    }

    public void setWykoszystanoPodpowiedz(boolean wykoszystanoPodpowiedz) {
        this.wykoszystanoPodpowiedz = wykoszystanoPodpowiedz;
    }
}

class Zivotinja {
private static int brojac = 1;
private int id = brojac++;
private String ime;
private int tezina;
private String pol;
private int indeks;
Zivotinja(String ime,int tezina, String pol,int indeks){
        this.ime = ime;
        this.tezina = tezina;
        this.pol = pol;
        this.indeks = indeks;
}
public String toString(){
        return "\nInformacije o zivotinji { \n ID : " + id + "\n Ime : " + ime + "\n Tezina : " + tezina + "kg.\n Pol : " + pol;
}
public int prikaziID(){
        return id;
}
public void promeniIndeks(int noviIndeks){
        indeks = noviIndeks;
}
public String prikaziIme(){
        return ime;
}
public int prikaziIndeks(){
        return indeks;
}
public int prikaziCenu(){
        return -1;
}
public int prikaziPrihod(){
        return -1;
}
public void zvuk(){
        return;
}
}

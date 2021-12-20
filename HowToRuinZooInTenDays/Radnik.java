class Radnik {
private static int brojac = 1;
private int id = brojac++;
private String ime;
private String prezime;
private int godiste;
private String pol;
private int plata;
private int indeks;

Radnik(String ime, String prezime, int godiste, String pol,int plata, int indeks){
        this.ime = ime;
        this.prezime = prezime;
        this.godiste = godiste;
        this.pol = pol;
        this.plata = plata;
        this.indeks = indeks;
}
public String toString(){
        return "\nInformacije o radniku { \n ID : " + id + "\n Ime : " + ime + "\n Prezime : " + prezime + "\n Godiste : " + godiste + "\n Pol : " + pol + "\n Plata : " + plata + " RSD }";
}
public int prikaziID(){
        return id;
}
public int prikaziPlatu(){
        return plata;
}
public void povecajPlatu(int povisica){
        plata+=povisica;
}
public void promeniIndeks(int noviIndeks){
        indeks = noviIndeks;
}
public int prikaziIndeks(){
        return indeks;
}
}

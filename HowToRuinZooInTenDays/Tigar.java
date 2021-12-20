class Tigar extends Zivotinja {
private String vrsta = "TIGAR";
private int cena = 500;
private int prihod = 100;
Tigar(String ime, int tezina, String pol, int indeks ){
        super(ime,tezina,pol,indeks);
}
public String toString(){
        return super.toString() + "\n Vrsta : " + vrsta + " }";
}
public int prikaziCenu(){
        return cena;
}
public int prikaziPrihod(){
        return prihod;
}
public void zvuk(){
        System.out.println("Tigar " + super.prikaziIme() +" kaze GRRR.");
}
}

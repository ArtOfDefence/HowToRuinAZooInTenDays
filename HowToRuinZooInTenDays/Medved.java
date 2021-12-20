class Medved extends Zivotinja {
private String vrsta = "MEDVED";
private int cena = 1000;
private int prihod = 200;
Medved(String ime,int tezina,String pol,int indeks ){
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
        System.out.println("Medved "+ super.prikaziIme() + " kaze RROOO.");
}
}

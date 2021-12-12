class Radnik{
  private static int brojac = 1;
  private int id = brojac++;
  private String ime;
  private String prezime;
  private int godiste;
  private String pol;
  private int plata;
  private int indeks;
  Radnik(String ime, String prezime, int godiste, String pol, int indeks){
    this.ime = ime;
    this.prezime = prezime;
    this.godiste = godiste;
    this.pol = pol;
    this.indeks = indeks;
    plata = 200;
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
  public void povecajPlatu(int a){
    plata+=a;
  }
  public void promeniIndeks(int a){
    indeks = a;
  }
  public int prikaziIndeks(){
    return indeks;
  }
}

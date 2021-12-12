class Zivotinja{
  private static int brojac = 1;
  private int id = brojac++;
  private String ime;
  private String pol;
  private int visina;
  private int tezina;
  private String boja;
  private boolean gladan;
  private String vrsta;
  private int cena;
  private int prihod;
  private int indeks;
  Zivotinja(String ime, int visina, int tezina, String pol, String boja,int indeks){
    this.ime = ime;
    this.visina = visina;
    this.tezina = tezina;
    this.pol = pol;
    this.boja = boja;
    this.indeks = indeks;
    gladan = false;
  }
  public String toString(){
    return "Informacije o zivotinji { \n ID : " + id + "\n Ime : " + ime + "\n Pol : " + pol +"\n Visina : " + visina + "\n Tezina : " + tezina + "\n Boja : " + boja;
  }
  public String zvuk(){
    return "hihi";
  }
  public int prikaziID(){
    return id;
  }
  public int prikaziCenu(){
    return cena;
  }
  public int prikaziPrihod(){
    return prihod;
  }
  public void nahraniZivotinju(){
    gladan = false;
  }
  public boolean uciniZivotinjuGladnom(){
    return gladan;
  }
  public void promeniIndeks(int a){
    indeks = a;
  }
  public int prikaziIndeks(){
    return indeks;
  }
}

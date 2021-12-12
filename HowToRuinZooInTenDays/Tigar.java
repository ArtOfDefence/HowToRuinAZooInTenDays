class Tigar extends Zivotinja{
  private String vrsta;
  private int cena;
  private int prihod;
  Tigar(String ime, int visina, int tezina, String pol, String boja ){
    super(ime,visina,tezina,pol,boja);
    vrsta = "Tigar";
    cena = 500;
    prihod = 100;
  }
  public String toString(){
    return super.toString() + "\n Vrsta : " + vrsta + "\n Cena : " + cena + "\n Prihod : " + prihod + " }";
  }
  public String zvuk(){
    return "Tigar kaze GRRR.";
  }
}

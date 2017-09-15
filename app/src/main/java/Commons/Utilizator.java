package Commons;

/**
 * Created by idanciu on 9/12/2017.
 */

public class Utilizator {
    private String nume;
    private String username;
    private String parola;
    private Angajat angajat;



    public String getNume() { return nume; }
    public Utilizator setNume(String nume) { this.nume = nume; return this;}

    public String getUsername() { return username; }
    public Utilizator setUsername(String username) { this.username = username; return this;}

    public String getParola() { return parola; }
    public Utilizator setParola(String parola) { this.parola = parola; return this; }

    public Angajat getAngajat() { return angajat; }
    public Utilizator setAngajat(Angajat angajat) { this.angajat = angajat; return this;}
}

package calvin.character;

public class Character {
    // Initialisasi attribut
    protected int HP;
    protected String name;
    
    // Set Constructor
    public Character(String name, int HP) {
        this.name = name;
        this.HP = HP;
    }

    public Character(String name) {
        this.name = name;
        this.HP = 100;
    }

    public Character() {
        this.name = "Aldi";
        this.HP = 100;
    }

    // dalam Game, HP adalah Reputasi
    public void showHP() {
        System.out.println("Reputasi anda : " + this.HP);
    }

    public void showNama() {
        System.out.println("Nama anda : " + this.name);
    }

    // Mekanisme tambah HP 
    public void stepSuccess(int tambahan) {
        this.HP += tambahan;
    }

    // Menakisme kurangi HP 
    public void stepFailed(int kurangin) {
        this.HP -= kurangin;
    }

    // Untuk cek apakah HP masih ada atau tidak
    public boolean statusHP() {
        return this.HP > 0;
    }

    public String getNama() {
        return this.name;
    }

    public int getHP() {
        return this.HP;
    }
}
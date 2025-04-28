package calvin.character;

class Character {
    // Initialisasi attribut
    protected int HP;
    protected String name;
    
    // Set Constructor
    Character(String nama, int HP) {
        this.name = name;
        this.HP = HP;
    }

    Character(String nama) {
        this.name = name;
        this.HP = 100;
    }

    Character() {
        this.name = "Aldi";
        this.HP = 100;
    }

    // dalam Game, HP adalah Reputasi
    public void getHP() {
        System.out.println("Reputasi anda : " + this.hp);
    }

    public void getName() {
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
}
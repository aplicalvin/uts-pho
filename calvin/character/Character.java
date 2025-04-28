package calvin.character;

class Character {
    // Initialisasi attribut
    protected int HP;
    protected String name;
    
    // Set Constructor
    void Character(String nama, int HP) {
        this.name = name;
        this.HP = HP;
    }

    void Character(String nama) {
        this.name = name;
        this.HP = 100;
    }

    void Character() {
        this.name = "Aldi";
        this.HP = 100;
    }

    // dalam Game, HP adalah Reputasi
    void getHP() {
        System.out.println("Reputasi anda : " + this.hp);
    }

    void getName() {
        System.out.println("Nama anda : " + this.name);
    }

    // Mekanisme tambah HP 
    void tambahinHp(int tambahan) {
        this.HP += tambahan;
    }

    // Menakisme kurangi HP 
    void kuranginHP(int kurangin) {
        this.HP -= kurangin;
    }

    // Untuk cek apakah HP masih ada atau tidak
    boolean statusHP() {
        return this.HP > 0;
    }
}
package calvin.enemy;
import calvin.character.Character;

public class Enemy extends Character {
    protected int harapan;
    protected int reputasi; // mendeteksi HP lawan

    // Konstruktor 1
    public Enemy(String name, int HP, int harapan) {
        super(name, HP); // Memanggil konstruktor parent
        this.harapan = harapan;
    }

    // Konstruktor 2
    public Enemy(String name) {
        super(name); // Memanggil konstruktor parent
        this.HP = 120; // Override nilai HP default dari Character
        this.harapan = 150;
    }
    
    // Konstruktor 3
    public Enemy() {
        super(); // Memanggil konstruktor default parent
        this.name = "Ririn"; // Override nilai name default dari Character
        this.HP = 120; // Override nilai HP default dari Character
        this.harapan = 150;
    }

    @Override
    public void stepSuccess(int tambahan) {
        if (reputasi > 20) {
            int tambahGengsi = tambahan * 2;
            this.HP += tambahan; 
        } else {
            this.HP += tambahan;
        }
    }

    @Override
    public boolean statusHP() {
        return this.HP > 0;
    }
}
package calvin.enemy;
import calvin.character.Character;

class Enemy extend Character {
    protected int harapan;
    protected int reputasi; // mendeteksi HP lawan


    Enemy(String nama, int HP, int harapan) {
        this.nama = nama;
        this.HP = HP;
        this.harapan = harapan;
    }

    Enemy(String nama) {
        this.nama = nama;
        this.HP = 120;
        this.harapan = 150;
    }
    
    Enemy() {
        this.nama = "Ririn";
        this.HP = 120;
        this.harapan = 150;
    }

    @Override
    public void stepSuccess(int tambahan) {
        if ( reputasi > 20 ) {
            int tambahGengsi = tambahan * 1.5;
            this.HP += tambahan; 
        }

        this.HP += tambahan;
    }

    public boolean statusHP() {
        return this.HP > 0;
    }
    
    
}
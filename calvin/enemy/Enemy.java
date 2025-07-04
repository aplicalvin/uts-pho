// File: calvin/enemy/Enemy.java
package calvin.enemy;
import calvin.character.Character;

public class Enemy extends Character {
    protected int harapan;

    // Constructor memanggil constructor parent (super)
    public Enemy(String name) {
        super(name, 120); // Gengsi default untuk enemy adalah 120
        this.harapan = 150;
    }

    // WAJIB meng-override metode abstrak dari parent
    @Override
    public void displayStatus() {
        System.out.println("Gengsi Dia [" + this.getNama() + "]: " + this.getHP());
    }
    
    // Enemy punya perilaku khusus saat berhasil, jadi kita override lagi.
    @Override
    public void aksiBerhasil(int tambahan) {
        // Logika gengsi bisa dibuat lebih kompleks di sini jika perlu
        this.HP += (tambahan / 2); // Misalnya, gengsi dia naik lebih lambat
        System.out.println("(Dia sedikit terkesan...)");
    }

    public int getHarapan() {
        return this.harapan;
    }
}
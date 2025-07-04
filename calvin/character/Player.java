// File: calvin/character/Player.java
package calvin.character;

public class Player extends Character {

    // Constructor memanggil constructor parent (super)
    public Player(String name) {
        // HP default untuk player adalah 100
        super(name, 100);
    }

    // WAJIB meng-override metode abstrak dari parent
    @Override
    public void displayStatus() {
        System.out.println("Reputasi Kamu [" + this.getNama() + "]: " + this.getHP());
    }
}
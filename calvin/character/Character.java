// File: calvin/character/Character.java
package calvin.character;

// 1. Menjadi ABSTRACT class dan meng-IMPLEMENTS interface Aksi
public abstract class Character implements Aksi {
    protected int HP;
    protected String name;

    // Constructor tetap sama
    public Character(String name, int HP) {
        this.name = name;
        this.HP = HP;
    }
    
    // 2. Implementasi default dari interface Aksi
    // Metode ini bisa di-override oleh subclass jika butuh perilaku khusus.
    @Override
    public void aksiBerhasil(int tambahan) {
        this.HP += tambahan;
    }

    @Override
    public void aksiGagal(int kurangin) {
        this.HP -= kurangin;
    }

    // 3. Menambahkan ABSTRACT METHOD
    // Setiap subclass WAJIB memberikan implementasi unik untuk metode ini.
    public abstract void displayStatus();

    // Getter dan metode lainnya tetap sama
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
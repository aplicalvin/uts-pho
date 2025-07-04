// File: calvin/character/Aksi.java
package calvin.character;

public interface Aksi {
    // Setiap class yang mengimplementasikan Aksi, WAJIB punya metode ini.
    void aksiBerhasil(int poin);
    void aksiGagal(int poin);
}
package calvin;
import java.util.Scanner;
import calvin.character.Character;
import calvin.enemy.Enemy;
import calvin.quiz.Quiz;

class Main {
    public static void main(String[] args) {
        Scanner masukan = new Scanner(System.in);
        
        // ===== INISIALISASI CHARACTER =====
        System.out.println("=== GAME SIMULASI PACARAN ===");
        System.out.print("Masukkan nama kamu : ");
        String namaPlayer = masukan.nextLine();
        Character player = new Character(namaPlayer);

        System.out.print("Masukkan nama pacar kamu : ");
        String namaPacar = masukan.nextLine();
        Enemy pacar = new Enemy(namaPacar);

        System.out.println("\n=== PROFIL ===");
        System.out.println("Kamu: " + player.getNama() + " | Reputasi: " + player.getHP());
        System.out.println("Pacar: " + pacar.getNama() + "\n");

        // ===== INISIALISASI QUIZ =====
        Quiz datingQuiz = new Quiz(player, pacar);
        
        // ===== MEKANISME GAME LOOP =====
        System.out.println("=== MULAI QUIZ ===");
        System.out.println("Setiap jawaban akan mempengaruhi reputasimu!");
        System.out.println("Pilih jawaban (1-3) untuk menjawab.\n");

        for (int i = 0; i < datingQuiz.getTotalQuestions(); i++) {
            // Tampilkan pertanyaan
            datingQuiz.displayQuestion(i);
            
            // Input jawaban dengan validasi
            int pilihan = 0;
            while (pilihan < 1 || pilihan > 3) {
                System.out.print("Pilihanmu (1-3): ");
                try {
                    pilihan = Integer.parseInt(masukan.nextLine());
                    if (pilihan < 1 || pilihan > 3) {
                        System.out.println("Masukkan angka 1-3 saja!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input harus angka!");
                }
            }
            
            // Proses jawaban
            datingQuiz.checkAnswer(i, pilihan);
            
            // Tampilkan update reputasi
            System.out.println("Reputasi sekarang: " + player.getHP() + "\n");
            
            // Cek game over
            if (!datingQuiz.isGameActive()) {
                System.out.println("=== GAME OVER ===");
                System.out.println("Reputasi kamu sudah habis!");
                break;
            }
            
            // Jeda sebelum pertanyaan berikutnya
            if (i < datingQuiz.getTotalQuestions() - 1) {
                System.out.println("Tekan Enter untuk lanjut...");
                masukan.nextLine();
            }
        }

        // ===== AKHIR GAME =====
        if (datingQuiz.isGameActive()) {
            System.out.println("=== SELAMAT ===");
            System.out.println("Kamu berhasil menyelesaikan semua tantangan!");
            System.out.println("Reputasi akhir: " + player.getHP());
            
            // Berdasarkan reputasi akhir
            if (player.getHP() >= 30) {
                System.out.println("Hasil: " + pacar.getNama() + " sangat menyukaimu!");
            } else if (player.getHP() >= 15) {
                System.out.println("Hasil: " + pacar.getNama() + " masih ragu-ragu.");
            } else {
                System.out.println("Hasil: " + pacar.getNama() + " tidak tertarik padamu.");
            }
        }

        masukan.close();
    }
}
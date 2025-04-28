package calvin;
import java.util.Scanner;
import calvin.character.Character;
import calvin.enemy.Enemy;
import calvin.quiz.Quiz;

class Main {
    public static void main(String[] args) {
        Scanner masukan = new Scanner(System.in);
        boolean lanjutganih;

        do {
            
            // ===== INISIALISASI CHARACTER =====
            System.out.println("================================================ ");
            System.out.println("> \"Heart's Quest: Pursuit of Love \" ");
            System.out.println("================================================ ");
            System.out.println("Game ini merupakan simulasi ketika kamu mendekati seorang perempuan. Dapatkah kamu menurunkan gengsinya dan mendapatkan hatinya dengan reputasimu?");
            System.out.println("Good Luck and Enjoy the game! \n");
            System.out.print("Masukkan nama kamu : ");
            String namaPlayer = masukan.nextLine();
            Character player = new Character(namaPlayer);

            System.out.print("Masukkan nama pacar kamu : ");
            String namaPacar = masukan.nextLine();
            Enemy pacar = new Enemy(namaPacar);

            System.out.println("\n=== PROFIL ===");
            System.out.println("Kamu: " + player.getNama() + " | Reputasi: " + player.getHP());
            System.out.println("Pacar: " + pacar.getNama() + " | Gengsi  : " + pacar.getHP() + "\n");

            // ===== INISIALISASI QUIZ =====
            Quiz datingQuiz = new Quiz(player, pacar);
            
            // ===== MEKANISME GAME LOOP =====
            System.out.println("================================================ ");
            System.out.println(">              Mulai Permainan                  |");
            System.out.println("================================================ ");
            System.out.println("Setiap jawaban akan mempengaruhi reputasimu dan gengsi dia!");
            System.out.println("Pilih jawaban (1-5) untuk menjawab.\n");

            for (int i = 0; i < datingQuiz.getTotalQuestions(); i++) {
                // Tampilkan pertanyaan
                datingQuiz.displayQuestion(i);
                
                // Input jawaban dengan validasi
                int pilihan = 0;
                while (pilihan < 1 || pilihan > 5) { // Diubah dari 3 ke 5
                    System.out.println("================================================ ");
                    System.out.print("> Pilihanmu (1-5): ");
                    try {
                        pilihan = Integer.parseInt(masukan.nextLine());
                        if (pilihan < 1 || pilihan > 5) { // Diubah dari 3 ke 5
                            System.out.println("Masukkan angka 1-5 saja!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Input harus angka!");
                    }
                    System.out.println("================================================ ");
                }
                
                // Proses jawaban
                datingQuiz.checkAnswer(i, pilihan);
                
                // Tampilkan update reputasi dan gengsi 
                System.out.println("================================================ ");
                System.out.println("Reputasi sekarang: " + player.getHP());
                System.out.println("Gengsi dia sekarang: " + pacar.getHP());
                System.out.println("================================================ ");
                
                // Cek game over
                if (!datingQuiz.isGameActive() || pilihan == 5) {
                    System.out.println("================================================ ");
                    System.out.println(">             Permainan Berakhir               |");
                    System.out.println("================================================ ");
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
                System.out.println("\n\n");
                System.out.println("================================================ ");
                System.out.println(">            S  E  L  A  M  A  T               |");
                System.out.println("================================================ ");

                if (player.getHP() >= pacar.getHarapan()) {
                    System.out.println("Kamu mendapat super duper good ending");
                } else {
                    System.out.println("Kamu berhasil menyelesaikan semua tantangan!");
                }
                System.out.println("================================================ ");
                System.out.println("Reputasi akhir: " + player.getHP());
                System.out.println("Gengsi si dia akhir: " + pacar.getHP());
                System.out.println("================================================ ");
                
                // Berdasarkan reputasi akhir
                if (player.getHP() >= pacar.getHarapan()) {
                    System.out.println("Hasil: " + pacar.getNama() + " suka banget sama kamu!!! ayo tembak sekarang!");
                } else if (player.getHP() >= 50 && pacar.getHP() <=25) {
                    System.out.println("Hasil: " + pacar.getNama() + " nyaman dengan kamu dan siap menjadi pacar kamu!");
                } else if (player.getHP() >= 50 && pacar.getHP() <=50) {
                    System.out.println("Hasil: " + pacar.getNama() + " dan kamu menjalani HTS :)");
                } else if (player.getHP() >= 0 && pacar.getHP() <=50) {
                    System.out.println("Hasil: " + pacar.getNama() + " dan kamu lebih baik berteman saja");
                } else {
                    System.out.println("Hasil: " + pacar.getNama() + " tidak tertarik padamu.");
                }
                System.out.println("================================================ ");

            }


            // ========================= MEKANISME LOOPING =======================
            System.out.println("\n\n");
            System.out.println("================================================ ");
            System.out.print("Lanjutkan? (True / False): ");
            lanjutganih = masukan.nextBoolean();
            System.out.println("================================================ ");
            System.out.println("\n\n\n");
        } while (lanjutganih);
        
    }
}
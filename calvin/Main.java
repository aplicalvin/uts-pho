package calvin;

import java.util.Scanner;
import calvin.character.Player;
import calvin.enemy.Enemy;
import calvin.quiz.Quiz;

class Main {
    public static void main(String[] args) {
        Scanner masukan = new Scanner(System.in);
        boolean lanjutMain;

        do {
            System.out.println("================================================ ");
            System.out.println("> \"Heart's Quest: Pursuit of Love \" ");
            System.out.println("================================================ ");
            System.out.println("Game ini adalah simulasi pendekatan (PDKT).");
            System.out.println("Setiap jawaban akan mempengaruhi reputasimu dan gengsi dia.");
            System.out.println("Good Luck!\n");

            System.out.print("Masukkan nama kamu: ");
            String namaPlayer = masukan.nextLine();
            Player player = new Player(namaPlayer);

            System.out.print("Masukkan nama gebetan kamu: ");
            String namaGebetan = masukan.nextLine();
            Enemy gebetan = new Enemy(namaGebetan);

            System.out.println("\n=== PROFIL AWAL ===");
            player.displayStatus();
            gebetan.displayStatus();
            System.out.println("Target Harapan Dia: " + gebetan.getHarapan() + "\n");
            
            System.out.println("Tekan Enter untuk memulai permainan...");
            masukan.nextLine();

            Quiz datingQuiz = new Quiz(player, gebetan);

            for (int i = 0; i < datingQuiz.getTotalQuestions(); i++) {
                datingQuiz.displayQuestion(i);

                int pilihan = 0;
                while (true) {
                    System.out.println("------------------------------------------------ ");
                    System.out.print("> Pilihanmu (1-5): ");
                    try {
                        pilihan = Integer.parseInt(masukan.nextLine());
                        if (pilihan >= 1 && pilihan <= 5) {
                            // Validasi khusus untuk opsi 'surprise'
                            if (pilihan == 4 && i <= 4) {
                                System.out.println("Opsi 'Surprise' baru tersedia setelah pertanyaan ke-5!");
                                continue; // Minta input lagi
                            }
                            break; // Input valid, keluar dari loop
                        } else {
                            System.out.println("Masukkan hanya angka 1-5!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Input tidak valid, masukkan angka saja!");
                    }
                }

                datingQuiz.checkAnswer(i, pilihan);

                if (!datingQuiz.isGameActive()) {
                    break;
                }

                System.out.println("\n--- STATUS TERBARU ---");
                player.displayStatus();
                gebetan.displayStatus();
                System.out.println("----------------------");

                if (i < datingQuiz.getTotalQuestions() - 1) {
                    System.out.println("\nTekan Enter untuk lanjut ke pertanyaan berikutnya...");
                    masukan.nextLine();
                }
            }

            // HASIL AKHIR PERMAINAN
            System.out.println("\n================================================ ");
            System.out.println(">               PERMAINAN SELESAI              ");
            System.out.println("================================================ ");
            System.out.println("Reputasi akhir kamu: " + player.getHP());
            System.out.println("Gengsi akhir dia: " + gebetan.getHP());
            System.out.println("------------------------------------------------ ");

            if (player.getHP() >= gebetan.getHarapan()) {
                System.out.println("HASIL: PERFECT ENDING! Dia melihatmu sebagai pasangan ideal!");
            } else if (player.getHP() >= 100 && gebetan.getHP() <= 50) {
                System.out.println("HASIL: GOOD ENDING! Dia sangat tertarik padamu. Ayo tembak!");
            } else if (player.getHP() >= 75) {
                System.out.println("HASIL: HTS ENDING! Hubungan Tanpa Status. Ada chemistry, tapi butuh kepastian.");
            } else if (player.getHP() >= 50) {
                System.out.println("HASIL: FRIENDZONE! Dia nyaman, tapi hanya sebagai teman.");
            } else {
                System.out.println("HASIL: BAD ENDING! Kamu lebih baik move on.");
            }
            System.out.println("================================================ ");

            System.out.print("\nApakah kamu ingin mencoba lagi? (true/false): ");
            while (true) {
                try {
                    lanjutMain = Boolean.parseBoolean(masukan.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.print("Input tidak valid. Masukkan 'true' atau 'false': ");
                }
            }

        } while (lanjutMain);

        System.out.println("\nTerima kasih sudah bermain!");
        masukan.close();
    }
}
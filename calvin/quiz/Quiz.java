package calvin.quiz;

import calvin.character.Player;
import calvin.enemy.Enemy;

public class Quiz {
    private Player player;
    private Enemy enemy;
    private boolean statusGame;
    private int surpriseCount = 3;

    // Constructor
    public Quiz(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        this.statusGame = true;
    }

    // =======================================================================
    // ======================= BANK SOAL & JAWABAN BARU ======================
    // =======================================================================

    // =======================================================================
    // ====== BANK SOAL & JAWABAN (KUNCI JAWABAN SUDAH DIACAK) ===============
    // =======================================================================

    // Pertanyaan tetap sama
    private String[] questions = {
            "Kalian satu kelompok tugas, dan dia terlihat kesulitan memahami materi. Apa yang kamu lakukan?",
            "Saat presentasi, dia lupa salah satu poin penting. Bagaimana caramu membantunya?",
            "Secara tidak sengaja kamu melihat dia sedang curhat dengan temannya dan menyebut namamu. Reaksimu?",
            "Dia memuji hasil kerjamu di depan dosen. Apa responsmu?",
            "Di luar kampus, kamu melihatnya sedang sendirian dan terlihat bosan. Apa yang kamu lakukan?",
            "Dia meminjam catatanmu dan tidak sengaja menumpahkan kopi di atasnya. Bagaimana sikapmu?",
            "Kalian berpapasan di koridor, dan dia tersenyum padamu. Apa yang kamu balas?",
            "Dia chat kamu malam-malam, 'Besok ada kuis, aku belum siap sama sekali!'. Bantuanmu?",
            "Kamu tahu hari ini dia ulang tahun. Apa tindakanmu?",
            "Saat sedang makan bareng teman-teman, hanya tersisa satu potong pizza terakhir. Apa yang kamu lakukan?",
            "Dia terlihat sangat kelelahan setelah seharian penuh kegiatan. Apa yang kamu tawarkan?",
            "Rivalmu (Tono) mencoba menjatuhkanmu dengan menyebar gosip. Bagaimana kamu mengklarifikasi ke dia?",
            "Dia bercerita tentang film favoritnya yang belum pernah kamu tonton. Responsmu?",
            "Kalian terjebak hujan deras berdua di halte. Apa topik obrolan yang kamu mulai?",
            "Dia bertanya, 'Menurutmu, apa sih kualitas terbaik yang aku punya?'. Jawaban tulusmu?"
    };

    // Opsi jawaban (posisinya sudah diacak)
    private String[][] options = {
            // Soal 1: Positif [2], Netral [0], Negatif [1]
            {"Fokus pada bagianmu saja, berharap dia bisa mengejar.", "Menyindir, 'Makanya, perhatiin dosennya.'", "Tawarkan bantuan, 'Ada bagian yang bingung? Kita bahas bareng yuk!'"},
            // Soal 2: Positif [0], Netral [2], Negatif [1]
            {"Memberi kode halus dengan gestur atau kata kunci.", "Langsung memotong dan melengkapi jawabannya.", "Diam saja, itu tanggung jawabnya."},
            // Soal 3: Positif [1], Netral [2], Negatif [0] (Ingat, positifnya adalah 'Menunggu', netralnya 'Pura-pura tidak lihat')
            {"Langsung samperin dan tanya 'Lagi ngomongin aku ya?'", "Menunggu sampai dia selesai, lalu bertanya baik-baik.", "Pura-pura tidak lihat dan pergi, tapi penasaran setengah mati."},
            // Soal 4: Positif [1], Netral [0], Negatif [2]
            {"'Ah, ini biasa aja kok.'", "'Makasih, kamu juga hebat tadi pas sesi tanya jawab!'", "Tidak merespons, hanya tersenyum canggung."},
            // Soal 5: Positif [2], Netral [1], Negatif [0]
            {"Mengabaikannya agar tidak terlihat terlalu agresif.", "Hanya melempar senyum dari kejauhan.", "Menyapa dan memulai obrolan ringan, 'Hai, sendirian aja?'"},
            // Soal 6: Positif [0], Netral [1], Negatif [2]
            {"'Nggak apa-apa, santai aja. Nanti aku bisa tulis ulang kok.'", "'Yah, lain kali hati-hati ya.'", "'Wah, gimana sih, ini catatan penting!'"},
            // Soal 7: Positif [1], Netral [0], Negatif [2]
            {"Hanya mengangguk singkat.", "Balas dengan senyuman hangat dan sapaan singkat.", "Membuang muka karena gugup."},
            // Soal 8: Positif [2], Netral [1], Negatif [0]
            {"'Sama dong, aku juga belum belajar.'", "'Semangat ya, kamu pasti bisa!'", "'Aku buatin rangkuman poin penting ya, semoga bantu!'"},
            // Soal 9: Positif [0], Netral [2], Negatif [1]
            {"Memberi ucapan selamat dengan hadiah kecil yang personal.", "Pura-pura tidak tahu.", "Hanya mengucapkan 'HBD' via chat."},
            // Soal 10: Positif [2], Netral [0], Negatif [1]
            {"Memotongnya jadi dua agar adil.", "Langsung mengambilnya tanpa basa-basi.", "Menawarkan potongan terakhir itu kepadanya."},
            // Soal 11: Positif [1], Netral [2], Negatif [0]
            {"Tidak berkomentar apa-apa.", "'Mau aku pesenin ojek online? Kamu kelihatan capek banget.'", "'Jangan lupa istirahat ya.'"},
            // Soal 12: Positif [0], Netral [2], Negatif [1] (Ingat, netralnya adalah 'Percaya dia tidak akan terpengaruh')
            {"Ajak bicara empat mata, 'Aku mau lurusin sesuatu, apa yang kamu dengar itu nggak bener.'", "Menyindir Tono di media sosial.", "Percaya dia tidak akan terpengaruh gosip."},
            // Soal 13: Positif [2], Netral [0], Negatif [1]
            {"'Oh ya? Aku belum pernah nonton.'", "'Aku kurang suka film genre itu.'", "'Wah, ceritain dong! Aku jadi penasaran pengen nonton.'"},
            // Soal 14: Positif [0], Netral [1], Negatif [2]
            {"'Kalau hujan gini, enaknya ngapain ya selain nunggu reda?'", "Membicarakan betapa derasnya hujan hari ini.", "Diam-diam meliriknya berharap dia memulai percakapan."},
            // Soal 15: Positif [1], Netral [2], Negatif [0]
            {"'Hmm, apa ya? Banyak sih... (tapi tidak menyebutkan satupun)'", "'Kamu itu pendengar yang baik dan tulus, aku nyaman cerita sama kamu.'", "'Kamu orangnya baik dan pintar.'"}
    };
    
    // Kunci jawaban BARU yang sudah disesuaikan dengan posisi acak di atas
    // Indeks jawaban sekarang menunjuk ke posisi baru yang benar.
    private int[] correctAnswers = {2, 0, 1, 1, 2, 0, 1, 2, 0, 2, 1, 0, 2, 0, 1}; 
    private int[] neutralAnswers = {0, 2, 2, 0, 1, 1, 0, 1, 2, 0, 2, 2, 0, 1, 2};
    private int[] wrongAnswers   = {1, 1, 0, 2, 0, 2, 2, 0, 1, 1, 0, 1, 1, 2, 0};

    // =======================================================================

    // Method untuk menampilkan pertanyaan
    public void displayQuestion(int questionIndex) {
        if (questionIndex < 0 || questionIndex >= questions.length) {
            System.out.println("Pertanyaan tidak tersedia!");
            return;
        }

        System.out.println("\n================================================ ");
        System.out.println("> Pertanyaan [ " + (questionIndex + 1) + "/" + questions.length + " ] ");
        System.out.println("================================================ ");
        System.out.println(questions[questionIndex]);
        System.out.println("------------------------------------------------ ");

        for (int i = 0; i < options[questionIndex].length; i++) {
            System.out.println((i + 1) + ". " + options[questionIndex][i]);
        }

        if (questionIndex > 4) {
            System.out.println("4. Berikan Surprise" + (surpriseCount > 0 ? " (" + surpriseCount + "x tersisa)" : " (Habis)"));
        }
        System.out.println("5. Menyerah/Keluar");
    }

    // Method untuk cek jawaban (sudah menggunakan aksiBerhasil/aksiGagal)
    public void checkAnswer(int questionIndex, int playerChoice) {
        if (questionIndex > 4 && playerChoice == 4) {
            if (surpriseCount > 0) {
                System.out.println("Kamu memberikan kejutan manis! +20 Reputasi");
                player.aksiBerhasil(20);
                surpriseCount--;
            } else {
                System.out.println("Kesempatan memberikan surprise sudah habis!");
            }
            return;
        }

        if (playerChoice == 5) {
            System.out.println("Kamu memilih menyerah. Permainan berakhir.");
            statusGame = false;
            return;
        }
        
        int choiceIndex = playerChoice - 1;

        if (choiceIndex == correctAnswers[questionIndex]) {
            System.out.println("Respons Sempurna! Reputasi +10, Gengsi Dia -15");
            player.aksiBerhasil(10);
            enemy.aksiGagal(15);
        } else if (choiceIndex == neutralAnswers[questionIndex]) {
            System.out.println("Jawaban Aman. Reputasi -5.");
            player.aksiGagal(5);
        } else {
            System.out.println("Jawaban Buruk! Reputasi -15, Gengsi Dia +5");
            player.aksiGagal(15);
            enemy.aksiBerhasil(5);
        }

        // Cek status game
        if (!player.statusHP()) {
            statusGame = false;
            System.out.println("Game Over! Reputasi Anda habis.");
        }

        if (player.getHP() >= enemy.getHarapan()) {
            statusGame = false;
            System.out.println("================================================ ");
            System.out.println(">       !!! C O N G R A T U L A T I O N S !!!      ");
            System.out.println("================================================ ");
            System.out.println("Reputasimu berhasil melampaui harapannya!");
            System.out.println("Permainan berakhir, Super Duper Good Ending!");
            System.out.println("================================================ ");
        }
    }

    public int getSurpriseCount() {
        return surpriseCount;
    }
    
    public boolean isGameActive() {
        return statusGame;
    }

    public int getTotalQuestions() {
        return questions.length;
    }
}
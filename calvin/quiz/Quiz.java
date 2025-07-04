package calvin.quiz;
import calvin.character.Character;
import calvin.enemy.Enemy;

public class Quiz {
    private Character player;
    private Enemy enemy;
    private boolean statusGame;
    private int surpriseCount = 3;

    // Constructor
    public Quiz(Character player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        this.statusGame = true;
    }


    // Pertanyaan
    private String[] questions = {
        "Di kantin kampus, Dia meminta izin duduk di sebelahmu. Apa responsmu?",
        "Dia lupa membawa laptop ke kelas. Apa yang kamu lakukan?",
        "Temanmu menyebarkan gosip bahwa kamu stalker IG Dia. Reaksimu?",
        "Dia posting story sedang bad mood. Apa tindakanmu?",
        "Kamu melihat Tono (rival) memberi hadiah ke Dia. Strategimu?",
        "Dia mengajakmu study bersama di perpustakaan. Persiapanmu?",
        "Di kafe, Dia bertanya 'Kamu sering perhatian banget ya ke aku?'. Jawabanmu?",
        "Kamu dapat info Dia suka novel romantis. Tindakanmu?",
        "Event kampus: Kamu menang lomba coding dan Dia hadir. Sikapmu?",
        "Dia tiba-tiba tidak membalas chat 3 hari. Apa yang kamu lakukan?",
        "Tono menghasut bahwa kamu hanya mendekati Dia karena ingin populer. Balasanmu?",
        "Hujan deras saat pulang kampus. Dia tidak bawa payung. Aksi kamu?",
        "Kamu menemukan Dia menangis di taman kampus. Pendekatanmu?",
        "Saat confession, Dia bertanya 'Kenapa kamu suka aku?'. Jawaban terbaikmu?",
        "Setelah ditolak, temanmu mengolok-olokmu. Reaksimu?"
    };

    // Opsi jawaban (format: [jawaban_betul, jawaban_gantung, jawaban_salah])
    private String[][] options = {
        // Soal 1
        {"Boleh, aku malah senang ada yang nemenin", "Ini tempatnya masih kosong kok", "Diam sambil gelagapan"},
        // Soal 2
        {"Aku ada spare charger, mau?", "Pinjem punyaku aja!", "Pura-pura tidak dengar"},
        // Soal 3
        {"Biarkan saja, gosip akan reda", "Bantah dengan bukti kamu tidak stalker", "Akui saja sambil bercanda"},
        // Soal 4
        {"Like story-nya saja", "Kirim DM tanya ada masalah apa", "Post meme lucu untuk hiburan"},
        // Soal 5
        {"Tunjukkan keahlianmu yang lebih unik", "Ikut memberi hadiah lebih mewah", "Acuh tak acuh"},
        // Soal 6
        {"Bawa buku favorit Dia dan snack", "Datang tepat waktu saja", "Batal dengan alasan sibuk"},
        // Soal 7
        {"Aku cuma ingin berteman baik", "Iya, soalnya aku suka sama kamu", "Haha, iya ya? Nggak sengaja"},
        // Soal 8
        {"Rekomendasikan novel bagus", "Belikan novel terbaru genre itu", "Pura-pura tidak tahu"},
        // Soal 9
        {"Berterima kasih padanya karena datang", "Ajak dia foto bersama piala", "Sombongkan kemenanganmu"},
        // Soal 10
        {"Tunggu saja sampai dia membalas", "Kirim pesan 'Aku khawatir'", "Spam chat tanya kenapa"},
        // Soal 11
        {"Tunjukkan bukti ketulusanmu ke Dia", "Tantang Tono berdebat", "Diam saja"},
        // Soal 12
        {"Tawarkan payung dan berteduh bersama", "Pinjamkan payung lalu pulang", "Pura-pura tidak melihat"},
        // Soal 13
        {"Dekati dan tanya masalahnya", "Kirim teman dekatnya untuk menolong", "Biarkan dia sendirian"},
        // Soal 14
        {"Aku suka caramu menghadapi masalah", "Karena kamu cantik dan populer", "Nggak tahu, tiba-tiba saja suka"},
        // Soal 15
        {"Jawab 'Setidaknya aku berani mencoba'", "Tertawa ikut mengolok diri sendiri", "Marah dan mengumpat"}
    };

    // Kunci jawaban (indeks jawaban betul/gantung/salah untuk setiap soal)
    private int[] correctAnswers  = {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}; // Index jawaban benar
    private int[] neutralAnswers  = {1, 0, 1, 1, 2, 1, 0, 1, 1, 1, 2, 1, 1, 2, 1}; // Index jawaban gantung
    private int[] wrongAnswers  = {2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2};  // Index jawaban salah


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
        
        // Tampilkan opsi normal (1-3)
        for (int i = 0; i < options[questionIndex].length; i++) {
            System.out.println((i + 1) + ". " + options[questionIndex][i]);
        }
        
        // Tampilkan opsi tambahan (4-5)
        if (questionIndex > 4) {
            System.out.println("4. Berikan Surprise" + (surpriseCount > 0 ? " (" + surpriseCount + "x tersisa)" : " (Habis)"));
        }
        System.out.println("5. Menyerah/Keluar");
    }


    // Method untuk cek jawaban
    public void checkAnswer(int questionIndex, int playerChoice) {
        if (questionIndex > 4 ) {
            if (playerChoice == 4) { // Opsi Surprise
                if (surpriseCount > 0) {
                    System.out.println("Kamu memberikan kejutan manis! +20 Reputasi");
                    player.stepSuccess(20);
                    surpriseCount--;
                } else {
                    System.out.println("Kesempatan memberikan surprise sudah habis!");
                }
                return;
            }
        }
        
        if (playerChoice == 5) { // Opsi Menyerah
            System.out.println("Kamu memilih menyerah. Permainan berakhir.");
            statusGame = false;
            return;
        }
        int choiceIndex = playerChoice - 1; // Konversi ke 0-based index
        
        if (choiceIndex == correctAnswers[questionIndex]) {
            System.out.println("Benar! +5 Reputasi");
            player.stepSuccess(5);
            enemy.stepFailed(17);
        } 
        else if (choiceIndex == neutralAnswers[questionIndex]) {
            System.out.println("Gantung anjir. -8 Reputasi");
            player.stepFailed(8);
            enemy.stepSuccess(3);
        } 
        else {
            System.out.println("Salah! -19 Reputasi");
            player.stepFailed(19);
            enemy.stepSuccess(6);

        } 
        
        // ============== GAME OVER KARNA KEJADIAN KHUSUS ===============
        // Update status game
        if (!player.statusHP()) {
            statusGame = false;
            System.out.println("Game Over! Reputasi Anda habis.");
        }

        if (player.getHP() >= enemy.getHarapan()) {
            statusGame = false;
            System.out.println("================================================ ");
            System.out.println(">           ! ! !      BOOOM     ! ! !           ");
            System.out.println("================================================ ");
            System.out.println("Kamu sesuai dengan harapan dia, Dia sangat menyukaimu!");
            System.out.println("Permainan berakhir, Super Duper Good Ending!");
            System.out.println("================================================ ");
        }
    }

    // Tambahkan getter untuk surprise count
    public int getSurpriseCount() {
        return surpriseCount;
    }
    
    // Getter untuk status game
    public boolean isGameActive() {
        return statusGame;
    }
    
    // Getter jumlah pertanyaan
    public int getTotalQuestions() {
        return questions.length;
    }
}
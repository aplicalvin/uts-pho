package calvin.quiz;
import calvin.character.Character;
import calvin.enemy.Enemy;

public class Quiz {
    private Character player;
    private Enemy enemy;
    private boolean statusGame;

    // Constructor
    public Quiz(Character player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        this.statusGame = true;
    }


    // Pertanyaan
    private String[] questions = {
        "Di kantin kampus, Lina meminta izin duduk di sebelahmu. Apa responsmu?",
        "Lina lupa membawa laptop ke kelas. Apa yang kamu lakukan?",
        "Temanmu menyebarkan gosip bahwa kamu stalker IG Lina. Reaksimu?",
        "Lina posting story sedang bad mood. Apa tindakanmu?",
        "Kamu melihat Tono (rival) memberi hadiah ke Lina. Strategimu?",
        "Lina mengajakmu study bersama di perpustakaan. Persiapanmu?",
        "Di kafe, Lina bertanya 'Kamu sering perhatian banget ya ke aku?'. Jawabanmu?",
        "Kamu dapat info Lina suka novel romantis. Tindakanmu?",
        "Event kampus: Kamu menang lomba coding dan Lina hadir. Sikapmu?",
        "Lina tiba-tiba tidak membalas chat 3 hari. Apa yang kamu lakukan?",
        "Tono menghasut bahwa kamu hanya mendekati Lina karena ingin populer. Balasanmu?",
        "Hujan deras saat pulang kampus. Lina tidak bawa payung. Aksi kamu?",
        "Kamu menemukan Lina menangis di taman kampus. Pendekatanmu?",
        "Saat confession, Lina bertanya 'Kenapa kamu suka aku?'. Jawaban terbaikmu?",
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
        {"Bawa buku favorit Lina dan snack", "Datang tepat waktu saja", "Batal dengan alasan sibuk"},
        // Soal 7
        {"Aku cuma ingin berteman baik", "Iya, soalnya aku suka sama kamu", "Haha, iya ya? Nggak sengaja"},
        // Soal 8
        {"Rekomendasikan novel bagus", "Belikan novel terbaru genre itu", "Pura-pura tidak tahu"},
        // Soal 9
        {"Berterima kasih padanya karena datang", "Ajak dia foto bersama piala", "Sombongkan kemenanganmu"},
        // Soal 10
        {"Tunggu saja sampai dia membalas", "Kirim pesan 'Aku khawatir'", "Spam chat tanya kenapa"},
        // Soal 11
        {"Tunjukkan bukti ketulusanmu ke Lina", "Tantang Tono berdebat", "Diam saja"},
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
        
        System.out.println("\nPertanyaan " + (questionIndex + 1) + "/" + questions.length);
        System.out.println(questions[questionIndex]);
        
        for (int i = 0; i < options[questionIndex].length; i++) {
            System.out.println((i + 1) + ". " + options[questionIndex][i]);
        }
    }

    // Method untuk cek jawaban
    public void checkAnswer(int questionIndex, int playerChoice) {
        if (questionIndex < 0 || questionIndex >= questions.length) return;
        
        // Validasi input
        if (playerChoice < 1 || playerChoice > 3) {
            System.out.println("Pilihan tidak valid!");
            return;
        }

        int choiceIndex = playerChoice - 1; // Konversi ke 0-based index
        
        if (choiceIndex == correctAnswers[questionIndex]) {
            System.out.println("Benar! +5 Reputasi");
            player.stepSuccess(5);
            enemy.stepFailed(17);
        } 
        else if (choiceIndex == neutralAnswers[questionIndex]) {
            System.out.println("Gantung anjir. -10 Reputasi");
            player.stepFailed(8);
            enemy.stepSuccess(3);
        } 
        else {
            System.out.println("Salah! -20 Reputasi");
            player.stepFailed(19);
            enemy.stepSuccess(6);

        }
        
        // Update status game
        if (!player.statusHP()) {
            statusGame = false;
            System.out.println("Game Over! Reputasi Anda habis.");
        }
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
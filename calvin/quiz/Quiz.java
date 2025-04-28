package calvin.quiz;
import calvin.character;
import calvin.enemy;

class Quiz {
    protected boolean statusGame;

    // Pertanyaan
    private String[] question = {
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
    private int[] jawabanBetul = {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}; // Index jawaban benar
    private int[] jawabanGantung = {1, 0, 1, 1, 2, 1, 0, 1, 1, 1, 2, 1, 1, 2, 1}; // Index jawaban gantung
    private int[] jawabanSalah = {2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2};  // Index jawaban salah


    // Mekanisme looping soal
    public void displayQuestion(int questionIndex) {
        System.out.println("Pertanyaan ke-" + questionIndex);
        System.out.println(question[questionIndex]);

        for (int i = 0; i < 3; i++) {
            System.out.println(options[questionIndex][i]);
        }
    }

    // Mekanisme cek jawaban
    public void checkAnswer(int questionIndex, int playerChoice) {
        if (playerChoice == jawabanBetul[questionIndex]) {
            System.out.println("Benar! +Reputasi");
            player.tambahReputasi(3);
        } 
        else if (playerChoice == jawabanGantung[questionIndex]) {
            System.out.println("Netral. +Sedikit Reputasi");
            player.tambahReputasi(1);
        } 
        else {
            System.out.println("Salah! -Reputasi");
            player.kurangReputasi(2);
        }
    }
        
}
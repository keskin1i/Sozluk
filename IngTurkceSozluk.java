import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IngTurkceSozluk {

    public static void main(String[] args) {
        Map<String, String> sozluk = new HashMap<>();

        // Dosyadan verileri oku ve sözlüğe ekleyelim
        try (BufferedReader br = new BufferedReader(new FileReader("sozluk.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    sozluk.put(parts[0].toLowerCase(), parts[1].toLowerCase());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Kullanıcıdan İngilizce kelimeyi aldık
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("İngilizce kelime girin (Çıkmak için 'exit' yazın): ");
            String kelime = scanner.nextLine().toLowerCase();
            if (kelime.equals("e")) {
                break;
            }

            // Sözlükte kelimenin karşılığını buluyoruz
            String ceviri = sozluk.get(kelime);
            if (ceviri != null) {
                System.out.println(kelime + " = " + ceviri);
            } else {
                System.out.println("Bu kelimenin çevirisi bulunamadı.");
            }
        }
    }
}

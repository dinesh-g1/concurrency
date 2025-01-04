import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class FileDriver {
    private static int count = 25;
    public static void main(String[] args) throws IOException {
        List<String> urls = new ArrayList<>();
        String path = "/Users/pavankaareddy/dinesh/dailydownload.txt";
        BufferedReader bf = new BufferedReader(new FileReader(path));
        while (bf.ready()) {
            String url = bf.readLine();
            urls.add(url);
        }
        bf.close();
        for (int i = 0; i < urls.size(); i++) {
            String url = urls.get(i);
            String[] parts = url.split("Link: ");
            if (parts.length == 2) {
                urls.set(i, parts[1]);
            }
        }
        List<String> uniqueUrls = new ArrayList<>();
        for (String u : urls) {
            if (!u.isEmpty()) {
                uniqueUrls.add(u);
            }
        }
        try {
            openUrls(uniqueUrls);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void openUrls(List<String> urls) throws URISyntaxException, IOException, InterruptedException {
        Desktop desktop = Desktop.getDesktop();
        for (String url : urls) {
            if (count == 0)
                break;
            desktop.browse(new URI(url));
            Thread.sleep(10000);
            count--;
        }
    }
}

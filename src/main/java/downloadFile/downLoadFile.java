package downloadFile;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class downLoadFile {

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();


    public static String sendGet(String url) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .setHeader("User-Agent",
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36")
                .build();
        Charset gbkSet = Charset.forName("GBK");
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString(gbkSet));
        return response.body();
    }

    public static void main(String[] args) throws Exception {
//        https://search.7881.com/G10-100001-G10P010-G10P010003-0.html

//        SendRequest sendRequest = new SendRequest();

        String s = sendGet("http://stock.gtimg.cn/data/index.php?appn=detail&action=download&c=sh603986&d=20200323");
        ArrayList<String[]> a = (ArrayList<String[]>) Stream.of(s.split("\n"))
                .map(e -> e.split("\t")).collect(Collectors.toList());


        ArrayList<Quote> aq = new ArrayList<>();
        for (String[] b : a) {
            Quote q = new Quote();
            q.setTime(b[0]);
            q.setPrice(b[1]);
            q.setVolatility(b[2]);
            q.setVolume(b[3]);
            q.setAmount(b[4]);
            q.setBuyOrSell(b[5]);
            aq.add(q);
        }

        System.out.println(aq);


    }
}



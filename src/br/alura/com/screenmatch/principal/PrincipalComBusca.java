package br.alura.com.screenmatch.principal;

import br.alura.com.screenmatch.exception.ConversionYearAndRuntimeError;
import br.alura.com.screenmatch.models.Title;
import br.alura.com.screenmatch.models.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.GsonBuildConfig;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException, IllegalArgumentException {
        Scanner input = new Scanner(System.in);
        String search = "";
        List<Title> titles = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
        while (!search.equalsIgnoreCase("sair")){

            System.out.println("Digite o nome de um filme para a busca ou 'sair' para finalizar: ");
            search = input.nextLine();

            if (search.equalsIgnoreCase("sair")){
                break;
            }
            String address = "https://www.omdbapi.com/?t=" +
                    URLEncoder.encode(search,
                                      StandardCharsets.UTF_8) + "&apikey=55b8876c";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(address))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                System.out.println(json);
                TitleOmdb myTitleOmdb = gson.fromJson(json, TitleOmdb.class);
                System.out.println(myTitleOmdb);
                Title myTitle = new Title(myTitleOmdb);
                System.out.println("## Título já convertido ##");
                System.out.println(myTitle);

                titles.add(myTitle);

            } catch (ConversionYearAndRuntimeError e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titles);
        FileWriter writer = new FileWriter("titles.json");
        writer.write(gson.toJson(titles));
        writer.close();
        System.out.println("Programa finalizou corretamente.");
    }
}

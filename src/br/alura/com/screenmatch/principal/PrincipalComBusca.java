package br.alura.com.screenmatch.principal;

import br.alura.com.screenmatch.models.Title;
import br.alura.com.screenmatch.models.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.GsonBuildConfig;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome de um filme para a busca: ");
        var search = input.nextLine();
        String address = "https://www.omdbapi.com/?t=" + search + "&apikey=55b8876c";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        System.out.println(json);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        TitleOmdb myTitleOmdb = gson.fromJson(json, TitleOmdb.class);
        System.out.println(myTitleOmdb);
        Title myTitle = new Title(myTitleOmdb);
        System.out.println("## Título já convertido ##");
        System.out.println(myTitle);
    }
}

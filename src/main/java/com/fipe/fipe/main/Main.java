package com.fipe.fipe.main;

import com.fipe.fipe.model.DataModel;
import com.fipe.fipe.model.Data;
import com.fipe.fipe.service.ConsumeApi;
import com.fipe.fipe.service.ConvertData;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    private Scanner sc = new Scanner(System.in);

    private ConvertData convertData = new ConvertData();

    private final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/";

    private ConsumeApi consumeApi;

    public void showMenu(){
        String menu = """
                ***OPÇÕES***
                Carro
                Caminhão
                Moto                               
                """;

        System.out.println(menu);

        System.out.println("Digite a opção que você deseja");
        String option = sc.next().toLowerCase();

        String json = ConsumeApi.consumeApi(BASE_URL + option + "/marcas");
        List<Data> datas = convertData.obterLista(json, Data.class);
        datas.stream()
                .sorted(Comparator.comparing(Data::code))
                .forEach(System.out::println);

        System.out.print("Digite o código da marca que você deseja: ");
        String code = sc.next();
        json = ConsumeApi.consumeApi(BASE_URL + option + "/marcas/" + code + "/modelos");
        System.out.println(json);
        var models = convertData.getDatas(json, DataModel.class);
        System.out.println(models);
        models.models().stream()
                .sorted(Comparator.comparing(Data::code))
                .forEach(System.out::println);

        sc.close();
    }
}

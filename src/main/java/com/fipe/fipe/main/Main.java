package com.fipe.fipe.main;

import com.fipe.fipe.model.DataModel;
import com.fipe.fipe.model.Data;
import com.fipe.fipe.model.DataVehicles;
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
        try{
            String menu = """
                ***OPÇÕES***
                Carro
                Caminhão
                Moto                               
                """;

            System.out.println(menu);

            System.out.println("Digite a opção que você deseja");
            String option = sc.next().toLowerCase();

            if(option.toLowerCase().contains("car")){
                option = "carros";
            }else if(option.toLowerCase().contains("caminh")){
                option = "caminhoes";
            }else if(option.toLowerCase().contains("moto")){
                option = "motos";
            }else{
                System.out.println("Opção inválida");
            }


            String address = BASE_URL + option + "/marcas";
            String response = ConsumeApi.consumeApi(address);
            List<Data> datas = convertData.obterLista(response, Data.class);
            datas.stream()
                    .sorted(Comparator.comparing(Data::code))
                    .forEach(System.out::println);

            System.out.print("Digite o código da marca que você deseja: ");
            String code = sc.next();
            address = address + "/" + code + "/modelos";
            response =ConsumeApi.consumeApi(address);
            var models = convertData.getDatas(response, DataModel.class);
            models.models().stream()
                    .sorted(Comparator.comparing(Data::code))
                    .forEach(System.out::println);

            System.out.print("Digite o código do modelo desejado: ");
            String newCode = sc.next();
            address = address + "/" + newCode + "/anos";
            response = ConsumeApi.consumeApi(address);
            List<Data> modelsData = convertData.obterLista(response, Data.class);
            modelsData.stream().sorted(Comparator.comparing(Data::code)).forEach(System.out::println);

            System.out.print("Digite o código do ano desejado: ");
            String yearCode = sc.next();
            address = address + "/" + yearCode;
            response = ConsumeApi.consumeApi(address);
            DataVehicles vehicles = convertData.getDatas(response, DataVehicles.class);
        }
        catch (RuntimeException e){
            throw  new RuntimeException(e.getMessage());
        }
        finally {
            sc.close();
        }

        System.exit(0);
    }
}

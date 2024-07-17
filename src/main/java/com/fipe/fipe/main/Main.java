package com.fipe.fipe.main;

import com.fipe.fipe.service.ConsumeApi;

import java.util.Scanner;

public class Main {

    private Scanner sc = new Scanner(System.in);

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
        String option = sc.next().toUpperCase();

        switch (option){
            case "CARRO":
                System.out.println("Digitou carro");
                String json = ConsumeApi.consumeApi("https://parallelum.com.br/fipe/api/v1/carros/marcas");
                System.out.println(json);
                break;
            case "CAMINHÃO":
                System.out.println("Digitou caminhão");
                break;
            case "MOTO":
                System.out.println("Digitou moto");
                break;
            default:
                System.out.println("Digite uma opção válida");
        }

        sc.close();
    }
}

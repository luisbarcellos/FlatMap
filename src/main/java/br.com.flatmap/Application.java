package br.com.flatmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.addListeners(new ApplicationPidFileWriter());
        springApplication.run(args);

        run();
    }

    private static void run(){
        Carro carro = new Carro();
        carro.setModelo("astra");
        carro.addProprietario("Rogério dos Santos");
        carro.addProprietario("Vanessa da Rosa");
        carro.addProprietario("Roberto Silva");

        Carro carro2 = new Carro();
        carro2.setModelo("vectra");
        carro2.addProprietario("Roberto Silva");
        carro2.addProprietario("André Moraes");
        carro2.addProprietario("Umberto da Rocha");

        List<Carro> carroList = new ArrayList<>(Arrays.asList(carro, carro2));

        List<String> collect = carroList.stream()
                .map(carroMap -> carroMap.getProprietario())
                .flatMap(carroMap -> carroMap.stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("\n\n##############################################################");
        collect.forEach(System.out::println);
        System.out.println("##############################################################\n\n");
    }
}
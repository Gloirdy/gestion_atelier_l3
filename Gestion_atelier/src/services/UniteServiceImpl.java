package services;

import java.util.ArrayList;
import java.util.Scanner;


import entities.Unite;
import repositories.List.TableUnites;

public class UniteServiceImpl implements UniteService {
    private TableUnites unitesRepository=new TableUnites();

    @Override
    public int add(Unite unite) {
        // TODO Auto-generated method stub
        return unitesRepository.insert(unite);
    }

    @Override
    public ArrayList<Unite> getAll() {
        // TODO Auto-generated method stub
        return unitesRepository.findAll();
    }

    @Override
    public int remove(int id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int[] remove(int[] ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Unite show(int id) {
        return unitesRepository.findById(id);
    }
    

    @Override
    public int update(Unite data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(int id, String lib) {
        // TODO Auto-generated method stub
        return 0;
    }

    public Unite selectUnite(Scanner scanner) {
    getAll().forEach(System.out::println);
    System.out.println("ID d'une unité :");
    int uniteId = scanner.nextInt();
    scanner.nextLine();
    return show(uniteId);
}







}

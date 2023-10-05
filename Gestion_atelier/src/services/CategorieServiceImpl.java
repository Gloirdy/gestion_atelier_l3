

package services;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Categorie;

import repositories.List.TableCategories;

public class CategorieServiceImpl implements CategorieService {

    //Couplage fort
    private TableCategories categoriesRepository=new TableCategories(); // la couche service cree un objet de type categorie
    
    
    @Override
    public int add(Categorie categorie) {
       return categoriesRepository.insert(categorie);
    }
    

    @Override
    public ArrayList<Categorie> getAll() {
        // TODO Auto-generated method stub
        return categoriesRepository.findAll();
    }

    @Override
    public int update(int id, String lib) {
        Categorie cat = categoriesRepository.findById(id);
        cat.setLibelle(lib);
        return categoriesRepository.update(cat);  
    }

    @Override
    public int update(Categorie categorie) {
         return categoriesRepository.update(categorie);
       
    }

    @Override
    public Categorie show(int id) {
        return categoriesRepository.findById(id);
    }

    @Override
    public int remove(int id) {
       return categoriesRepository.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        int[] idsNotDelete=new int[ids.length];
        int nbre=0;
          for (int id = 0; id < ids.length; id++) {
              if (categoriesRepository.delete(id)==0) {
                idsNotDelete[nbre++]=id;

              }
          }
          return idsNotDelete;
    }
    
    public boolean isUniqueLibelle(String libelle) {
        ArrayList<Categorie> categories = getAll(); 
        for (Categorie categorie : categories) {
            if (categorie.getLibelle().equals(libelle)) {
                return false; 
            }
        }
    
        return true; 
    }

    public Categorie selectCategorie(Scanner scanner) {
    getAll().forEach(System.out::println);
    System.out.println("ID  catégorie :");
    int catId = scanner.nextInt();
    scanner.nextLine();
    return show(catId);
}

}









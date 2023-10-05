import java.util.ArrayList;
import java.util.Scanner;

import entities.ArticleConfection;
import entities.Categorie;
import entities.Unite;
import services.ArticleConfectionServiceImpl;
import services.CategorieServiceImpl;
import services.UniteServiceImpl;


public class App {
    public static void main(String[] args) throws Exception {
        CategorieServiceImpl categorieServiceImpl =new CategorieServiceImpl();
        ArticleConfectionServiceImpl articleConfectionServiceImpl =new ArticleConfectionServiceImpl();
        UniteServiceImpl uniteServiceImpl = new UniteServiceImpl();
        int choix;
        Scanner scanner =new Scanner(System.in);
        do {
            System.out.println("***********************");
            System.out.println("*** MENU PRINCIPAL ****");
            System.out.println("***********************");
            System.out.println("1 --> Catégories");
            System.out.println("2 --> Articles de Confection");
            System.out.println("3 --> Quitter");
            choix = scanner.nextInt();
            scanner.nextLine(); 
            clearTerminal();
        switch (choix) {
            
            case 1:
                int choixCategorie;
                do {
                    
                    System.out.println("=== Menu des Catégories ===");
                    System.out.println("1- Ajouter  Catégorie");
                    System.out.println("2- Lister  Catégories");
                    System.out.println("3- Modifier  Catégorie");
                    System.out.println("4- Editer  Catégorie");
                    System.out.println("5- Supprimer  Catégorie");
                    System.out.println("6- Supprimer plusieurs Catégories");
                    System.out.println("7- Retour menu Principal");
                    choixCategorie = scanner.nextInt();
                    scanner.nextLine(); 
                    clearTerminal();

                    switch (choixCategorie) {
                        case 1:
                            boolean libUnique;
                            do{

                                System.out.println("Veuillez entrez le libelle");
                                String lib = scanner.nextLine();
                                libUnique = categorieServiceImpl.isUniqueLibelle(lib);
                                if (categorieServiceImpl.isUniqueLibelle(lib)) {
                                    Categorie categorie =new Categorie(lib);
                                    categorieServiceImpl.add(categorie);
                                    System.out.println("Catégorie ajoutée ");
                                } else {
                                    System.out.println("'" + lib + "' existe déjà. Entrez encore.");
                                } 
                            }while(!libUnique) ;  
                        break;

                        case 2:
                            System.out.println("Liste des categories");
                            categorieServiceImpl.getAll().forEach(System.out::println);
                        break;
                            
                        
                        case 4:
                            System.out.println("Id de la Categorie");
                            scanner.nextInt();
                            scanner.nextLine();
                            categorieServiceImpl.show(scanner.nextInt()); 
                             
                        break;

                        case 5:
                            categorieServiceImpl.getAll().forEach(System.out::println);
                            System.out.println("Id de la categorie a supprimer");
                            categorieServiceImpl.remove(scanner.nextInt()); 
                        break;

                        case 6:
                            System.out.println("Nombre de categorie à supprimer");
                            int idD=scanner.nextInt();
                            if(idD<= 0){
                                System.out.println("Nombre Invalide"); 
                            }
                            else{
                                for (int i = 0; i < idD; i++) {
                                    System.out.println("Saisissez l'ID de la catégorie " + (i + 1) + " :");
                                    int categoryId = scanner.nextInt();
                                    scanner.nextLine();
                                    categorieServiceImpl.remove(categoryId);
                                }
                            }
                        break;
                        default:
                        break;
                    }
                } while (choixCategorie != 7);
            break;

            case 2: 
                int choixArticle;
                do {
                    System.out.println("=== Menu des Articles de Confection ===");
                    System.out.println("1- Ajouter  Unite");
                    System.out.println("2- Ajouter  Article de Confection");
                    System.out.println("3- Lister Articles de Confection");
                    System.out.println("4- Modifier  Article de Confection");
                    System.out.println("5- editer Article de Confection");
                    System.out.println("6- Supprimer  Articles de Confection");
                    System.out.println("7- Supprimer plusieurs Articles de Confection");
                    System.out.println("8- Retour  menu Principal");
                    choixArticle = scanner.nextInt();
                    scanner.nextLine();
                    clearTerminal();
                    switch (choixArticle) {
                        case 1:
                            System.out.println("Veuillez entrez le libelle");
                            String libUnite = scanner.nextLine();
                            Unite unite =new Unite(libUnite);
                            uniteServiceImpl.add(unite);
                            break;
                        
                        case 2:
                            Categorie choixCat = categorieServiceImpl.selectCategorie(scanner);
                            if(choixCat==null){
                                System.out.println("Catégorie introuvable");
                            }
                            Unite choixUnite = uniteServiceImpl.selectUnite(scanner);
                            if(choixUnite==null){
                                System.out.println("Unite introuvable");
                            }

                            System.out.println("libellé de l'article de confection :");
                            String libArt = scanner.nextLine();

                            System.out.println(" prix de l'article de confection :");
                            double prixArt = scanner.nextDouble();

                            System.out.println("quantité de l'article de confection :");
                            double qteArt = scanner.nextDouble();

                            ArticleConfection article = new ArticleConfection(libArt, prixArt, qteArt);
                            article.setCategorie(choixCat);
                            article.getUnites().add(choixUnite);

                            int ArtT = articleConfectionServiceImpl.add(article);
                            if (ArtT > 0) {
                                System.out.println("Article ajouté avec l'ID : " + ArtT);
                            } else {
                                System.out.println("Erreur lors de l'ajout de l'article.");
                            }

                        break;

                        case 3:
                            System.out.println("Liste des articles");
                            System.out.println("Test");

                            articleConfectionServiceImpl.getAll().forEach(System.out::println);

                        break;

                        case 4:
                        
                        break;

                        case 5:
                        break;

                        case 6:
                        break;

                        case 7:
                        break;

                        default:
                            break;
                    }
                }while(choixArticle!=8); 
            break;

            default:
                break;
        }
        
        
        }while(choix!=3);
    
    scanner.close();
    }

    public static void clearTerminal(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}


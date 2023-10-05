package services;

import java.util.ArrayList;

import entities.ArticleConfection;

import repositories.List.TableArticleConfections;


//



public class ArticleConfectionServiceImpl implements  ArticleConfectionService {
//Couplage fort
    private TableArticleConfections articleConfectionsRepository=new TableArticleConfections();

    
   
    
    @Override
    public int add(ArticleConfection articleConfection) {
       return articleConfectionsRepository.insert(articleConfection);
    }
    

    @Override
    public ArrayList<ArticleConfection> getAll() {
        // TODO Auto-generated method stub
        return articleConfectionsRepository.findAll();
    }

    @Override
    public int update(ArticleConfection articleConfection) {
         return articleConfectionsRepository.update(articleConfection);
       
    }

    @Override
    public ArticleConfection show(int id) {
        return articleConfectionsRepository.findById(id);
    }

    @Override
    public int remove(int id) {
       return articleConfectionsRepository.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        int[] idsNotDelete=new int[ids.length];
        int nbre=0;
          for (int id = 0; id < ids.length; id++) {
              if (articleConfectionsRepository.delete(id)==0) {
                idsNotDelete[nbre++]=id;

              }
          }
          return idsNotDelete;
    }


    @Override
    public int update(int id, String lib) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    
    
    
    
    
}

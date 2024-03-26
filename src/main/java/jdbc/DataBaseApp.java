package jdbc;

import jdbc.models.Brewer;
import jdbc.models.Category;
import jdbc.repositories.BeerRepository;
import jdbc.repositories.BrewerRepository;
import jdbc.repositories.CategoryRepository;

public class DataBaseApp {
    public static void main(String[] args) {
        CategoryRepository categoryRepository = new CategoryRepository();
        //categoryRepository.create("Polska Pivo");
        //categoryRepository.read();
        //categoryRepository.update("Kurwa Pivo", 67);
        categoryRepository.delete(67);

        BrewerRepository brewerRepository = new BrewerRepository();
        //brewerRepository.create("Artois","Vaartstraat 94",3000,"Leuven",4000000);
        //brewerRepository.read();
        //brewerRepository.update("Viking beer","Nostraat 94",3000,"Leuven",4000000, 127);
        //brewerRepository.delete(127);

        BeerRepository beerRepository = new BeerRepository();
        //beerRepository.create("Alcoholic pivo",100,14,2.75f,200,7,0, null);
        //beerRepository.read();
        //beerRepository.update("super Alcoholic pivo",100,14,2.75f,200,7,0, null, 1560);
        //beerRepository.delete(1560);
    }
}

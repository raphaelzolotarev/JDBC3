package jdbc;

import jdbc.models.Brewer;
import jdbc.models.Category;
import jdbc.repositories.BeerRepository;
import jdbc.repositories.BrewerRepository;
import jdbc.repositories.CategoryRepository;

public class DataBaseApp {
    public static void main(String[] args) {
        CategoryRepository categoryRepository = new CategoryRepository();
        categoryRepository.read();
        categoryRepository.update();
        categoryRepository.delete();

        BrewerRepository brewerRepository = new BrewerRepository();
        brewerRepository.read();
        brewerRepository.update();
        brewerRepository.delete();

        BeerRepository beerRepository = new BeerRepository();
        beerRepository.read();
        beerRepository.update();
        beerRepository.delete();
    }
}

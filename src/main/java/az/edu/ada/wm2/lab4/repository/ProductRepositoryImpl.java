package az.edu.ada.wm2.lab4.repository;

import az.edu.ada.wm2.lab4.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    /*    Use Map<UUID, Product> for in-memory storage (HashMap)
    In save() method auto-generate UUID if null, then store in the map
    findById() must return Optional<Product>
    findAll() returns a new ArrayList of values
    deleteById() removes from the map
    existsById() checks if the map contains the key
*/

    Map<UUID, Product> storage = new HashMap<>();

    public Product save(Product product){
        if(product.getId() == null){
            product.setId(UUID.randomUUID());
        }
        storage.put(product.getId(), product);
        return product;
    }
    @Override
    public Optional<Product> findById(UUID id){
        return Optional.ofNullable(storage.get(id));
    }
    @Override
    public ArrayList<Product> findAll(){
        return new ArrayList<>(storage.values());
    }
    @Override
    public void deleteById(UUID id) {
        storage.remove(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return storage.containsKey(id);
    }


}

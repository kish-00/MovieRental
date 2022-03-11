package com.movies.app.Controller.Service;

import com.movies.app.Controller.Exception.ResourceNotFoundException;
import com.movies.app.Controller.Model.Store;
import com.movies.app.Controller.Repository.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    private final StoreRepo storeRepo;

    @Autowired
    public StoreService(StoreRepo storeRepo) {
        this.storeRepo = storeRepo;
    }

    //creates a store
    public Store addStore(Store store){
        return storeRepo.save(store);
    }

    //read a list of all the stores
    public List<Store> getAllStore(){
        return storeRepo.findAll();
    }

    //reads a store by its id
    public Store getStoreById(int id){
        return storeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Store with id "+id+" does not exit."));
    }

    //update Store
    public Store updateStore(int id, Store storeInfo){
        Store store=storeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Store with id:" + id+" does not exist."));

        store.setLastUpdated(storeInfo.getLastUpdated());

        return storeRepo.save(store);
    }

    // delete store
    public  String deleteStore(int id){
        Store store=storeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Store with id:" + id+" does not exist."));
        storeRepo.delete(store);
        return "Store id "+id+" has been deleted!";
    }
}

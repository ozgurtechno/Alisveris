package service;

import database.Database;
import entity.Item;
import exception.ItemNotFoundException;

import java.util.List;

public class ItemServiceImp implements ItemService{

    @Override
    public List<Item> getAllItems() {
        return Database.items;
    }

    @Override
    public Item getItemById(int id) throws ItemNotFoundException {
        for (Item item : Database.items){
            if (item.getId() == id){
                return item;
            }
        }
        throw new ItemNotFoundException("Boyle bir urun stoklarimizda mevcut degildir");
    }

    @Override
    public void addItem(Item item) {
        Database.items.add(item);
    }

    @Override
    public void deleteItemById(int id) throws ItemNotFoundException {
        for (Item item : Database.items){
            if (item.getId() == id){
                Database.items.remove(item);
            }
        }
        throw new ItemNotFoundException("Boyle bir urun stoklarimizda mevcut degildir");
    }

    @Override
    public void updateItem(Item item) {
        int itemIndex = 0;
        for (Item it : Database.items){
            if (it.getId() == item.getId()){
                Database.items.remove(item);
                break;
            }
            itemIndex++;
        }
        Database.items.add(itemIndex, item);
    }
}

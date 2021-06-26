package ru.netology.repository;

import ru.netology.domain.Product;
import ru.netology.exception.NonFoundException;

import java.util.ArrayList;

public class ProductRepository<T extends Product> {

  private ArrayList<T> storage = new ArrayList<>();

  public void save(T item) {
    if (item != null && findById(item.getId()) == null) {
      storage.add(item);
    }
  }

  public T findById(int id) {
    for (T item : storage) {
      if (item.getId() == id) {
        return item;
      }
    }
    return null;
  }

  public void removeById(int id) throws NonFoundException {
    T item = findById(id);
    if (item != null) {
      storage.remove(item);
    } else {
      throw new NonFoundException("Object with id " + id + " not found.");
    }
  }

  public ArrayList<T> getStorage() {
    return storage;
  }

}

package controller;

public interface General<T> {
    int searchProductById(String id);
    void add(T t);
    void edit(int index, T t);
    void remove(int index);
    void save();
    void read();
}

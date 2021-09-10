package controller;

import model.peson.Person;

import java.io.*;
import java.util.ArrayList;

import static view.Constant.*;

public class PersonManagement implements General<Person>{
    private ArrayList<Person> people = new ArrayList<>();


    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    @Override
    public int searchProductById(String id) {
        return 0;
    }

    public int searchPersonByName(String nameRemove) {
        int index = -1;
        for (int i = 0; i < people.size(); i++) {
            String name = people.get(i).getAccount().getName();
            if (name.equals(nameRemove)) {
                index = i;
                break;
            }
        }
        return index;
    }


    @Override
    public void add(Person person) {
        people.add(person);
    }

    @Override
    public void edit(int index, Person person) {

    }

    @Override
    public void remove(int index) {
        people.remove(index);
    }

    @Override
    public void save() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PERSON_DATA);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(people);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void read() {
        try {
            FileInputStream fileInputStream = new FileInputStream(PERSON_DATA);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            people = (ArrayList<Person>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Không có dữ liệu");
            people = new ArrayList<>();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

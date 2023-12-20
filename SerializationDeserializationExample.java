package com.core_java.serialization_deserialization;

import java.io.*;

/**
 ======================================================
 Explanation Of Serialization & Deserialization 
 ======================================================
 => Serialization in Java is the process of converting an object's state into a byte stream, and Deserialization is
    the process of reconstructing the object from that byte stream.
 => This allows you to save the state of an object to a file, send it over a network, or store it in a database.
 => Java provides built-in mechanisms for serialization and deserialization through the Serializable interface and
    the ObjectOutputStream and ObjectInputStream classes
 */

class Person implements Serializable{
    private static final long serialVersionUID = 1L; // Ensure version compatibility
    private String name;
    private int age;
    public Person(String name,int age){
        this.name = name ;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}

public class SerializationDeserializationExample {
    public static void main(String[] args) {
        // Serialize an object
        serializeObject();
        // Deserialize an object
        Person deserializedPerson = deserializeObject();
        // Display the deserialized object
        System.out.println("Deserialized Person: " + deserializedPerson);

        serializeObject1();
        System.out.println("Deserialized Person: " + deserializeObject1());
    }

    /** By using try-with Resource */
    public static void serializeObject(){
          //Using here try-with resources
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"))){
            // Create a Person object
            Person person = new Person("John Doe", 30);
            // Serialize the object to a file
            oos.writeObject(person);
            System.out.println("Serialization complete. Object saved to person.txt");
        }catch (IOException e){
              e.printStackTrace();
        }
    }
    public static Person deserializeObject(){
         Person deserializeObject = null;
         try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.txt"))){
             // Deserialize the object from a file
             deserializeObject = (Person)ois.readObject();
             System.out.println("Deserialization complete. Object read from person.txt");
         }catch (IOException | ClassNotFoundException e){
             e.printStackTrace();
         }
        return deserializeObject;
    }

    /** By using general ways i.e try catch block */
    public static void serializeObject1(){
        String fileName = "apple.txt";
        Person person = new Person("Suraj Chauhan", 31);
        try {
            /** Saving of object in a file */
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            /** Method for serialization of object */
            oos.writeObject(person);
            fos.close();
            oos.flush();
            System.out.println("Serialization complete. Object saved to apple.txt");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Person deserializeObject1(){
        Person deserializeObject = null;
        try {
            /** Reading the object from a file */
            FileInputStream fis = new FileInputStream("apple.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            /** Method for deserialization of object */
            deserializeObject = (Person)ois.readObject();
            fis.close();
            ois.close();
            System.out.println("Deserialization complete. Object read from person.txt");
        }catch(IOException | ClassNotFoundException e){
           e.printStackTrace();
        }
       return deserializeObject;
    }

}

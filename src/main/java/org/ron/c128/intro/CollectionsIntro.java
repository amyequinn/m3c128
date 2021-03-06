package org.ron.c128.intro;

import org.ron.c128.my1stOOP.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionsIntro {

    private Dog rover = new Dog("Rover", 4, 'S', true);
    private Dog fido = new Dog("Fido", 5, 'L', true);
    private Cat felix = new Cat("Felix", 3, 'M', true);
    private Parrot polly = new Parrot("Polly", 8, 'L', false);
    private Lizard rango = new Lizard("Rango", 11, 'S', true);
    private Lizard lizzy = new Lizard("Lizzy", 13, 'L', false);


    public static void main(String[] args) {
        CollectionsIntro ci = new CollectionsIntro();
        ci.arrays();
        ci.lists();
    }

    private void lists() {
        System.out.println("\nLists");
        List<Pet> pets1 = new ArrayList<>();
        processList(pets1);
        // ((ArrayList<Pet>) pets1).trimToSize();

        List<Pet> pets0 = new LinkedList<>();
        processList(pets0);
    }

    private void processList(List<Pet> pets) {
        System.out.println("\nProcessing List");
        System.out.println("pets.size = " + pets.size());
        pets.add(rover);
        pets.add(rover);
        pets.add(felix);
        pets.add(polly);
        pets.add(1, rango);
        boolean isRoverRemoved = pets.remove(0) == rover;
        boolean isLizzyRemoved = pets.remove(lizzy);
        System.out.printf(" Rover removed: %1$b, Lizzy removed: %2$b%n", isRoverRemoved, isLizzyRemoved);
        System.out.println("pets.size = " + pets.size());
        for (Pet pet : pets) {
            System.out.println("pet name is " + pet.getName());
        }

        if (pets.contains(rover)) {
            System.out.println("Rover is in list pets");
        }
        System.out.printf("Lizzy is %1$s list pets", pets.contains(lizzy) ? "in" : "not in");
    }

    public void arrays() {
        System.out.println("\nArrays");
        Pet[] pets0 = new Pet[]{polly, rango, lizzy, felix};

        Pet[] pets1 = new Pet[3];
        pets1[0] = rover;
        pets1[1] = fido;
        pets1[2] = new Cat("Tom", 70, 'L', true);

        System.out.println("about to exercise pets1 pets");
        for (Pet pet : pets1) {
            pet.getExercise();
        }

        pets1[2] = null;

        System.out.println("about to exercise pets1 & pets2 pets");
        exercisePets(pets1, pets0);
    }

    public void exercisePets(Pet[] pets0, Pet[] pets1) {
        int minLength = Math.min(pets0.length, pets1.length);
        for (int i = 0; i < minLength; i++) {
            Pet p0 = pets0[i];
            if (p0 != null) p0.getExercise();
            pets1[i].getExercise();
        }
    }
}

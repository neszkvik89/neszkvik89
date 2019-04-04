public class Cuboid {

    public static void main(String[] args) {
        int sideA = 7;
        int sideB = 8;
        int sideC = 9;
        int surfaceArea = (sideA * sideB + sideA * sideC + sideB * sideC) *2;
        int volume = sideA * sideB * sideC;

        System.out.println("Surface Area: " + surfaceArea);
        System.out.println("Volume: " + volume);
    }

    // Write a program that stores 3 sides of a cuboid as variables (doubles)
// The program should write the surface area and volume of the cuboid like:
//
// Surface Area: 600
// Volume: 1000

}

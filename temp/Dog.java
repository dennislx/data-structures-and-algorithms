public class Dog {

    public int weightInPounds;

    public Dog(int w) {
        weightInPounds = w;
    }
     
    public static Dog maxDog(Dog d1, Dog d2) {
        if (d1 == null){
            System.out.println("first dog not exist");
        }
        else if (d1.weightInPounds > d2.weightInPounds) {
            return d1;
        }
        return d2;
    }
    public void makeNoise() {
        if (weightInPounds < 10) {
            System.out.println("yipyipyip!");
        } else if (weightInPounds < 30) {
            System.out.println("bark. bark.");
        } else {
            System.out.println("woof!");
        }
    }    
    public static void main(String[] args) {
        Dog a = new Dog(10);
        Dog b = new Dog(20);
        System.out.println(Dog.maxDog(a, b).weightInPounds);
    }
}
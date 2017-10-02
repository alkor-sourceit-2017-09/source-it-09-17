import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
                "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud " +
                "exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure " +
                "dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit" +
                " anim id est laborum.";

        Task1 wordCounter = new Task1(text, true);
        System.out.println("Smallest words: " + Arrays.toString(wordCounter.getSmallestWords()));
        System.out.println("Biggest words: " + Arrays.toString(wordCounter.getBiggestWords()));

        System.out.println("-----\nAdd:");
        PersonList personList = new PersonList();
        personList.add(new Person("person1"));
        personList.add(new Person("person2"));
        System.out.println(personList);
        System.out.println("-----\nContains:");
        System.out.println("Contains person2? " +
                (personList.contains(new Person("person2")) ? "Yes" : "No"));

        System.out.println("----\nRemove:");
        System.out.println("Removing person2..");
        personList.remove(new Person("person2"));
        System.out.println(personList);
        System.out.println("Contains person2? " +
                (personList.contains(new Person("person2")) ? "Yes" : "No"));

        System.out.println("-----\nAdd all:");
        List<Person> people = new ArrayList<>();
        people.add(new Person("person3"));
        people.add(new Person("person4"));
        personList.addAll(people);
        System.out.println(personList);

        int index = 3;
        System.out.println("-----\nAdd all to index " + index);
        people.clear();
        people.add(new Person("person5"));
        people.add(new Person("person6"));
        personList.addAll(index, people);
        System.out.println(personList);

        index = 4;
        System.out.println("-----\nGet index " + index);
        System.out.println(personList.get(index));

        System.out.println("-----\nSet:");
        personList.set(5, new Person("person5-new"));
        System.out.println(personList);

        index = 2;
        System.out.println("-----\nAdd to index " + index);
        personList.add(index, new Person("person2-new"));
        System.out.println(personList);

        index = 0;
        System.out.println("-----\nRemove in index " + index);
        personList.remove(index);
        System.out.println(personList);

        System.out.println("-----\nClear:");
        personList.clear();
        System.out.println(personList);

    }
}

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long count = persons.stream()
                .filter(age -> age.getAge() < 18)
                .count();


        List<String> surnameСonscript = persons.stream()
                .filter(sex->sex.getSex().equals(Sex.MAN))
                .filter(age -> age.getAge() >= 18 && age.getAge() < 27)
                .map(family -> family.getFamily())
                .collect(Collectors.toList());


        List<String> workerMale = persons.stream()
                .filter(sex->sex.getSex().equals(Sex.MAN))
                .filter(age -> age.getAge() >= 18 && age.getAge() < 65)
                .sorted(Comparator.comparing(Person::getFamily))
                .map(family -> family.getFamily())
                .collect(Collectors.toList());

        List<String> workerFemale = persons.stream()
                .filter(sex->sex.getSex().equals(Sex.WOMAN))
                .filter(age -> age.getAge() >= 18 && age.getAge() < 60)
                .sorted(Comparator.comparing(Person::getFamily))
                .map(family -> family.getFamily())
                .collect(Collectors.toList());


    }

}

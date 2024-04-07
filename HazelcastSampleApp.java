import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import java.util.Map;

public class HazelcastSample {
    public static void main(String[] args) {
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();

        Map<String, Person> map = hazelcastInstance.getMap("persons");

        for (int i = 0; i < 10000; i++) {
            Person person = new Person("Person " + i);
            map.put("person" + i, person);
        }

        Person retrievedPerson = map.get("person1");
        System.out.println("Retrieved Person: " + retrievedPerson);

        hazelcastInstance.shutdown();
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

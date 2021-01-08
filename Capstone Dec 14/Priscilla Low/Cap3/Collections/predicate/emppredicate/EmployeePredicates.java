package Collections.predicate.emppredicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author blueg
 */
public class EmployeePredicates {
        public static Predicate<Employees> isAdultMale() {
        return p -> p.getAge() > 21 && p.getGender().equalsIgnoreCase("M");
    }
     
    public static Predicate<Employees> isAdultFemale() {
        return p -> p.getAge() > 18 && p.getGender().equalsIgnoreCase("F");
    }
     
    public static Predicate<Employees> isAgeMoreThan(Integer age) {
        return p -> p.getAge() > age;
    }
     
    public static List<Employees> filterEmployees (List<Employees> employees, 
                                                Predicate<Employees> predicate) 
    {
        return employees.stream()
                    .filter( predicate )
                    .collect(Collectors.<Employees>toList());
    }
}

package Java8;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.*;
import java.util.stream.*;
class Employee {
    String fullName;
    LocalDate dateOfJoining;
    public Employee(String fullName, LocalDate dateOfJoining) {
        this.fullName = fullName;
        this.dateOfJoining = dateOfJoining;
    }
    @Override
    public String toString() {
        return fullName + " (Joined: " + dateOfJoining + ")";
    }
}
public class AnniversaryFilterDemo {
    public static void main(String[] args) {
        List<Employee> staff = Arrays.asList(
                new Employee("Neha", LocalDate.of(2017, 3, 10)),
                new Employee("Arjun", LocalDate.of(2019, 3, 10)),
                new Employee("Sana", LocalDate.of(2021, 7, 25))
        );
        int month = 3, day = 10;
        MonthDay target = MonthDay.of(month, day);

        //Each employee record has a full name and date of joining. The company wants to
        //find employees whose work anniversary falls on a given month/day, ignoring the
        //year.

        staff.stream().filter(s->s.dateOfJoining.getDayOfMonth()==10 && s.dateOfJoining.getMonth()==3).map(e->e.fullName).collect(Collectors.toList());
    }
}
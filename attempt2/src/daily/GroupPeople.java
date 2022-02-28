package daily;

import java.util.*;

public class GroupPeople {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<List<Integer>>> groupSizeVsPeopleMap = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int groupSize = groupSizes[i];
            List<List<Integer>> peopleGroups = groupSizeVsPeopleMap.getOrDefault(groupSize, new LinkedList<>());
            if (peopleGroups.size() == 0 || ((LinkedList<List<Integer>>) peopleGroups).getLast().size() == groupSize)
                peopleGroups.add(new ArrayList<>());
            List<Integer> last = ((LinkedList<List<Integer>>) peopleGroups).getLast();
            last.add(i);
            groupSizeVsPeopleMap.put(groupSize, peopleGroups);
        }

        List<List<Integer>> result = new ArrayList<>();
        groupSizeVsPeopleMap.values().forEach(b-> {
            for (List<Integer> x : b) {
                result.add(x);
            }
        });
        return result;
    }

    public List<List<Integer>> groupThePeople2(int[] groupSizes) {
        Map<Integer, List<Integer>> groupSizeVsPeopleMap = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int groupSize = groupSizes[i];
            List<Integer> people = groupSizeVsPeopleMap.getOrDefault(groupSize, new ArrayList<>());
            people.add(i);
            groupSizeVsPeopleMap.put(groupSize, people);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : groupSizeVsPeopleMap.entrySet()) {
            Integer size = entry.getKey();
            List<Integer> people = entry.getValue();
            for (int i = 0; i < people.size(); i += size) {
                List<Integer> peopleSubset = new ArrayList<>();
                for (int j = i; j < (i + size); j++) {
                    peopleSubset.add(people.get(j));
                }
                result.add(peopleSubset);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GroupPeople gp = new GroupPeople();
        int groupSizes[] = {3, 3, 3, 3, 3, 1, 3};
        List<List<Integer>> lists = gp.groupThePeople(groupSizes);
        System.out.println(lists.size());
        lists.forEach(System.out::println);
    }
}

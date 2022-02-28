package assessment;

import java.util.*;

public class Websites {
    static class Pattern implements Comparable {
        String website1, website2, website3;

        public Pattern(String website1, String website2, String website3) {
            this.website1 = website1;
            this.website2 = website2;
            this.website3 = website3;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pattern pattern = (Pattern) o;
            return (Objects.equals(website1, pattern.website1))
                    && (Objects.equals(website2, pattern.website2))
                    && (Objects.equals(website3, pattern.website3));
        }

        @Override
        public int hashCode() {
            return Objects.hash(website1, website2, website3);
        }

        @Override
        public int compareTo(Object o) {
            Pattern pattern = (Pattern) o;
            if (!website1.equals(pattern.website1))
                return website1.compareTo(pattern.website1);
            else if (!website2.equals(pattern.website2))
                return website2.compareTo(pattern.website2);
            else
                return website3.compareTo(pattern.website3);
        }
    }

    class WebsiteAccess implements Comparable {
        private String website;
        private int ts;

        public WebsiteAccess(String website, int ts) {
            this.website = website;
            this.ts = ts;
        }

        @Override
        public int compareTo(Object o) {
            WebsiteAccess websiteAccess = (WebsiteAccess) o;
            return Integer.compare(ts, websiteAccess.ts);
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        Map<String, TreeSet<WebsiteAccess>> userVsWebsiteMap = new HashMap<>();
        Map<Pattern, Integer> patternCountMap = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
            TreeSet<WebsiteAccess> websiteList = userVsWebsiteMap.getOrDefault(username[i], new TreeSet<>());
            websiteList.add(new WebsiteAccess(website[i], timestamp[i]));
            userVsWebsiteMap.put(username[i], websiteList);
        }
        int maxCount = Integer.MIN_VALUE;
        Set<Pattern> patterns = new TreeSet<>();
        for (Map.Entry<String, TreeSet<WebsiteAccess>> entry : userVsWebsiteMap.entrySet()) {
            Map<Pattern, Integer> patternCountMapLocal = new HashMap<>();
            TreeSet<WebsiteAccess> value = entry.getValue();
            if (value.size() >= 3) {
                List<String> extractValue = getWebsites(value);
                List<List<String>> subsets = subsets(extractValue);
                for (List<String> subset : subsets) {
                    Pattern p = new Pattern(subset.get(0), subset.get(1), subset.get(2));
                    Integer count = patternCountMapLocal.getOrDefault(p, 0);
                    if (count == 0)
                        count++;
                    patternCountMapLocal.put(p, count);
                }
            }
            if (patternCountMapLocal.size() > 0) {
                for (Map.Entry<Pattern, Integer> entry1 : patternCountMapLocal.entrySet()) {
                    Pattern key = entry1.getKey();
                    Integer value1 = entry1.getValue();
                    Integer count = patternCountMap.getOrDefault(key, 0);
                    count += value1;
                    patternCountMap.put(key, count);
                    if (count == maxCount) {
                        patterns.add(key);
                    }
                    if (count > maxCount) {
                        patterns.clear();
                        patterns.add(key);
                        maxCount = count;
                    }
                }
            }
        }
        ArrayList<String> objects = new ArrayList<>();
        if (!patterns.iterator().hasNext())
            return objects;
        Pattern next = patterns.iterator().next();
        objects.add(next.website1);
        objects.add(next.website2);
        objects.add(next.website3);
        return objects;
    }

    private List<String> getWebsites(TreeSet<WebsiteAccess> value) {
        List<String> list = new ArrayList<>();
        Iterator<WebsiteAccess> iterator = value.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next().website);
        }
        return list;
    }


    public List<List<String>> subsets(List<String> nums) {
        List<List<String>> output = new ArrayList<>();
        int n = nums.size();
        if (n < 3)
            return output;
        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); ++i) {
            String bitmask = Integer.toBinaryString(i).substring(1);
            List<String> curr = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1') curr.add(nums.get(j));
            }
            if (curr.size() == 3)
                output.add(curr);
        }
        return output;
    }

    public static void main(String[] args) {
        Websites websites = new Websites();
        String username[] = {"h", "eiy", "cq", "h", "cq", "txldsscx", "cq", "txldsscx", "h", "cq", "cq"};
        int ts[] = {527896567, 334462937, 517687281, 134127993, 859112386, 159548699, 51100299, 444082139, 926837079, 317455832, 411747930};
        String websiteNames[] = {"hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "yljmntrclw", "hibympufi", "yljmntrclw"};

        List<String> list = websites.mostVisitedPattern(username, ts, websiteNames);
        list.forEach(System.out::println);
    }
}

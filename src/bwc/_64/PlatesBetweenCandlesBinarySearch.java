//package bwc._64;
//
//public class PlatesBetweenCandlesBinarySearch {
//    public int[] platesBetweenCandles(String s, int[][] queries) {
//            int c[], res;
//            int j = 0;
//            for (int i = 0; i < s.length(); ++i)
//                if (s.charAt(i) == '|')
//                    c[j] = i;
//            for (auto & q :queries){
//                auto it_l = lower_bound(begin(c), end(c), q[0]);
//                auto it_r = prev(upper_bound(it_l, end(c), q[1]));
//                res.push_back(it_l < it_r ? * it_r - *it_l - (it_r - it_l) :0);
//            }
//            return res;
//        }
//    }

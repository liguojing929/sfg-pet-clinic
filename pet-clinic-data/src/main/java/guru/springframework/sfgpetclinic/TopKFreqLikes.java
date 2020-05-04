package guru.springframework.sfgpetclinic;

import java.util.*;

public class TopKFreqLikes {

    public static void main(String[] args){
        TopKFreqLikes obj = new TopKFreqLikes();
        obj.likes(1);
        obj.likes(1);
        obj.likes(1);
        obj.likes(2);
        obj.likes(2);
        obj.likes(3);
        obj.likes(2);
        obj.likes(1);
        System.out.println(obj.topKMostLikes(2));
    }


    /**
     * Approach 1:
     * Simply store the post and its corresponding number of likes into map
     */

    private Map<Integer, Integer> map = new HashMap<>();
    public List<Integer> topKMostLikes(int k) {
        List<Integer> res = new ArrayList<>();
        if(map.isEmpty()) return res;
        if(map.size() <= k) {
            return new ArrayList<>(map.keySet());
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer id1, Integer id2) {
                return map.get(id1) - map.get(id2);
            }
        });
        for(Integer key : map.keySet()) {
            heap.offer(key);
            if(heap.size() > k) {
                heap.poll();
            }
        }
        res = new ArrayList<>(heap);
        Collections.reverse(res);
        return  res;
    }

    /**
     * Either way, we do need to compute the amount of likes for each post.
     * @param id
     */
    public void likes(int id) {
        map.put(id, map.getOrDefault(id, 0) + 1);
    }





}

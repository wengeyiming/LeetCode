package containsDuplicateIII220;

//TreeSet: 二叉排序树
import java.util.*;

public class test {
	public static void main(String[] args) {
		int[] nums = new int[] {16,18,12};
		int k = 2, t = 1;

		System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
	}

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long l = (long) nums[i], floor = set.floor(l + t);
            System.out.println(floor);
            if (floor != null && floor >= l - t) return true;
            set.add(l);
            if (i >= k) set.remove((long) nums[i - k]);
        }
        return false;
    }
	
    
    /*
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length < 2 || k < 1)
			return false;
		TreeSet<Long> set = new TreeSet<>();

		for (int i = 0; i < nums.length; i++) {
			long l = (long) nums[i];

			//返回小于l的最大数和大于l的最小数
			Long floor = set.floor(l);
			Long ceil = set.ceiling(l);
			System.out.println(floor+","+ceil+","+l);
			// the tricky part I modified to easily understood way.
			if ((floor != null && l - floor <= t) || (ceil != null && ceil - l <= t))
				return true;

			set.add(l);	
			if (i >= k)
				set.remove((long) nums[i - k]);

		}
		return false;
	}
	*/
}

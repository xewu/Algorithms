public class CourseSchedule{
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] degree = new int[numCourses];
		int[] courses = new int[numCourses];
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		// initialize degree and map;
		for (int[] req : prerequisites) {
			int a = req[0];
			int b = req[1];
			degree[a] ++;
			if (!map.containsKey(b)) {
				map.put(b, new ArrayList<Integer>());
			}
			map.get(b).add(a);
		}
		
		// Create a queue to store active courses:
		// int n to keep track of how many courses activated;
		int n = 0;
		int index = 0;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < degree.length; i++) {
			if (degree[i] == 0) {
				queue.offer(i);
				courses[index++] = i;
				n ++;
			}
		}
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			if (!map.containsKey(curr)) {
				continue;
			}
			for (Integer i : map.get(curr)) {
				degree[i] --;
				if (degree[i] == 0) {
					queue.offer(i);
					courses[index++] = i;
					n ++;
				}
			}
		}
		
		if (n != numCourses) {
			return new int[0];
		}
		
		return courses;
	}
}
public class Intersect {
	public int area(int[] x, int[] y) {
		int[] xbound = new int[2], ybound = new int[2];
		getBound(xbound, x);
		if (xbound[1] != xbound[0]) getBound(ybound, y);
		return (xbound[1]-xbound[0]) * (ybound[1] - ybound[0]);
	}
	
	public void getMinAndMax(int[] array, int index, int[] store) {
		store[0] = Math.min(array[index], array[index+1]);
		store[1] = Math.max(array[index], array[index+1]);
	}
	
	public void getBound(int[] bound, int[] array) {
		if (array.length == 0) return;
		getMinAndMax(array, 0, bound);
		int[] tmp = new int[2];
		for (int i = 2; i < array.length; i += 2) {
			getMinAndMax(array, i, tmp);
			if(tmp[0]>=bound[0] && tmp[1]<=bound[1]) {
				bound[0] = tmp[0];
				bound[1] = tmp[1];
			} else if (bound[0] >= tmp[0] && tmp[1] >= bound[0] && bound[1] >= tmp[1]) {
				bound[1] = tmp[1];
			} else if (bound[0] <= tmp[0] && tmp[0] <= bound[1] && bound[1] <= tmp[1]) {
				bound[0] = tmp[0];
			} else if (!(bound[0]>=tmp[0] && bound[1] <= tmp[1])) bound[0] = bound[1] = 0;
			
			if (bound[0] == bound[1]) return;
		}
	}
}
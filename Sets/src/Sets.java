import java.util.*;
public class Sets {
	public int[] operate(int[] A, int[] B, String operation) {
		List<Integer> union = new ArrayList<Integer>();
		List<Integer> inter = new ArrayList<Integer>();
		List<Integer> SymDiff = new ArrayList<Integer>();
		Arrays.sort(A);
		Arrays.sort(B);
		int ia = 0, ib = 0;
		while (ia < A.length && ib < B.length) {
			if (A[ia] == B[ib]) {
				inter.add(A[ia]);
				union.add(A[ia]);
				++ia; ++ib;
			} else if (A[ia] < B[ib]) {
				union.add(A[ia]);
				SymDiff.add(A[ia]);
				++ia;
			} else {
				union.add(B[ib]);
				SymDiff.add(B[ib]);
				++ib;
			}
		}
		while (ia < A.length) {
			union.add(A[ia]);
			SymDiff.add(A[ia++]);
		}
		while (ib < B.length) {
			union.add(B[ib]);
			SymDiff.add(B[ib++]);
		}
		if (operation.equals("UNION")) return List2Array(union);
		if (operation.equals("INTERSECTION")) return List2Array(inter);
		if (operation.equals("SYMMETRIC DIFFERENCE")) return List2Array(SymDiff);
		else return null;
	}
	
	public int[] List2Array(List<Integer> list) {
		int[] ret = new int[list.size()];
		for (int i = 0; i < ret.length; ++i) ret[i] = list.get(i);
		return ret;
	}
}
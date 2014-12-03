import java.util.*;
import java.util.regex.*;
public class Table {
	public String[] layout(String[] tbl) {
		if (tbl.length == 0) return null;
		String pattern = "(\\((\\d+),(\\d+),(\\w)\\))";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(tbl[0]);
		int colnum = 0;
		while (m.find()) {
			colnum += Integer.parseInt(m.group(2));
		}
		List<char[]> lists = new ArrayList<char[]>();
		int curListIndex = 0, curCol = 0, tmpcol, tmprow, i, j, k;
		char c;
		for (i = 0; i < tbl.length; ++i) {
			m = r.matcher(tbl[i]);
			while (m.find()) {
				if (curListIndex >= lists.size()) {
					char[] newArray = new char[colnum];
					lists.add(newArray);
					curCol = 0;
				}
				tmpcol = Integer.parseInt(m.group(2));
				tmprow = Integer.parseInt(m.group(3));
				//System.out.format("%d %d\n", tmpcol, tmprow);
				c = m.group(4).charAt(0);
				for (j = curListIndex; j < curListIndex + tmprow; ++j) {
					if (j >= lists.size()) lists.add(new char[colnum]);
					for (k = curCol; k < curCol + tmpcol; ++k) {
						lists.get(j)[k] = c;
					}
				}
				
				outer:
				for (; curListIndex < lists.size(); ++curListIndex) {
					for (; curCol < colnum; ++curCol) {
						if (lists.get(curListIndex)[curCol] < 'A') break outer;
					}
					curCol = 0;
				}
			}
		}
		
		String[] ret = new String[lists.size()];
		for (i = 0; i < ret.length; ++i) {
			ret[i] = new String(lists.get(i));
			//System.out.println(ret[i]);
		}
		return ret;
	}
}
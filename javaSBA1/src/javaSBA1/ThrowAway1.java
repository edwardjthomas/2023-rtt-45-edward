package javaSBA1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThrowAway1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>(Arrays.asList("", "Hi", null, "How"));
		System.out.println(list);
		list.removeAll(Arrays.asList("", null));
		System.out.println(list);
	}

}

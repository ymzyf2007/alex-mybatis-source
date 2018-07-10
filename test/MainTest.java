import java.util.Iterator;
import java.util.Map;

public class MainTest {

	public static void main(String[] args) {
		Object value = "62845435";
		System.out.println(castToInt(value));
	}

	public static Integer castToInt(Object value) {
		if (value == null) {
			return null;
		}

		if (value instanceof Integer) {
			return (Integer) value;
		}

		if (value instanceof Number) {
			return ((Number) value).intValue();
		}

		if (value instanceof String) {
			String strVal = (String) value;

			if (strVal.length() == 0 //
					|| "null".equals(strVal) //
					|| "NULL".equals(strVal)) {
				return null;
			}

			if (strVal.indexOf(',') != 0) {
				strVal = strVal.replaceAll(",", "");
			}

			return Integer.parseInt(strVal);
		}

		if (value instanceof Boolean) {
			return ((Boolean) value).booleanValue() ? 1 : 0;
		}

		if (value instanceof Map) {
			Map map = (Map) value;
			if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
				Iterator iter = map.values().iterator();
				iter.next();
				Object value2 = iter.next();
				return castToInt(value2);
			}
		}

		return -1;
//		throw new JSONException("can not cast to int, value : " + value);
	}

}

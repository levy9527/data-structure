import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
  private List<Integer> arrayList;

  @BeforeEach
  void init(){
    arrayList = new ArrayList<>(5);
    arrayList.add(new Integer(1));
  }

  @Test
  @DisplayName("add/size/toArray")
  @Order(1)
  void test() {
    assertEquals(1, arrayList.size());
    assertEquals(new String("[1, null, null, null, null]"),Arrays.toString(arrayList.toArray()) );

  }

  @Test
  @Order(2)
  void contains() {
    assertTrue(arrayList.contains(new Integer(1)));

    Map map = new HashMap();
    map.put("key", "value");

    List<Map> list = new ArrayList<>(5);
    list.add(map);

    Map map2 = new HashMap();
    map2.put("key", "value");
    assertTrue(list.contains(map2));
  }

  @Test
  @Order(3)
  @DisplayName("set/get")
  void get() {
    assertEquals(new Integer(1), arrayList.get(0));
    assertNull(arrayList.get(-1));
    assertNull(arrayList.get(11));
    assertNull(arrayList.get(1));

    arrayList.set(1, new Integer(2));
    arrayList.set(0, new Integer(0));
    arrayList.set(2, new Integer(3));
    arrayList.set(3, new Integer(4));
    arrayList.set(4, new Integer(5));
    arrayList.set(4, new Integer(6));

    assertEquals(5, arrayList.size());
    assertEquals(new String("[0, 2, 3, 4, 6]"),Arrays.toString(arrayList.toArray()) );
  }

  @Test
  @Order(4)
  void remove() {
    arrayList.remove(-1);
    arrayList.remove(11);
    arrayList.remove(5);
    assertEquals(1, arrayList.size());

    arrayList.remove(0);
    assertEquals(0, arrayList.size());

    arrayList = new ArrayList<>(3);
    assertNull(arrayList.get(2));

    arrayList.add(new Integer(1));
    arrayList.add(new Integer(2));
    arrayList.add(new Integer(3));
    arrayList.remove(1);

    assertEquals(3, arrayList.get(1));
    assertNull(arrayList.get(2));
  }

  @Test
  @Order(5)
  void insert() {
    // 1 -> 0,1,2,3,
    arrayList.insert(0, new Integer(0));
    arrayList.insert(2, new Integer(3));
    arrayList.insert(2, new Integer(2));

    assertEquals(4, arrayList.size());
    assertEquals(new String("[0, 1, 2, 3, null]"),Arrays.toString(arrayList.toArray()) );

    arrayList.insert(4, new Integer(4));
    arrayList.insert(4, new Integer(5));
    assertEquals(5, arrayList.size());
    assertEquals(new String("[0, 1, 2, 3, 4]"),Arrays.toString(arrayList.toArray()) );
  }

}

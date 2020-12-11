import collection.ArrayList;
import collection.List;
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
    arrayList.add(1);
  }

  @Test
  @DisplayName("add/size/toArray")
  @Order(1)
  void test() {
    assertEquals(1, arrayList.size());
    assertEquals(("[1]"),Arrays.toString(arrayList.toArray()) );

  }

  @Test
  @Order(2)
  void contains() {
    assertTrue(arrayList.contains(1));

    Map<String, String> map = new HashMap<>();
    map.put("key", "value");

    List<Map<String, String>> list = new ArrayList<>(5);
    list.add(map);

    Map<String, String> map2 = new HashMap<>();
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

    arrayList.set(1, 2);
    arrayList.set(0, 0);
    arrayList.set(2, 3);
    arrayList.set(3, 4);
    arrayList.set(4, 5);
    arrayList.set(4, 6);

    assertEquals(5, arrayList.size());
    assertEquals(("[0, 2, 3, 4, 6]"),Arrays.toString(arrayList.toArray()) );
  }

  @Test
  @Order(4)
  void remove() {
    assertNull(arrayList.remove(-1));
    assertNull(arrayList.remove(11));
    assertNull(arrayList.remove(5));
    assertEquals(1, arrayList.size());

    arrayList.remove(0);
    assertEquals(0, arrayList.size());

    arrayList = new ArrayList<>(3);
    assertNull(arrayList.get(2));

    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(3);
    assertEquals(2, arrayList.remove(1));

    assertEquals(3, arrayList.get(1));
    assertNull(arrayList.get(2));
  }

  @Test
  @Order(5)
  void insert() {
    // 1 -> 0,1,2,3,
    arrayList.insert(0, 0);
    arrayList.insert(2, 3);
    arrayList.insert(2, 2);

    assertEquals(4, arrayList.size());
    assertEquals(("[0, 1, 2, 3]"),Arrays.toString(arrayList.toArray()) );

    arrayList.insert(4, 4);
    arrayList.insert(4, 5);
    assertEquals(5, arrayList.size());
    assertEquals(("[0, 1, 2, 3, 4]"),Arrays.toString(arrayList.toArray()) );
  }

}

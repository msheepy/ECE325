public class Casting {
    ArrayList list2 = new ArrayList();
    list2.add("test");
    String str2 = (String) list2.get(0);

    ArrayList<String> list = new ArrayList<String>();
    list.add("test");
    String str = list.get(0);
}

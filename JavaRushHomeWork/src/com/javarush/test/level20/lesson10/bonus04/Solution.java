package com.javarush.test.level20.lesson10.bonus04;

import java.io.*;
import java.util.*;

/* Свой список
Посмотреть, как реализован LinkedList.
Элементы следуют так: 1->2->3->4  и так 4->3->2->1
По образу и подобию создать Solution.
Элементы должны следовать так:
1->3->7->15
    ->8...
 ->4->9
    ->10
2->5->11
    ->12
 ->6->13
    ->14
Удалили 2 и 9
1->3->7->15
    ->8
 ->4->10
Добавили 16,17,18,19,20 (всегда добавляются на самый последний уровень к тем элементам, которые есть)
1->3->7->15
       ->16
    ->8->17
       ->18
 ->4->10->19
        ->20
Удалили 18 и 20
1->3->7->15
       ->16
    ->8->17
 ->4->10->19
Добавили 21 и 22 (всегда добавляются на самый последний уровень к тем элементам, которые есть.
Последний уровень состоит из 15, 16, 17, 19. 19 последний добавленный элемент, 10 - его родитель.
На данный момент 10 не содержит оба дочерних элемента, поэтому 21 добавился к 10. 22 добавляется в следующий уровень.)
1->3->7->15->22
       ->16
    ->8->17
 ->4->10->19
        ->21

Во внутренней реализации элементы должны добавляться по 2 на каждый уровень
Метод getParent должен возвращать элемент, который на него ссылается.
Например, 3 ссылается на 7 и на 8, т.е.  getParent("8")=="3", а getParent("13")=="6"
Строки могут быть любыми.
При удалении элемента должна удаляться вся ветка. Например, list.remove("5") должен удалить "5", "11", "12"
Итерироваться элементы должны в порядке добавления
Доступ по индексу запрещен, воспользуйтесь при необходимости UnsupportedOperationException
Должно быть наследование AbstractList<String>, List<String>, Cloneable, Serializable
Метод main в тестировании не участвует
*/
public class Solution extends AbstractList<String> implements List<String>, Cloneable, Serializable {

    private class MyIterator implements Iterator<String> {
        private ArrayList<String> nodes = new ArrayList<>();
        private Iterator<String> iterator;
        private String currentValue;

        public MyIterator() {
            ArrayDeque<Node> queue = new ArrayDeque<>();
            queue.add(head);

            while (!queue.isEmpty()) {
                Node node = queue.poll();

                if (node.value != null) nodes.add(node.value);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            iterator = nodes.iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public String next() {
            currentValue = iterator.next();
            return currentValue;
        }

        @Override
        public void remove() {
            Solution.this.remove(currentValue);
        }
    }

    class Node implements Serializable {
        public Node parent;
        public Node left;
        public Node right;
        public String value;

        public Node() {
        }

        public Node(Node parent, String value) {
            this.parent = parent;
            this.value = value;
        }
    }

    private Node head = new Node();

    public String getParent(String value) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (value.equals(node.value)) {
                return node.parent.value;
            }
            else {
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return null;
    }

    @Override
    public Iterator<String> iterator() {
        return new MyIterator();
    }

    @Override
    public void clear() {
        head = new Node();
    }

    @Override
    public boolean remove(Object o) {
        String value = (String)o;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (value.equals(node.value)) {
                Node parent = node.parent;
                if (parent.left == node) parent.left = null;
                else parent.right = null;
                return true;
            }
            else {
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return false;
    }

    @Override
    public boolean add(String s) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(head);

        while (true) {
            Node node = queue.poll();

            if (node.left == null) {
                node.left = new Node(node, s);
                break;
            }
            else queue.add(node.left);

            if (node.right == null) {
                node.right = new Node(node, s);
                break;
            }
            else queue.add(node.right);
        }

        return true;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(head);

        int size = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            size++;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return size - 1;
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<String> list = new Solution();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        ((Solution) list).print();
        System.out.println("list.remove(\"2\") " + list.remove("2"));
        System.out.println("list.remove(\"9\") " + list.remove("9"));
        System.out.println("list.remove(\"51\") " + list.remove("51"));
        ((Solution) list).print();
        System.out.println("list.add(\"16\") " + list.add("16"));
        System.out.println("list.add(\"17\") " + list.add("17"));
        System.out.println("list.add(\"18\") " + list.add("18"));
        System.out.println("list.add(\"19\") " + list.add("19"));
        System.out.println("list.add(\"20\") " + list.add("20"));
        ((Solution) list).print();
        System.out.println("list.remove(\"18\") " + list.remove("18"));
        System.out.println("list.remove(\"20\") " + list.remove("20"));
        ((Solution) list).print();
        System.out.println("list.add(\"21\") " + list.add("21"));
        System.out.println("list.add(\"22\") " + list.add("22"));
        ((Solution) list).print();
        System.out.println("list.clear()");
        list.clear();
        ((Solution) list).print();
        System.out.println("list.add(\"a\") " + list.add("a"));
        System.out.println("list.add(\"b\") " + list.add("b"));
        System.out.println("list.add(\"c\") " + list.add("c"));
        System.out.println("list.add(\"d\") " + list.add("d"));
        System.out.println("list.add(\"e\") " + list.add("e"));
        ((Solution) list).print();
        System.out.println("list.remove(\"a\") " + list.remove("a"));
        System.out.println("list.remove(\"b\") " + list.remove("b"));
        ((Solution) list).print();
        for (int i = 1; i < 16; i++) {
            System.out.println("list.add(\"" + i + "\") " + list.add(String.valueOf(i)));
        }
        ((Solution) list).print();
        System.out.println("Parent 3 <- 1 = " + ((Solution) list).getParent("3"));
        System.out.println("Parent 5 <- 2 = " + ((Solution) list).getParent("5"));
        System.out.println("Parent 7 <- 3 = " + ((Solution) list).getParent("7"));
        System.out.println("Parent 10 <- 4 = " + ((Solution) list).getParent("10"));
        System.out.println("list.remove(\"2\") " + list.remove("2"));
        ((Solution) list).print();
        System.out.println("Parent null <- 11 = " + ((Solution) list).getParent("11"));
        ((Solution) list).print();
        System.out.println("Size = 9 = " + list.size());
        System.out.print("\nSave list");
        FileOutputStream fos = new FileOutputStream("file");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
        fos.close();
        System.out.println(" done");
        System.out.print("Load list");
        FileInputStream fis = new FileInputStream("file");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<String> list2 = (List<String>) ois.readObject();
        ois.close();
        fis.close();
        System.out.println(" done\n");
        ((Solution) list2).print();
        System.out.println("list.iterator()");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) System.out.print(iterator.next() + " ");
        System.out.println();
        iterator = list.iterator();
        System.out.println("iterator.next() " + iterator.next());
        System.out.println("iterator.next() " + iterator.next());
        System.out.println("iterator.remove() ");
        iterator.remove();
        while (iterator.hasNext()) System.out.print(iterator.next() + " ");
        System.out.println();
        ((Solution) list).print();
        iterator = list.iterator();
        while (iterator.hasNext()) System.out.print(iterator.next() + " ");

    }

    public void print() {
        System.out.println("=============PRINT=============");
        if (head.left != null) print(head.left, "");
        if (head.right != null) print(head.right, "");
        System.out.println();
        System.out.println(size());
        System.out.println("===============================");
    }

    private void print(Node node, String s) {
        if (node.equals(node.parent.right)) {
            System.out.println();
            System.out.print(s);
        }
        System.out.print("->" + node.value);
        if (node.left != null) print(node.left, s + "|||");
        if (node.right != null) print(node.right, s + "|||");
    }
}

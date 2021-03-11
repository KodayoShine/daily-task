package com.test.yg.structure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 单向链表
 *
 */
public class SingleLinkedListTest {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(18,"xx");
        singleLinkedList.add(19,"aa");
        singleLinkedList.add(20,"yy");

        singleLinkedList.printLinked();
        System.out.println("------delete: 19");
        singleLinkedList.delete(19);
        singleLinkedList.printLinked();
    }


}



class SingleLinkedList {
    // 初始化的头部节点,主要用来进行指针定位
    private Node headNode = new Node();

    public void add(int age, String name) {
        Node node = new Node(age, name);
        Node lastNode = getLastNode();
        lastNode.setNext(node);
    }

    public void delete(int age) {
        Node temp = headNode.getNext();
        while(temp != null) {
            if(temp.getNext() == null){
                return;
            }

            if(temp.getNext().getAge() == age) {
                temp.setNext(temp.getNext().getNext());
                temp.getNext().setNext(null);
                return;
            }

            temp = temp.getNext();
        }
    }



    public void printLinked() {
        Node temp = headNode.getNext();
        while(temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    /**
     * 获取最后一个有效节点
     * @return
     */
    private Node getLastNode() {
        Node temp = headNode;
        while(temp.getNext() != null) {
            temp = temp.getNext();
        }
        return temp;
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Node {
    private int age;
    private String name;
    private Node next;

    public Node(int age, String name) {
        this.age = age;
        this.name = name;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

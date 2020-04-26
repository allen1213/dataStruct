package com.example.demo.data.structure.hash;

public class HashTableDemo {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(5);
        hashTable.addEmp(new Emp(6,"allen"));
        hashTable.addEmp(new Emp(2,"bobo"));
        hashTable.addEmp(new Emp(3,"boer"));
        hashTable.addEmp(new Emp(9,"shall"));
        hashTable.addEmp(new Emp(12,"boss"));

        hashTable.showEmp();
    }
}

class Emp {

    private int id;
    private String name;
    private Emp next;

    public Emp() {
    }

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Emp setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Emp setName(String name) {
        this.name = name;
        return this;
    }

    public Emp getNext() {
        return next;
    }

    public Emp setNext(Emp next) {
        this.next = next;
        return this;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class EmpLinkedList {

    private Emp head;

    public void addEmp(Emp emp) {

        if (head == null) {
            head = emp;
            return;
        }

        Emp temp = head;
        while (true) {
            if (temp.getNext() == null) {
                temp.setNext(emp);
                break;
            }
            temp = temp.getNext();
        }
    }

    public void showEmp(int size) {
        Emp temp = head;
        if (temp == null) return;

        System.out.print("Line " + (temp.getId() % size + 1) + ": ");
        while (temp != null) {
            System.out.print(" =>  Emp [ " + temp.getId() + " , " + temp.getName() + " ] ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    public Emp getEmpById(int id) {
        Emp temp = head;
        if (temp == null) return null;

        while (true) {
            if ( temp.getId() == id) return temp;
            temp = temp.getNext();
        }

    }

}

class HashTable {

    private int size;

    private EmpLinkedList[] empLinkedList;

    public HashTable(int size) {
        this.size = size;
        empLinkedList = new EmpLinkedList[size];

        for (int i = 0; i < size; i++) {
            empLinkedList[i] = new EmpLinkedList();
        }

    }

    public int getPosition(int id) {
        return id % size;
    }

    public void addEmp(Emp emp) {

        int position = getPosition(emp.getId());

        empLinkedList[position].addEmp(emp);

    }

    public void showEmp() {
        for (int i = 0; i < size; i++) {
            empLinkedList[i].showEmp(size);
        }
    }

}

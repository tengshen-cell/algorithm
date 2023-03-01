package array;
/**
 * @description Insert,delete,and random access operations by subscript for arrays
 * @author 滕广银
 * @date 2023/2/25 22:05
 */
public class Array {
    // define integer data to save data
    public int data[];

    private int n;

    private int count;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    public int find(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        return data[index];
    }

    public boolean insert(int index, int value) {
        if (count == n) {
            System.out.println("没有可插入的位置");
            return false;
        }

        if (index < 0 || index > count) {
            System.out.println("位置不合法");
            return false;
        }

        // location legitimate
        for (int i = count; i > index ; --i) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        ++count;
        return true;
    }

    public boolean delete(int index) {
        if (index < 0 || index >= count) {
            return false;
        }
        for (int i = index + 1; i < count; ++i) {
            data[i - 1] = data[i];
        }
        --count;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        array.printAll();
    }
}

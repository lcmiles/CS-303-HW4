public class Item {
    private int key;
    private String name;
    private String type;
    private Item left;
    private Item right;

    public Item(int key, String type, String name) {
        this.key = key;
        this.name = name;
        this.type = type; 
        this.left = null;
        this.right = null;
    }

    public int getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public void addItem(int key, String type, String name) {
        if (key < this.key) {
            if (this.left == null) {
                this.left = new Item(key, type, name);
            }
            else {
                this.left.addItem(key, type, name);
            }
        }
        else {
            if (this.right == null) {
                this.right = new Item(key, type, name);
            }
            else {
                this.right.addItem(key, type, name);
            }
        }
    }

    public boolean search(int key) {
        if (key == this.key) {
            return true;
        }
        else if (key < this.key) {
            if (this.left != null) {
                return this.left.search(key);
            }
        }
        else {
            if (this.right != null) {
                return this.right.search(key);
            }
        }
        return false;
    }

    public void printItem() {
        if (this.left != null) {
            this.left.printItem();
        }
        System.out.println(this.key);
        if (this.right != null) {
            this.right.printItem();
        }
    }

}

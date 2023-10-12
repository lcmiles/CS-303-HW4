public class Item {
    private long key;
    private String name;
    private String type;
    private Item left;
    private Item right;

    public Item(long key, String type, String name) {
        this.key = key;
        this.name = name;
        this.type = type; 
        this.left = null;
        this.right = null;
    }

    public long getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addItem(long key, String type, String name) {
        if (key < this.key) {
            if (this.left == null) {
                this.left = new Item(key, type, name);
            } else {
                this.left.addItem(key, type, name);
            }
        } else {
            if (this.right == null) {
                this.right = new Item(key, type, name);
            } else {
                this.right.addItem(key, type, name);
            }
        }
    }
    

    public boolean search(long key) {
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

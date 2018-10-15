package treenode;

import java.util.LinkedList;
import java.util.List;

/**
 * This class intended for building of a tree
 *
 * ATTENTION don`t use one with LAMBOK ANNOTATION
 *
 * @author Glushenkov Yuri
 *
 * @param <T> - item of a tree
 */
public class ItemNode<T> {
    public ItemNode(ItemNode<T> parent, T data) {

        this.parent = parent;
        this.data = data;
    }

    public ItemNode(T current) {
        this.data = current;
        this.children = new LinkedList<>();
    }

    public ItemNode<T> addChild(T child) {
        ItemNode<T> childNode = new ItemNode<>(child);
        childNode.parent = this;
        this.children.add(childNode);
        checkIsLeaf();
        return childNode;
    }

    private void checkIsLeaf() {
        isLeaf = this.children.size() == 0;
    }

    private ItemNode<T> parent;
    private List<ItemNode<T>> children;
    private T data;
    private boolean isLeaf;

    public void setParent(ItemNode<T> parent) {
        this.parent = parent;
    }

    public List<ItemNode<T>> getChildren() {
        checkIsLeaf();
        return children;
    }

    public void setChildren(List<ItemNode<T>> children) {
        checkIsLeaf();
        this.children = children;
    }

    public T getData() {

        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ItemNode{" +
                "parent=" + parent +
                ", data=" + getData() +
                '}';
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }
}

package bst;

public class MyBSTImpl<T extends Comparable<T>> implements MyBST<T> {

    private TreeNode<T> root;

    @Override
    public void add(T value) {
        root = add(value, root);
    }

    private TreeNode<T> add(T value, TreeNode<T> root) {
        TreeNode result = null;

        if (root == null) {
            TreeNode<T> newNode = new TreeNode(value);
            result = newNode;
        } else if (value.compareTo(root.getValue()) > 0) {
            root.setRight(add(value, root.getRight()));
            result = root;
        } else if (value.compareTo(root.getValue()) < 0) {
            root.setLeft(add(value, root.getLeft()));
            result = root;
        }
        return result;
    }

    @Override
    public void remove(T value) {
        root = remove(value, root);
    }

    private TreeNode<T> remove(T value, TreeNode<T> root) {
        TreeNode<T> result = root;

        if (root == null)  {
            // Nothing to do
        } else if (value.compareTo(root.getValue()) < 0) {
            root.setLeft(remove(value, root.getLeft()));
        } else if (value.compareTo(root.getValue()) > 0) {
            root.setRight(remove(value, root.getRight()));
        } else {

            if (root.getLeft() != null) {

                T candidate = getMax(root.getLeft());
                root.setValue(candidate);
                root.setLeft(remove(candidate, root.getLeft()));

            } else {

                T candidate = getMin(root.getRight());
                root.setValue(candidate);
                root.setRight(remove(candidate, root.getRight()));

            }


        }

        return result;
    }

    private T getMin(TreeNode<T> root) {
        T result = null;

        if (root.getLeft() == null) {
            result = root.getValue();
        } else {
            result = getMin(root.getLeft());
        }

        return result;
    }

    private T getMax(TreeNode<T> root) {
        T result = null;

        if (root.getRight() == null) {
            result = root.getValue();
        } else {
            result = getMax(root.getRight());
        }

        return result;
    }
}

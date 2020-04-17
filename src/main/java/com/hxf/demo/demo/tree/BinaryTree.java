package com.hxf.demo.demo.tree;

import java.util.List;

/**
 * <p>
 *  二叉树工具类
 * </p>
 *
 * @author hechengxi@iqingka.com
 * @date 2020年04月16日 20:04
 */

public class BinaryTree<T extends Comparable<T>> {
    /**
     * 根节点
     */
    private Node root;


    class Node {
        //节点数据
        private T data;
        //左子节点
        private Node leftChild;
        //右子节点
        private Node rightChild;

        // 构造方法
        public Node(T data) {
            this.data = data;
        }


    }

    public Node root() {
        return root;
    }

    /**
     * 薪资
     *
     * @param data
     * @return
     */
    public boolean add(T data) {
        if (exist(data)) {
            return Boolean.FALSE;
        }
        Node node = new Node(data);
        if (null == root) {
            root = node;
            return Boolean.TRUE;
        }
        //获取父节点
        Node parentNode = getPrentNode(data);
        //更新节点
        if (parentNode.data.compareTo(data) > 0) {
            parentNode.leftChild = node;
        } else {
            parentNode.rightChild = node;
        }
        //插入节点
        return Boolean.TRUE;
    }

    /**
     * 前序遍历
     *
     * @param treeNode
     * @param qianxuNumList
     */
    public void qinaxuDigui(Node treeNode, List<T> qianxuNumList) {
        qianxuNumList.add(treeNode.data);
        if (treeNode.leftChild != null) {
            qinaxuDigui(treeNode.leftChild, qianxuNumList);
        }
        if (treeNode.rightChild != null) {
            qinaxuDigui(treeNode.rightChild, qianxuNumList);
        }
    }


    /**
     * 中序遍历
     *
     * @param treeNode
     * @param zhongxuNumList
     */
    public void zhongxuDigui(Node treeNode, List<T> zhongxuNumList) {
        if (treeNode.leftChild != null) {
            zhongxuDigui(treeNode.leftChild, zhongxuNumList);
        }
        zhongxuNumList.add(treeNode.data);
        if (treeNode.rightChild != null) {
            zhongxuDigui(treeNode.rightChild, zhongxuNumList);
        }
    }

    /**
     * 后序遍历
     *
     * @param treeNode
     * @param houxuNumList
     */
    public void houxuDigui(Node treeNode, List<T> houxuNumList) {
        if (treeNode.leftChild != null) {
            houxuDigui(treeNode.leftChild, houxuNumList);
        }
        if (treeNode.rightChild != null) {
            houxuDigui(treeNode.rightChild, houxuNumList);
        }
        houxuNumList.add(treeNode.data);
    }

    /**
     * 获取当前节点
     *
     * @param data
     * @return
     */
    private Node getNode(T data) {
        Node tempNode = root;
        while (tempNode != null) {
            if (tempNode.data.compareTo(data) == 0) {
                return tempNode;
            }
            if (tempNode.data.compareTo(data) > 0) {
                tempNode = tempNode.leftChild;
            } else {
                tempNode = tempNode.rightChild;
            }
        }
        return null;
    }

    public boolean remove(T data) {
        Node node = getNode(data);
        if (node == null) {
            return Boolean.FALSE;
        }
        if (root == node) {
            if (node.rightChild == null && node.leftChild == null) {
                root = null;
            } else if (node.rightChild != null && node.leftChild == null) {
                root = node.rightChild;
            } else if (node.rightChild == null) {
                root = node.leftChild;
            } else {
                root = split(data);
            }
        } else {
            //获取父节点
            Node parentNode = getPrentNode(data);
            if (node.rightChild == null && node.leftChild == null) {
                //如果父节点大于当前节点
                if (parentNode.data.compareTo(node.data) > 0) {
                    parentNode.leftChild = null;
                } else {
                    parentNode.rightChild = null;
                }
            } else if (node.rightChild != null && node.leftChild == null) {
                // 右节点不为空
                parentNode.rightChild = node.rightChild;
            } else if (node.rightChild == null) {
                // 左节点部位空
                parentNode.leftChild = node.leftChild;
            } else {
                // 左右节点不为空
                parentNode.leftChild = node.leftChild;
            }
        }
        return false;
    }

    private Node split(T data) {
        Node node = getNode(data);
        //找到左节点的最大数节点
        Node big = getBigNode(node.leftChild);
        //将big的右节点指向node的右节点
        big.rightChild = node.rightChild;
        return node.leftChild;

    }

    public Node getBigNode(Node node) {
        Node tempNode = node;
        while (tempNode != null) {
            if (tempNode.rightChild == null) {
                return tempNode;
            }
            tempNode = tempNode.rightChild;
        }

        return null;
    }

    /**
     * 获取父节点
     *
     * @param data
     * @return
     */
    private Node getPrentNode(T data) {
        Node tempNode = root;
        Node prentNode = tempNode;
        while (tempNode != null) {
            //跳出循环时，temp 为 null，prev记录上一个节点，即为parent
            prentNode = tempNode;
            //如果父节点数据大当前节点
            if (prentNode.data.compareTo(data) > 0) {
                tempNode = prentNode.leftChild;
            } else {
                tempNode = prentNode.rightChild;
            }
        }
        return prentNode;
    }

    /**
     * 节点是否存在
     *
     * @param data
     * @return
     */
    public boolean exist(T data) {
        boolean flag = false;
        //从根节点开始遍历
        Node temp = root;
        while (temp != null) {
            if (temp.data.compareTo(data) == 0) {
                flag = true;
            } else if (temp.data.compareTo(data) > 0) {
                temp = temp.leftChild;
            } else {
                temp = temp.rightChild;
            }
        }
        return flag;
    }

    /**
     * 创建二叉树
     *
     * @param list
     * @return
     */
    public static BinaryTree createBinaryTree(List<Integer> list) {
        BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
        for (Integer integer : list) {
            binaryTree.add(integer);
        }
        return binaryTree;
    }


}

package com.B1_CodingInterviews.N08_NextNode;

/**
 * 二叉树的下一个节点
 * 牛客网测试：https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&tqId=11210&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class NextNodeBinaryTree {

    public static TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (null == pNode)
            return null;

        TreeLinkNode next = null;
        if (null != pNode.right) {  //1.有右子树
            TreeLinkNode temp = pNode.right;
            while (null != temp.left) {
                temp = temp.left;
            }
            next = temp;
        } else if (null != pNode.next) {
            TreeLinkNode parent = pNode.next;
            TreeLinkNode current = pNode;
            while (null != current.next && parent.right == current) { //2.无右子树，且该节点是父节点的右子节点
                parent = parent.next;
                current = current.next;
            }
            next = parent;   //3.无右子树，且该节点是父节点的左子结点
        }

        return next;
    }

    static class TreeLinkNode {
        TreeLinkNode next;  //parent，为了在牛客上进行测试
        TreeLinkNode left;
        TreeLinkNode right;
        int value;

        public TreeLinkNode(int value) {
            this.value = value;
        }
    }
}

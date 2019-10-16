package com.Z1_DataStructureAndAlgorithmAnalysisInC;


/**
 * P032：链表的Java实现
 */
public class P032_LinkedList {
    Object object = new Object();
}

interface LinkedList{
    /**
     * 插入节点
     * @param data
     * @param position
     * @return
     */
    Node addNode(String data, int position);

    /**
     * 删除节点(索引)
     * @param position
     * @return
     */
    Node deleteNode(int position);

    /**
     * 删除节点(内容)
     * @param data
     * @return
     */
    Node deleteNode(String data);

    /**
     * 更新节点数据
     * @param position
     * @param newData
     * @return
     */
    Node updateNode(int position, String newData);

    /**
     * 查询某个节点数据
     * @param position
     * @return
     */
    String find(int position);


}


/**
 * 链表节点
 */
class Node {
    private String data;
    private Node next;
}

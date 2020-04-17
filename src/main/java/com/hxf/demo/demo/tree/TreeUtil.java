package com.hxf.demo.demo.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * TreeUtil
 * </p>
 *
 * @author hechengxi@iqingka.com
 * @date 2020年04月16日 20:05
 */
@Slf4j
public class TreeUtil {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(13, 65, 5, 97, 25, 37, 22, 4, 28, 32);
        BinaryTree binaryTree = BinaryTree.createBinaryTree(list);
        log.info("binaryTree={}", binaryTree);
        binaryTree.remove(13);
        List<Integer> list1 =  new ArrayList();
        binaryTree.qinaxuDigui(binaryTree.root(), list1);
        log.info("中序遍历={}", list1);
        List<Integer> list2 =  new ArrayList();
        binaryTree.zhongxuDigui(binaryTree.root(), list2);
        log.info("前序遍历={}", list2);
        List<Integer> list3 =  new ArrayList();
        binaryTree.houxuDigui(binaryTree.root(), list3);
        log.info("后序遍历={}", list3);
    }


}

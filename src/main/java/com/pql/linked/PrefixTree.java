package com.pql.linked;


/**
 * 前缀树实现
 *
 * @author pengqinglong
 * @since 2023/1/6 15:15
 */
public class PrefixTree {

    private final char value;

    private int count;

    private int end;

    private final PrefixTree[] tree = new PrefixTree[26];

    public PrefixTree(){
        value = 0;
    }

    public PrefixTree(char c){
        value = c;
        count++;
    }

    public static void main(String[] args) {
        PrefixTree prefixTree = new PrefixTree();
        prefixTree.add("abc");
        prefixTree.add("abcd");
        prefixTree.add("abc");
        prefixTree.add("ab");
        prefixTree.add("wolegequ");

        System.out.println(prefixTree.contains("abc"));
        System.out.println(prefixTree.contains("a"));

    }

    public void add(String str){
        if(str == null || str.equals("")){
            return;
        }

        char[] strCharArr = str.toCharArray();
        PrefixTree cur = this;
        for (int i = 0; i < strCharArr.length; i++) {
            int index = strCharArr[i] - 'a';
            if (cur.tree[index] == null) {
                cur.tree[index] = new PrefixTree(strCharArr[i]);
                cur = cur.tree[index];
            } else {
                cur = cur.tree[index];
                cur.count++;
            }
        }
        cur.end++;
    }

    public boolean contains(String str){
        PrefixTree cur = this;
        for (char c : str.toCharArray()) {
            int index = c - 'a';
            if (cur.tree[index] == null || cur.tree[index].count == 0) {
                return false;
            }
            cur = cur.tree[index];
        }
        return cur.end > 0;
    }

}

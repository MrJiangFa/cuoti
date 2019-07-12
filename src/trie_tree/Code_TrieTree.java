package trie_tree;

import java.util.HashSet;

/**
 * trie树：字典树
 * 应用：搜索引擎中输入关键词，会列出具有公共前缀的信息；
 *
 */
public class  Code_TrieTree {
    public static class TrieNode {
        public int path;//有多少路径划过该节点
        public int end;//有多少字符以该节点结尾
        public TrieNode[] nexts;//后继节点

        public TrieNode() {
            this.path = 0;
            this.end = 0;
            this.nexts = new TrieNode[26];//假定前缀树中只可能出现a-z这26个字符
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chas = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chas.length; i++) {
                index = chas[i] - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.path++;
            }
            node.end++;
        }

        //查询一个word出现几次
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        public void delete(String word) {
            if (search(word) != 0) {
                char[] chs = word.toCharArray();
                TrieNode node = root;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (--node.nexts[i].path == 0) {
                        node.nexts[i] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i]-'a';
                if(node.nexts[index].path==0){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.path;
        }
    }
}

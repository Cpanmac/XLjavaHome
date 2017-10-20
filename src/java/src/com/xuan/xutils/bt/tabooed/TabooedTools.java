package com.xuan.xutils.bt.tabooed;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ���дʻ���˹����࣬ʹ���� <a href="http://zh.wikipedia.org/wiki/ȷ������״̬�Զ���">DFA</a> �㷨��ʵ�ִʻ���ˡ�
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����10:23:37 $
 */
public class TabooedTools {
    private static final TabooedTools instance = new TabooedTools();
    private final Node rootNode = new Node('R');
    private Collection<String> tabooedWords;

    private TabooedTools() {
        initialize();
    }

    public static TabooedTools getInstance() {
        return instance;
    }

    /**
     * �ж��ַ��Ƿ���Ӣ����ĸ.
     *
     * @param c �ַ�
     * @return true/false
     */
    private static boolean isAlpha(char c) {
        return c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z';
    }

    public synchronized void initialize() {
        TabooedWords tws = new TabooedWords();
        tws.initialize();
        tabooedWords = tws.getTabooedWords();
        // �����ַ��ڵ���
        createNodeTree();
    }

    public List<String> getTabooedWords(String content) {
        Set<String> tabooedWords4Content = new LinkedHashSet<String>();
        searchWord(content, tabooedWords4Content);
        return new ArrayList<String>(tabooedWords4Content);
    }

    private void searchWord(String content, Set<String> tabooedWords4Content) {
        // ����Ǽ����м�״̬�б�
        List<Character> tempWords = new ArrayList<Character>();
        int index = 0;
        Node node = rootNode;
        char[] chars = content.toCharArray();
        while (index < chars.length) {
            char currentChar = chars[index];
            node = findNode(node, currentChar);
            if (node == null) { // ����Ҳ��������ڵ�����л���
                node = rootNode;
                index = index - tempWords.size();
                tempWords.clear();
            } else if (isNodeFinish(node, index, chars, tempWords.size())) {
                // ����ڵ��ս�Ļ�, �ͽ����дʻ㱣�浽�������
                StringBuilder sb = new StringBuilder();
                tempWords.add(currentChar);
                for (char c : tempWords) {
                    sb.append(c);
                }
                tabooedWords4Content.add(sb.toString());
                index = index - tempWords.size() + 1;
                tempWords.clear();
                node = rootNode;
            } else { // �ҵ�ƥ��������ַ��󽫵�ǰ�ַ����浽��ʱ�б���
                tempWords.add(currentChar);
            }
            index++;
        }
    }

    /**
     * �ж��ַ��ڵ��Ƿ��ս�.
     *
     * @param node
     * @param index
     * @param chars
     * @param matchCount
     * @return true/false
     */
    private boolean isNodeFinish(Node node, int index, char[] chars, int matchCount) {
        boolean isFinish = (node.flag == Node.FLAG_FINISH);
        if (!isFinish) {
            return false;
        }
        isFinish = (index == chars.length - 1 || !isAlpha(chars[index + 1]));
        if (!isFinish) {
            return false;
        }
        if (index - 1 - matchCount < 0) {
            return true;
        }
        return (index == 1 || !isAlpha(chars[index - 1 - matchCount]));
    }

    /**
     * ���������ַ��Ľڵ���
     */
    private void createNodeTree() {
        for (String str : tabooedWords) {
            char[] chars = str.toCharArray();
            if (chars.length > 0) {
                insertNode(rootNode, chars, 0);
            }
        }
    }

    /**
     * �����ַ��ڵ�.
     *
     * @param parent ���ڵ�
     * @param chars  �����ַ�����char����
     * @param index  �������ַ�������
     */
    private void insertNode(Node parent, char[] chars, int index) {
        Node node = findNode(parent, chars[index]);
        // ����Ҳ����Ѿ����ڵĽڵ�, �򴴽�һ���ڵ�
        if (node == null) {
            node = new Node(chars[index]);
            parent.addChild(node);
        }
        // ��������һ���ַ�, �򽫽ڵ���Ϊ����
        if (index == (chars.length - 1)) {
            node.flag = Node.FLAG_FINISH;
        } else {
            insertNode(node, chars, ++index);
        }
    }

    /**
     * ������ڵ���ӽڵ�
     */
    private void clearNode() {
        rootNode.getChilds().clear();
    }

    /**
     * �����ַ��ڵ�.
     *
     * @param parent ���ڵ�
     * @param c      �ַ�
     * @return ���غ��ַ���ƥ��Ľڵ�
     */
    private Node findNode(Node parent, char c) {
        if (c >= 'A' && c <= 'Z') {
            c = (char) (c + 32);
        }
        Node node = parent.getChild(c);
        return node;
    }

    public Collection<String> getTabooedWords() {
        return tabooedWords;
    }

    public synchronized void setTabooedWords(Collection<String> tabooedWords) {
        this.tabooedWords = tabooedWords;
        clearNode();
        // �����ַ��ڵ���
        createNodeTree();
    }

    /**
     * ��ʾһ���ַ��ڵ����.
     */
    private static class Node {
        static final int FLAG_CONTINUE = 0; // ��������ַ�����
        static final int FLAG_FINISH = 1; // ��������ַ��ս�
        char c;
        int flag;
        Map<Character, Node> nodeMap = new HashMap<Character, Node>();

        Node(char c) {
            this(c, FLAG_CONTINUE);
        }

        Node(char c, int flag) {
            this.c = c;
            this.flag = flag;
        }

        void addChild(Node node) {
            nodeMap.put(node.c, node);
        }

        Node getChild(char c) {
            return nodeMap.get(c);
        }

        Map<Character, Node> getChilds() {
            return nodeMap;
        }
    }
}

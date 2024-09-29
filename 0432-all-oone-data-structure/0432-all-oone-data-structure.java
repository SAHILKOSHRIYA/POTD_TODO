import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class AllOne {

    private class Node {
        int count;
        Set<String> keys;
        Node prev, next;

        Node(int count) {
            this.count = count;
            keys = new HashSet<>();
        }
    }

    private Node head, tail;
    private Map<String, Integer> keyCountMap;
    private Map<Integer, Node> countNodeMap;

    public AllOne() {
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;

        keyCountMap = new HashMap<>();
        countNodeMap = new HashMap<>();
    }

    public void inc(String key) {
        int count = keyCountMap.getOrDefault(key, 0);
        int newCount = count + 1;
        keyCountMap.put(key, newCount);

        Node currentNode = countNodeMap.get(count);
        Node newNode = countNodeMap.get(newCount);

        if (newNode == null) {
            newNode = new Node(newCount);
            countNodeMap.put(newCount, newNode);
            insertAfter(currentNode == null ? head : currentNode, newNode);
        }

        newNode.keys.add(key);

        if (currentNode != null) {
            currentNode.keys.remove(key);
            if (currentNode.keys.isEmpty()) {
                removeNode(currentNode);
                countNodeMap.remove(count);
            }
        }
    }

    public void dec(String key) {
        if (!keyCountMap.containsKey(key)) {
            return;
        }

        int count = keyCountMap.get(key);
        int newCount = count - 1;
        keyCountMap.remove(key);

        Node currentNode = countNodeMap.get(count);
        if (currentNode == null) {
            return;
        }

        if (newCount > 0) {
            keyCountMap.put(key, newCount);
            Node newNode = countNodeMap.get(newCount);
            if (newNode == null) {
                newNode = new Node(newCount);
                countNodeMap.put(newCount, newNode);
                insertAfter(currentNode.prev, newNode);
            }
            newNode.keys.add(key);
        }

        currentNode.keys.remove(key);
        if (currentNode.keys.isEmpty()) {
            removeNode(currentNode);
            countNodeMap.remove(count);
        }
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }

    private void insertAfter(Node prevNode, Node newNode) {
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}


/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
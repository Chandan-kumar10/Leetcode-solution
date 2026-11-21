import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        List<List<Integer>> initialTree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            initialTree.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            initialTree.get(parent[i]).add(i);
        }

        int[] newParent = Arrays.copyOf(parent, n);
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);

        assignNewParents(0, s, initialTree, lastSeen, newParent);

        List<List<Integer>> updatedTree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            updatedTree.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            updatedTree.get(newParent[i]).add(i);
        }

        int[] answer = new int[n];
        computeSubtreeSizes(0, updatedTree, answer);
        return answer;
    }

    private void assignNewParents(
            int node,
            String s,
            List<List<Integer>> tree,
            int[] lastSeen,
            int[] newParent) {
        int charIndex = s.charAt(node) - 'a';
        if (lastSeen[charIndex] != -1) {
            newParent[node] = lastSeen[charIndex];
        }

        int previousAncestor = lastSeen[charIndex];
        lastSeen[charIndex] = node;

        for (int child : tree.get(node)) {
            assignNewParents(child, s, tree, lastSeen, newParent);
        }

        lastSeen[charIndex] = previousAncestor;
    }

    private int computeSubtreeSizes(int node, List<List<Integer>> tree, int[] answer) {
        int size = 1;
        for (int child : tree.get(node)) {
            size += computeSubtreeSizes(child, tree, answer);
        }
        answer[node] = size;
        return size;
    }
}
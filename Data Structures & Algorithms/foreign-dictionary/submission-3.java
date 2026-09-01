class Solution {
    public String foreignDictionary(String[] words) {
        ArrayList<Integer>[] graph = new ArrayList[26];
        int[] inDegree = new int[26];
        for (int i = 0; i < 26; i++) {
            graph[i] = new ArrayList<>();
            inDegree[i] = -1;
        }

        int uniqueChars = 0;
        // Mark all characters that appear at least once
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (inDegree[c - 'a'] == -1) {
                    inDegree[c - 'a'] = 0;
                    uniqueChars++;
                }
            }
        }

        // Build graph edges
        for (int i = 0; i < words.length - 1; i++) {
            int[] edge = edges(words[i], words[i + 1]);
            if (edge != null) {
                if (edge[0] == -1 && edge[1] == -1) {
                    return "";
                }
                if (!graph[edge[0]].contains(edge[1])) { // avoid duplicates
                    graph[edge[0]].add(edge[1]);
                    inDegree[edge[1]]++;
                }
            }
        }

        String ans = "";
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        int visited_count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited_count++;
            ans = ans + (char) (node + 'a');
            for (int ne : graph[node]) {
                inDegree[ne]--;
                if (inDegree[ne] == 0) {
                    queue.add(ne);
                }
            }
        }

        return visited_count == uniqueChars ? ans : "";
    }

    public int[] edges(String word1, String word2) {
        int minLen = Math.min(word1.length(), word2.length());
        for (int i = 0; i < minLen; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                int[] edge = new int[2];
                edge[0] = word1.charAt(i) - 'a';
                edge[1] = word2.charAt(i) - 'a';
                System.out.println(word1.charAt(i) + "->" + word2.charAt(i));
                return edge;
            }
        }
        // If word2 is a prefix of word1 → invalid
        if (word1.length() > word2.length()) {
            return new int[]{-1, -1};
        }
        return null; // identical words or no differing chars → valid, no edge
    }
}

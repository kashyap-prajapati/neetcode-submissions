class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Set<String> set = new HashSet<String>();
        for(String word:wordList){
            set.add(word);
        }
        queue.add(new Pair<>(beginWord, 1));
        set.remove(beginWord);
        int steps=1;
        while(!queue.isEmpty()){
            Pair<String, Integer> p = queue.poll();
            String curr_word = p.getKey();
            steps = p.getValue();
            if(curr_word.equals(endWord)){
                return steps;
            }
            for(int i=0;i<curr_word.length();i++){
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = curr_word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if (set.contains(replacedWord) == true) {
                        set.remove(replacedWord);
                        queue.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }
        return 0;

    }
}

public class Palindrome {
    
    public Deque<Character> wordToDeque(String word){
        /*
         * word:        persiflage
         * rtn:         [p,e,r,s,i,f,l,a,g,e]
         */
        LinkedListDeque<Character> dq = new LinkedListDeque<>();
        for (int i=0; i<word.length(); i++){
            dq.addLast(word.charAt(i));
        }
        return dq;
    }

    public boolean isPalindrome(String word){
        Deque dq = wordToDeque(word);
        while (! dq.isEmpty() && dq.size() > 1){
            Object front = dq.removeFirst();
            Object end = dq.removeLast();
            if ((char) front != (char) end){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque dq = wordToDeque(word);
        while (! dq.isEmpty() && dq.size() > 1){
            Object front = dq.removeFirst();
            Object end = dq.removeLast();
            if (! cc.equalChars((char) front, (char) end)){
                return false;
            }
        }
        return true;
    }

}

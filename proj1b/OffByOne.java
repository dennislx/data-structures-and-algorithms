public class OffByOne implements CharacterComparator{

    /*
     * return True if two characters are off by exactly 1 char distance
     * 
     * >> OffByOne obo = new OffByOne();
     * >> obo.equalChars('a', 'b'); //return true
     * >> 
     */
    @Override
    public boolean equalChars(char x, char y){ 
        if ((x-y==1) || (y-x)==1){
            return true;
        }
        return false;
    }

    private static void main(String[] args) {
        char x = '&';
        int y = (int) x + 1;
        System.out.print(String.format("char %s: %d", (char) y, y));
    }

}

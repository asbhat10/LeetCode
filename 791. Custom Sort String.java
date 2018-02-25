class Solution {
    public String customSortString(String S, String T) {
        if(T.length() == 0 || S.length()==0)
            return T;

        Character t[] = new Character[T.length()];
        for (int i = 0; i < T.length(); i++) {
            t[i] = T.charAt(i);
        }
        int[] pos = new int[26];
        Arrays.fill(pos,Integer.MAX_VALUE);
        for(int i=0;i<S.length();i++){
            pos[S.charAt(i)-'a'] = i;
        }

        Arrays.sort(t, new Comparator<Character>(){

            @Override
            public int compare(Character c1, Character c2)
            {
                return pos[c1-'a']-pos[c2-'a'];
            }
        });

        StringBuffer buf = new StringBuffer();
        for(int i=0;i<t.length;i++){
            buf.append(t[i]);
        }
        return buf.toString();
    }
}

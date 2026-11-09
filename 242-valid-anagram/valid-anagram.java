class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> hmS=new HashMap<>();
        HashMap<Character,Integer> hmT=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            hmS.put(ch,hmS.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            hmT.put(ch,hmT.getOrDefault(ch,0)+1);
        }
        if(hmS.equals(hmT)) return true;
        else return false;
    }
}
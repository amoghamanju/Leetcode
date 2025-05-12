class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        if(digits.isEmpty()) return result;
        String [] map={
             "",     "",     "abc",  "def",
            "ghi",  "jkl",  "mno",  "pqrs",
            "tuv",  "wxyz"
        };
        backtrack(digits, 0, new StringBuilder(),map, result);
        return result;
    }
    private void  backtrack(String digits, int index, StringBuilder current, String[] map,List<String> res)
    {
        if(index==digits.length()){
            res.add(current.toString());
            return;
        }
        String letters = map[digits.charAt(index) - '0'];
        for(char c: letters.toCharArray())
        {
            current.append(c);
            backtrack(digits,index+1,current,map,res);
            current.deleteCharAt(current.length()-1);
        }

    }
}
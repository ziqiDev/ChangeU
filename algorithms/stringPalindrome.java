    public char[] manacherString(String str) {
        char[] chars = str.toCharArray();
        char[] res = new char[chars.length * 2 + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = ((i & 1) == 0) ? '#':chars[i/2];
        }
        return res;
    }

    public int longestParadrome(String str){
        if(str==null||str.length()<1){
            return 0;
        }
        char[] chars = manacherString(str);
        int index = -1;
        int pr = -1;
        int[]prArr = new int[chars.length];
        int max = Integer.MIN_VALUE;
        for( int i = 0;i<chars.length;i++){
            prArr[i] = pr>i? Math.min(prArr[index*2-i],pr-i): 1;
            while(i+prArr[i]<chars.length&&i-prArr[i]>-1){
                if(chars[i+prArr[i]]==chars[i-prArr[i]]){
                    prArr[i]++;
                }else {
                    break;
                }
            }
            if(i+prArr[i]>pr){
                pr = i+ prArr[i];
                index = i;
            }
            max = Math.max(max,prArr[i]);
        }
        return max-1;
    }


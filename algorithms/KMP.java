    public int getIndexOf(String s, String m){
        if(s==null||m==null||m.length()>s.length()||m.length()<1){
            return -1;
        }
        char[]ss = s.toCharArray();
        char[]mm = m.toCharArray();
        int si = 0;
        int mi = 0;
        int[] next = getNext(mm);
        while(si<ss.length&&mi<mm.length){
            if(ss[si]==mm[mi]){
                si++;
                mi++;
            }else if(next[mi]==-1){
                si++;
            }else{
                mi = next[mi];
            }
        }
        return mi == mm.length? si-mi: -1;
    }
    public int[] getNext(char[] ms){
        if (ms.length==1){
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos <next.length){
            if(ms[pos-1]==ms[cn]){
                next[pos++] = ++cn;
            }else if(cn>0){
                cn = next[cn];
            }else{
                next[pos++] =0;
            }
        }
        return next;
    }
